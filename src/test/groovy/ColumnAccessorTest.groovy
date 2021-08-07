import accessor.ColumnAccessor
import accessor.DatabaseAccessor
import org.junit.Test

class ColumnAccessorTest {


    @Test
    void testGetColumns() {
        ColumnAccessor access = new ColumnAccessor()
        def result = access.getGColumns("attribute_definition")
        assert result.size() > 0
    }

}
