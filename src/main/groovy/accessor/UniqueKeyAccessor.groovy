package accessor

import dbobjects.GUniqueKey

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class UniqueKeyAccessor implements Accessor{

    UniqueKeyAccessor() {
        init()
    }


    GUniqueKey[] getUniqueKeys(String catalog, String schemaNamePattern, String tableName = null) {
        def tableCondition = tableName == null ? "*" : tableName
        def sql = """
            SELECT * FROM (
                SELECT
                    pgc.contype as constraint_type,
                    pgc.conname as constraint_name,
                    ccu.table_schema AS table_schema,
                    kcu.table_name as table_name,
                    CASE WHEN (pgc.contype = 'f') THEN kcu.COLUMN_NAME ELSE ccu.COLUMN_NAME END as column_name, 
                    CASE WHEN (pgc.contype = 'f') THEN ccu.TABLE_NAME ELSE (null) END as reference_table,
                    CASE WHEN (pgc.contype = 'f') THEN ccu.COLUMN_NAME ELSE (null) END as reference_col,
                    CASE WHEN (pgc.contype = 'p') THEN 'yes' ELSE 'no' END as auto_inc,
                    CASE WHEN (pgc.contype = 'p') THEN 'NO' ELSE 'YES' END as is_nullable,
                        'integer' as data_type,
                        '0' as numeric_scale,
                        '32' as numeric_precision
                FROM
                    pg_constraint AS pgc
                    JOIN pg_namespace nsp ON nsp.oid = pgc.connamespace
                    JOIN pg_class cls ON pgc.conrelid = cls.oid
                    JOIN information_schema.key_column_usage kcu ON kcu.constraint_name = pgc.conname
                    LEFT JOIN information_schema.constraint_column_usage ccu ON pgc.conname = ccu.CONSTRAINT_NAME 
                    AND nsp.nspname = ccu.CONSTRAINT_SCHEMA
                 UNION
                    SELECT  null as constraint_type , null as constraint_name , 'public' as "table_schema" ,
                    table_name , column_name, null as refrence_table , null as refrence_col , 'no' as auto_inc ,
                    is_nullable , data_type, numeric_scale , numeric_precision
                    FROM information_schema.columns cols 
                    Where 1=1
                    AND table_schema = 'public'
                    and column_name not in(
                        SELECT CASE WHEN (pgc.contype = 'f') THEN kcu.COLUMN_NAME ELSE kcu.COLUMN_NAME END 
                        FROM
                        pg_constraint AS pgc
                        JOIN pg_namespace nsp ON nsp.oid = pgc.connamespace
                        JOIN pg_class cls ON pgc.conrelid = cls.oid
                        JOIN information_schema.key_column_usage kcu ON kcu.constraint_name = pgc.conname
                        LEFT JOIN information_schema.constraint_column_usage ccu ON pgc.conname = ccu.CONSTRAINT_NAME 
                        AND nsp.nspname = ccu.CONSTRAINT_SCHEMA
                    )
                ) as foo
                WHERE constraint_type= 'u' and table_name like ?
            """
        try (Connection cnn = getConnection()) {
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            preparedStatement.setString(1, tableCondition)
            def uniqueKeys = []
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GUniqueKey  key = new GUniqueKey()
                key.name = resultSet.getString("constraint_name")
                key.schema = resultSet.getString("table_schema")
                key.table = resultSet.getString("table_name")
                key.column = resultSet.getString("column_name")
                key.qualifiedName = key.table.toLowerCase() + '.' + key.column.toLowerCase()
                uniqueKeys.add(key)
            }
            return uniqueKeys
        } catch (Exception e ) {
            e.printStackTrace()
        }
        return []
    }

}
