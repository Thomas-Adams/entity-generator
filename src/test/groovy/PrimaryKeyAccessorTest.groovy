import accessor.PrimaryKeyAccessor
import org.junit.Test

class PrimaryKeyAccessorTest {

    @Test
    void testGetPrimaryKeys() {
        PrimaryKeyAccessor primaryKeyAccessor = new PrimaryKeyAccessor()
        def primaries = primaryKeyAccessor.getPrimaryKeysList('attribute_definition')
        assert primaries.size() >0
    }
}
