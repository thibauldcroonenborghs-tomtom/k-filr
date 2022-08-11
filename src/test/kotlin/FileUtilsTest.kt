import kotlin.test.Test
import kotlin.test.assertEquals

internal class FileUtilsTest {

    @Test
    fun testFileTypeFileFromValue(){
        val f = kotlin.io.path.createTempFile(prefix = "tmp", suffix = "txt")

        assertEquals(FileType.FILE, typeFromFile(f.toFile()))
    }

    @Test
    fun testFileTypeDirFromValue(){
        val f = kotlin.io.path.createTempDirectory(prefix = "tmpDir")

        assertEquals(FileType.DIRECTORY, typeFromFile(f.toFile()))
    }

    @Test
    fun testCreateDisplayItemListFromCurrentDir(){
        val tmpDir = kotlin.io.path.createTempDirectory(prefix = "tmpDir")

        val nestedTmpDir = kotlin.io.path.createTempDirectory(directory = tmpDir, prefix = "nestedTmpDir")
        val file1 = kotlin.io.path.createTempFile(directory = tmpDir, prefix = "file1", suffix = ".txt")
        val file2 = kotlin.io.path.createTempFile(directory = tmpDir, prefix = "file2", suffix = ".txt")

        val di = currentDirToDisplayItem(tmpDir)

        assertEquals(3, di.size)
        assertEquals(2, di.filter{ it.type == FileType.FILE }.size)
        assertEquals(1, di.filter{ it.type == FileType.DIRECTORY }.size)
        // test that there are 2 files and 1 dir
    }
}