package accessor

import dbobjects.DbTypes
import dbobjects.GForeignKey
import dbobjects.GPrimaryKey
import dbobjects.GUniqueKey

trait MetaDataQuery extends Accessor{

    DbTypes dbType;


    DbTypes getDbType() {
        return this.dbType
    }

    def setDbType(DbTypes types) {
        this.dbType = types
    }

    abstract GPrimaryKey[] getPrimaryKeys(String catalog, String schemaPattern, String tableNamePattern)

    abstract GUniqueKey[] getUniqueKeys(String catalog, String schemaPattern, String tableNamePattern)

    abstract GForeignKey[] getForeignKeys(String catalog, String schemaPattern, String tableNamePattern)
}
