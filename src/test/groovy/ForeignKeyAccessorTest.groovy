import accessor.ForeignKeyAccessor
import org.junit.Test

class ForeignKeyAccessorTest {

    @Test
    void testGetForeignKeys() {
        def foreignKeyAccessor = new ForeignKeyAccessor()
        def foreignKeys = foreignKeyAccessor.getForeignKeysList('attribute_definition')
        assert foreignKeys.size() >0
    }
}
