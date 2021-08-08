package dbobjects

class GColumn {


    public static final String COLUMN_COL_TABLE_SCHEM="TABLE_SCHEM"
    public static final String COLUMN_COL_TABLE_NAME="TABLE_NAME"
    public static final String COLUMN_COL_COLUMN_NAME="COLUMN_NAME"
    public static final String COLUMN_COL_DATA_TYPE="DATA_TYPE"
    public static final String COLUMN_COL_TYPE_NAME="TYPE_NAME"
    public static final String COLUMN_COL_COLUMN_SIZE="COLUMN_SIZE"
    public static final String COLUMN_COL_BUFFER_LENGTH="BUFFER_LENGTH"
    public static final String COLUMN_COL_DECIMAL_DIGITS="DECIMAL_DIGITS"
    public static final String COLUMN_COL_NUM_PREC_RADIX="NUM_PREC_RADIX"
    public static final String COLUMN_COL_NULLABLE="NULLABLE"
    public static final String COLUMN_COL_REMARKS="REMARKS"
    public static final String COLUMN_COL_COLUMN_DEF="COLUMN_DEF"
    public static final String COLUMN_COL_SQL_DATA_TYPE="SQL_DATA_TYPE"
    public static final String COLUMN_COL_SQL_DATETIME_SUB="SQL_DATETIME_SUB"
    public static final String COLUMN_COL_CHAR_OCTET_LENGTH="CHAR_OCTET_LENGTH"
    public static final String COLUMN_COL_ORDINAL_POSITION="ORDINAL_POSITION"
    public static final String COLUMN_COL_IS_NULLABLE="IS_NULLABLE"
    public static final String COLUMN_COL_SCOPE_CATALOG="SCOPE_CATALOG"
    public static final String COLUMN_COL_SCOPE_SCHEMA="SCOPE_SCHEMA"
    public static final String COLUMN_COL_SCOPE_TABLE="SCOPE_TABLE"
    public static final String COLUMN_COL_SOURCE_DATA_TYPE="SOURCE_DATA_TYPE"
    public static final String COLUMN_COL_IS_AUTOINCREMENT ="IS_AUTOINCREMENT"
    public static final String COLUMN_COL_IS_GENERATEDCOLUMN  = "IS_GENERATEDCOLUMN"


    def name
    def tableName
    def javaName
    def type
    def javaType
    def length
    def nullable
    def primary
    def index
    def foreign
    def autoIncrement
    def qualifiedName
	def decimalDigits
	def sqlType

}
