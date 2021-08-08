import accessor.DatabaseAccessor
import accessor.TableAccessor
import org.junit.Test

import java.sql.ResultSet

class TableAccessorTest {

    @Test
    void testGetTables() {
        TableAccessor access = new TableAccessor()
        def result = access.getGTables("", "public", "gender", "")
        assert result!=null
    }

    @Test
    void testGetGTables() {
        TableAccessor access = new TableAccessor()
        def result = access.getGTables("", "public", "", "")
        assert !result.isEmpty()
    }
}
