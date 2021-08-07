package utils

import java.time.LocalDate
import java.time.LocalDateTime

class TypeMapping {


    public static final mappings = [
            "varchar" : "String",
            "char" : "String",
            "int2" : "short",
            "int4" : "Integer",
            "int8" : "Long",
            "integer" : "Integer",
            "bigserial" : "Long",
            "serial" : "Integer",
            "float4" : "Float",
            "float8" : "Double",
            "timestamp": "java.sql.Timestamp",
            "timestamptz": "java.sql.Timestamp",
            "bytea": "Byte[]",
            "date" : "java.sql.Date",
            "bit" : "Boolean",
            "bool" : "Boolean",
            "text" : "String"
    ]

}
