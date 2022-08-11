import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class DisplayItemTest {

    @Test
    fun displayItemFromFile(){
        val f = kotlin.io.path.createTempFile("tmp", ".txt")

        val di = DisplayItem.fromFile(f.toFile())

        assertEquals(FileType.FILE, di.type)
        assertTrue("""tmp\d+\.txt""".toRegex().containsMatchIn(di.name))
    }
}