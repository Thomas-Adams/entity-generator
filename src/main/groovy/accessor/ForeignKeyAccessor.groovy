package accessor

import dbobjects.GForeignKey
import org.apache.commons.lang3.StringUtils

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class ForeignKeyAccessor implements Accessor{

    ForeignKeyAccessor() {
        init()
    }

    GForeignKey[] getForeignKeysList(String catalog, String schemaNamePattern, String tableName) {
        def sql = """
            SELECT
                tc.table_schema, 
                tc.constraint_name, 
                tc.table_name, 
                kcu.column_name, 
                ccu.table_schema AS foreign_table_schema,
                ccu.table_name AS foreign_table_name,
                ccu.column_name AS foreign_column_name 
            FROM 
                information_schema.table_constraints AS tc 
                JOIN information_schema.key_column_usage AS kcu
                ON tc.constraint_name = kcu.constraint_name
                AND tc.table_schema = kcu.table_schema
                JOIN information_schema.constraint_column_usage AS ccu
                ON ccu.constraint_name = tc.constraint_name
                AND ccu.table_schema = tc.table_schema
                WHERE tc.constraint_type = 'FOREIGN KEY' AND tc.table_name=?
            """
        if (StringUtils.isNotEmpty(schemaNamePattern)) {
            sql + """ AND tc.table_schema = ?"""
        }
        try (Connection cnn = getConnection()) {
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            preparedStatement.setString(1, tableName)
            if (StringUtils.isNotEmpty(schemaNamePattern)) {
                preparedStatement.setString(1, schemaNamePattern)
            }
            def foreignKeys = []
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GForeignKey fk = new GForeignKey()
                fk.name = resultSet.getString("constraint_name")
                fk.schema = resultSet.getString("table_schema")
                fk.tableName = resultSet.getString("table_name")
                fk.columnName = resultSet.getString("column_name")
                fk.foreignSchemaName =  resultSet.getString("foreign_table_schema")
                fk.foreignTableName =  resultSet.getString("foreign_table_name")
                fk.foreignColumnName = resultSet.getString("foreign_column_name")
                fk.qualifiedName = fk.tableName.toLowerCase() + '.' + fk.columnName.toLowerCase()
                fk.qualifiedForeignName = fk.foreignTableName.toLowerCase() + '.' + fk.foreignColumnName.toLowerCase()
                foreignKeys.add(fk)
            }
            return foreignKeys
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
