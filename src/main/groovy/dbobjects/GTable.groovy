package dbobjects

import org.apache.commons.text.CaseUtils

class GTable {

    public static final String COL_TABLE_NAME = "TABLE_NAME"
    public static final String COL_TABLE_REMARKS = "REMARKS"
    public static final String COL_TABLE_SCHEMA = "TABLE_SCHEM"

    def imports = [
            "import lombok.AllArgsConstructor;",
            "import lombok.Data;",
            "import lombok.EqualsAndHashCode;",
            "import lombok.NoArgsConstructor;",
            "import lombok.experimental.SuperBuilder;",
            "import org.hibernate.envers.Audited;",
            "import javax.persistence.*;",
            "import javax.validation.constraints.NotNull;",
            "import javax.validation.constraints.Size;",
            "import java.util.ArrayList;",
            "import java.util.List;",
            "import java.io.Serializable;",
            "import java.time.Instant;",
            "import java.time.LocalDateTime;",
            "import java.util.Optional;",
            "import java.util.TimeZone;",

    ]
    def name
    def annotations = []
    def primaryKeysMap = [:]
    def primaryKeysList = []
    def foreignKeysList = []
    def foreignKeysMap = [:]
    def uniqueKeysList = []
    def uniqueKeysMap = [:]
    def uniqueKeysByColumnMap = [:]
    def foreignKeysColumns = [:]
    def indexes = []
    def constraints = []
    def javaName
    def pk
    def remarks
    def schema
    def columns = []
    def columnsMap= [:]

    GPrimaryKey primaryKey = null

    def hasSinglePrimary() {
        return this.primaryKeysList.size() == 1
    }

    def isPrimary(String colName) {
        if (primaryKeysMap.containsValue(colName)) {
            return true
        }
        return false
    }

    def isForeignKey(String columnName) {
        if(foreignKeysColumns.get(columnName)!=null) {
            return true
        }
        return false
    }

    def isAutoIncremented(String colName) {
        if (primaryKeysMap.containsValue(colName)) {
            GPrimaryKey key = primaryKeysMap[colName]
            return (key.keySeq != null)
        }
        return false
    }

    def toCamelCase(String columnName, String foreignTableName) {
        return CaseUtils.toCamelCase(columnName + '_' + foreignTableName, true, ['_'] as char[])
    }



}
