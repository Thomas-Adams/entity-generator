package accessor

import dbobjects.GPrimaryKey
import utils.TypeMapping

import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.PreparedStatement
import java.sql.ResultSet


class PrimaryKeyAccessor implements Accessor {



    PrimaryKeyAccessor() {
        init()
    }

    GPrimaryKey[] getPrimaryKeysList(String tableName) {
        def sql = """
                    SELECT 
                        c.column_name, 
                        c.data_type, 
                        tc.constraint_name , 
                        tc.constraint_type, 
                        public.get_primary_sequence(?,c.column_name) key_seq  
                    FROM information_schema.table_constraints tc 
                        JOIN information_schema.constraint_column_usage AS ccu USING (constraint_schema, constraint_name) 
                        JOIN information_schema.columns AS c ON c.table_schema = tc.constraint_schema
                        AND tc.table_name = c.table_name AND ccu.column_name = c.column_name
                        WHERE constraint_type = 'PRIMARY KEY' and tc.table_name = ?;
                  """

        try (Connection cnn = getConnection()) {
            PreparedStatement preparedStatement = cnn.prepareStatement(sql)
            preparedStatement.setString(1, tableName)
            preparedStatement.setString(2, tableName)

            def primaryKeys = []
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GPrimaryKey primaryKey = new GPrimaryKey()
                primaryKey.name = resultSet.getString("constraint_name")
                primaryKey.columnName = resultSet.getString("column_name")
                primaryKey.javaType = TypeMapping.mappings[resultSet.getString("data_type")]
                primaryKey.tableName = tableName
                primaryKey.keySeq = resultSet.getString("key_seq")
                primaryKey.qualifiedName = tableName.toLowerCase() +"." + primaryKey.columnName.toLowerCase()
                primaryKeys.add(primaryKey)
            }
            return primaryKeys
        } catch ( Exception e) {
            e.printStackTrace()
        }
        return []
    }

    GPrimaryKey[] getPrimaryKeysListFormMetaData(String tableName) {
        DatabaseMetaData databaseMetaData = this.connection.getMetaData()
        def result = databaseMetaData.getPrimaryKeys("", "public", tableName)
        def keys = []
        while (result.next()) {
            GPrimaryKey key = new GPrimaryKey()
            key.name = result.getString(GPrimaryKey.PRIMARYKEY_COL_PK_NAME)
            key.columnName = result.getString(GPrimaryKey.PRIMARYKEY_COL_COLUMN_NAME)
            key.keySeq = result.getString(GPrimaryKey.PRIMARYKEY_COL_COLUMN_NAME)
            key.tableName = result.getString(GPrimaryKey.PRIMARYKEY_COL_TABLE_NAME)
            keys.add(key)
        }
        return keys
    }
}
