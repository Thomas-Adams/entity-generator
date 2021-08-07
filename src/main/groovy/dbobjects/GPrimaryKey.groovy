package dbobjects

class GPrimaryKey {


    public static final String PRIMARYKEY_COL_TABLE_CAT="table_cat"
    public static final String PRIMARYKEY_COL_TABLE_SCHEM="table_schem"
    public static final String PRIMARYKEY_COL_TABLE_NAME="table_name"
    public static final String PRIMARYKEY_COL_COLUMN_NAME="column_name"
    public static final String PRIMARYKEY_COL_KEY_SEQ="key_seq"
    public static final String PRIMARYKEY_COL_PK_NAME="pk_name"

    def tableName
    def columnName
    def keySeq
    def name
    def javaType
    def qualifiedName
}
