package accessor

import dbobjects.DbTypes
import dbobjects.GForeignKey
import dbobjects.GPrimaryKey
import dbobjects.GUniqueKey

class PostgresqlMetaDataQuery implements MetaDataQuery {

    PostgresqlMetaDataQuery() {
        setDbType(DbTypes.POSTGRESQL)
    }

    @Override
    GPrimaryKey[] getPrimaryKeys(String catalog, String schemaPattern, String tableNamePattern) {
        return null
    }

    @Override
    GUniqueKey[]  getUniqueKeys(String catalog, String schemaPattern, String tableNamePattern) {
        return null
    }

    @Override
    GForeignKey[] getForeignKeys(String catalog, String schemaPattern, String tableNamePattern) {
        return null
    }
}
