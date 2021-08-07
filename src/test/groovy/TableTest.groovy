import dbobjects.GTable
import org.junit.Test

class TableTest {

    @Test
    void testTableName() {
        def table = new GTable()
        table.name = "Tabelle1"
        assert table.name == "Tabelle1"
    }


}
