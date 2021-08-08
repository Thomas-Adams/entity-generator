package utils

import dbobjects.DbTypes
import dbobjects.GColumn

import java.time.LocalDate
import java.time.LocalDateTime

import org.apache.commons.lang3.StringUtils

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

    public static final oracleMappings = [
            "varchar2" : "String",
            "char" : "String",
            "number" : "BigDecimal",
            "timestamp" : "java.sql.Timestamp",
            "date": "java.sql.Date",
            "nclob": "String",
            "clob": "String",
            "blob": "byte[]",
    ]

    public static String guessJavaType(GColumn column, DbTypes dbType) {
		if (dbType==DbTypes.POSTGRESQL) {
			return mappings.get(column.type)
		} 
		String javaType = oracleMappings.get(column.type)
		if (StringUtils.isNotEmpty(javaType) && "BigDecimal".equalsIgnoreCase(javaType)) {
			if (column.length==1) {
				return "Boolean"
			}
			if (column.decimalDigits>0) {
				return "BigDecimal"
			}
			if (column.length==0) {
				return "Long"
			}
		} 
	}




}
