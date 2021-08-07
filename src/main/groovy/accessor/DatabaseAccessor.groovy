package accessor

import dbobjects.GColumn
import dbobjects.GForeignKey
import dbobjects.GPrimaryKey
import dbobjects.GTable
import org.apache.commons.text.CaseUtils
import org.postgresql.ds.PGSimpleDataSource
import utils.TypeMapping

import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.PreparedStatement
import java.sql.ResultSet

class DatabaseAccessor {

    DatabaseAccessor() {
        initProperties("/dbtools.properties")
        initConnection()
        initMetaData()
    }
    public static final String DB_USERNAME = "dbtools.username"
    public static final String DB_PASSWORD = "dbtools.password"
    public static final String DB_DATABASE = "dbtools.database"
    public static final String DB_URL = "dbtools.url"
    public static final String DB_DRIVER = "dbtools.driverClassName"


    private properties = null

    private Connection connection = null

    private DatabaseMetaData databaseMetaData = null

    private tableColumnCount = 10

    @Override
    Object getProperty(String propertyName) {
        return properties.getProperty(propertyName)
    }

    def initProperties(String fileName) {
        def inputStream = DatabaseAccessor.class.getResourceAsStream(fileName)
        this.properties = new Properties()
        this.properties.load(inputStream)
        return this.properties
    }

    def getProperties() {
        return properties
    }

    def getUsername() {
        return properties.get(DB_USERNAME)
    }

    def getPassword() {
        return properties.get(DB_PASSWORD)
    }

    def getDriverClassName() {
        return properties.get(DB_DRIVER)
    }

    def getUrl() {
        return properties.get(DB_URL)
    }

    def getDatabase() {
        return properties.get(DB_DATABASE)
    }

    def initConnection() {
        def dataSource = new PGSimpleDataSource()
        dataSource.databaseName = getDatabase()
        dataSource.url = getUrl()
        dataSource.user = getUsername()
        dataSource.password = getPassword()
        connection = dataSource.getConnection()
        return connection
    }

    def getConnection() {
        return connection
    }

    def getDatabaseMetaData() {
        return databaseMetaData
    }

    def initMetaData() {
        databaseMetaData = connection.getMetaData()
        return databaseMetaData
    }













}
