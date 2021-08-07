import accessor.DatabaseAccessor
import accessor.TableAccessor
import org.junit.Test

import java.sql.ResultSet

class TableAccessorTest {

    @Test
    void testGetTables() {
        TableAccessor access = new TableAccessor()
        def result = access.getGTables("gender")
        assert result!=null
    }

    @Test
    void testGetGTables() {
        TableAccessor access = new TableAccessor()
        def result = access.getGTables()
        assert !result.isEmpty()
    }
}
