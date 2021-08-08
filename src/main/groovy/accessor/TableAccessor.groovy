package accessor

import dbobjects.GColumn
import dbobjects.GForeignKey
import dbobjects.GPrimaryKey
import dbobjects.GTable
import dbobjects.GUniqueKey
import org.apache.commons.text.CaseUtils

import java.sql.DatabaseMetaData

public class TableAccessor implements Accessor {

    TableAccessor() {
        init()
    }

    def getGTables(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern ) {
        def types = ["TABLE"] as String[]
        def tables = []
        DatabaseMetaData databaseMetaData = connection.getMetaData()
        def tableName = tableNamePattern == null ? "" : tableNamePattern
        def result = databaseMetaData.getTables(catalog, schemaPattern, tableName, types)
        while (result.next()) {
            GTable t = new GTable()
            t.name = result.getString(GTable.COL_TABLE_NAME)
            t.javaName = CaseUtils.toCamelCase(t.name, true, ['_'] as char[])
            t.remarks = result.getString(GTable.COL_TABLE_REMARKS)
            t.schema = result.getString(GTable.COL_TABLE_SCHEMA)
            t.annotations.add("@Table(name=\"${t.name}\")")
            t.annotations.add("@Entity")

            GColumn[] cols = new ColumnAccessor().getGColumns(catalog, schemaPattern, t.name, columnNamePattern)
            t.columns.addAll(cols)
            cols.each {
                col -> t.columnsMap.put(col.qualifiedName, col)
            }

            GPrimaryKey[] primaryKeys = (new PrimaryKeyAccessor()).getPrimaryKeysList( catalog, schemaPattern, t.name)
            t.primaryKeysList.addAll(primaryKeys)
            primaryKeys.each {
                it -> t.primaryKeysMap.put(it.qualifiedName, it)
            }
            if (primaryKeys.size() > 0) {
                t.pk = primaryKeys[0]
            }

            GForeignKey[] foreignKeys = new ForeignKeyAccessor().getForeignKeysList(catalog, schemaPattern, t.name)
            t.foreignKeysList.addAll(foreignKeys)
            foreignKeys.each { t.foreignKeysMap.put(it.qualifiedName, it) }
            foreignKeys.each { t.foreignKeysColumns.put(it.columnName, it) }

            GUniqueKey[] uniqueKeys = new UniqueKeyAccessor().getUniqueKeys(catalog, schemaPattern, t.name)
            t.uniqueKeysList.addAll(uniqueKeys)
            uniqueKeys.each {
                t.uniqueKeysMap.put(it.qualifiedName, it)
                t.uniqueKeysByColumnMap.put(it.qualifiedName, it)
            }

            tables.add(t)
        }
        return tables;
    }

    def getTables() {
        def types = ["TABLE"] as String[]
        DatabaseMetaData databaseMetaData = connection.getMetaData()
        return databaseMetaData.getTables("", "public", "", types)
    }
}
