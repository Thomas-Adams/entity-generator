package accessor

import dbobjects.DbTypes
import dbobjects.GForeignKey
import dbobjects.GPrimaryKey
import dbobjects.GUniqueKey

trait MetaDataQuery extends Accessor{



    abstract GPrimaryKey[] getPrimaryKeys(String catalog, String schemaPattern, String tableNamePattern)

    abstract GUniqueKey[] getUniqueKeys(String catalog, String schemaPattern, String tableNamePattern)

    abstract GForeignKey[] getForeignKeys(String catalog, String schemaPattern, String tableNamePattern)
}
