package metadata

import accessor.TableAccessor
import dbobjects.GForeignKey
import dbobjects.GOutgoingLink
import dbobjects.GTable

class GeneratorMetaData {

    def tableMap = [:]

    def columnMap = [:]

    def foreignKeyMap = [:]

    def uniqueKeyMap = [:]

    def primaryKeyMap = [:]

    GTable[] tables = []

    def outgoingLinksMap = [:]

    def initTables() {
        TableAccessor tableAccessor = new TableAccessor()
        tables = tableAccessor.getGTables()

        tables.each {
            tableMap.put(it.name, it)
            it.columnsMap.entrySet().each {
                columnMap.put(it.key.toString(), it.value)
            }
            it.primaryKeysMap.entrySet().each {
                primaryKeyMap.put(it.key.toString(), it.value)
            }
            it.uniqueKeysMap.entrySet().each {
              uniqueKeyMap.put(it.key.toString(), it.value)
            }
            it.foreignKeysMap.entrySet().each {
                foreignKeyMap.put(it.key.toString(), it.value)
            }
            outgoingLinksMap.put(it.name, outGoingLinks(it.name))
        }
    }

    def getJavaTypeOfForeignKey(GForeignKey foreignKey) {
        return tableMap.get(foreignKey.foreignTableName).javaName
    }

    def getJavaTypeOfForeignKey(String foreignKeyTableName) {
        return tableMap.get(foreignKeyTableName).javaName
    }

    def isForeignKeyUnique(String tableName, String columnName) {
        if (uniqueKeyMap.get(tableName.toLowerCase() + "." + columnName.toLowerCase()) !=null)
            return true;
        return false;
    }

    def outGoingLinks(String tableName) {
        def outgoingLinks = []
        foreignKeyMap.entrySet().each {
            GForeignKey fk =  (GForeignKey)it.value
            if (fk.foreignTableName.equalsIgnoreCase(tableName)) {
                GOutgoingLink link = new GOutgoingLink()
                link.javaType = getJavaTypeOfForeignKey(fk.tableName)
                link.name = fk.tableName
                link.foreignKey = fk
                outgoingLinks.add(link)
            }
        }
        return  outgoingLinks
    }





}
