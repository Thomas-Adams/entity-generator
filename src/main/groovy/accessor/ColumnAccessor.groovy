package accessor

import dbobjects.DbTypes
import dbobjects.GColumn

import org.apache.commons.lang3.StringUtils
import org.apache.commons.text.CaseUtils
import utils.TypeMapping

import javax.xml.crypto.Data
import java.sql.DatabaseMetaData

class ColumnAccessor implements Accessor {

    ColumnAccessor() {
        this.connection = new DatabaseAccessor().getConnection()
    }

    def getGColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern ) {
        DatabaseMetaData databaseMetaData = this.connection.getMetaData()
        def types = ["TABLE"] as String[]
        def cols = []
        def result = databaseMetaData.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern)
        while (result.next()) {
            def col = new GColumn()
            col.tableName = tableNamePattern
            col.name = result.getString(GColumn.COLUMN_COL_COLUMN_NAME)
            col.javaName = CaseUtils.toCamelCase(col.name, false, ['_'] as char[])
            col.nullable = result.getBoolean(GColumn.COLUMN_COL_IS_NULLABLE)
            col.autoIncrement = result.getBoolean(GColumn.COLUMN_COL_IS_AUTOINCREMENT)
            col.type = result.getString(GColumn.COLUMN_COL_TYPE_NAME)
			col.sqlType = result.getString(GColumn.COLUMN_COL_DATA_TYPE)	
			col.columnDefinition = result.getString(GColumn.COLUMN_COL_COLUMN_DEF)
            col.javaType = TypeMapping.mappings.get(col.type)
            col.length = result.getInt(GColumn.COLUMN_COL_COLUMN_SIZE)
			col.decimalDigits = result.getInt(GColumn.COLUMN_COL_DECIMAL_DIGITS)
            col.qualifiedName = col.tableName.toLowerCase() + "." + col.name.toLowerCase()
            cols.add(col)
        }
        return cols;
    }
	
	
	
}
