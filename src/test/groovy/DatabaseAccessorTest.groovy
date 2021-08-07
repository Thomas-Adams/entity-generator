import org.junit.Test
import accessor.DatabaseAccessor

import java.sql.ResultSet

class DatabaseAccessorTest {


    @Test
    void testReadProperties() {
        DatabaseAccessor access = new DatabaseAccessor()
        assert access.getProperties() != null
        assert access.getProperties().get(DatabaseAccessor.DB_DATABASE).equals("emerald")
    }

    @Test
    void testGetConnection() {
        DatabaseAccessor access = new DatabaseAccessor()
        assert access.getConnection() != null
    }



}
