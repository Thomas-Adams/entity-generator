package accessor

import dbobjects.DbTypes
import dbobjects.GForeignKey
import org.apache.commons.lang3.StringUtils

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class ForeignKeyAccessor implements Accessor{

    MetaDataQuery metaDataQuery;

    ForeignKeyAccessor() {
        init()
        setDbType(DbTypes.POSTGRESQL)
        metaDataQuery = new PostgresqlMetaDataQuery()
    }

    GForeignKey[] getForeignKeysList(String catalog, String schemaNamePattern, String tableName) {
        return metaDataQuery.getForeignKeys(catalog, schemaNamePattern, tableName)
    }
}
