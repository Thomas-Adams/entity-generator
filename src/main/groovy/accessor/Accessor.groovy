package accessor

import dbobjects.DbTypes

import java.sql.Connection

trait Accessor {

    Connection connection

    DbTypes dbType;


    DbTypes getDbType() {
        return this.dbType
    }

    def setDbType(DbTypes types) {
        this.dbType = types
    }

    def init() {
        this.connection = new DatabaseAccessor().getConnection()
    }


    Connection getConnection() {
        return this.connection
    }
}
