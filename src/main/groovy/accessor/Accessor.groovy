package accessor

import java.sql.Connection

trait Accessor {

    Connection connection

    def init() {
        this.connection = new DatabaseAccessor().getConnection()
    }


    Connection getConnection() {
        return this.connection
    }
}
