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

        kotlin.io.path.createTempDirectory(directory = tmpDir, prefix = "nestedTmpDir")
        kotlin.io.path.createTempFile(directory = tmpDir, prefix = "file1", suffix = ".txt")
        kotlin.io.path.createTempFile(directory = tmpDir, prefix = "file2", suffix = ".txt")

        val di = currentDirToDisplayItem(tmpDir)

        assertEquals(3, di.size)
        assertEquals(2, di.filter{ it.type == FileType.FILE }.size)
        assertEquals(1, di.filter{ it.type == FileType.DIRECTORY }.size)
    }

    @Test
    fun testCreateDisplayItemListFromCurrentDirNotEntireNestedDirectory(){
        val tmpDir = kotlin.io.path.createTempDirectory(prefix = "tmpDir")

        val nestedTmpDir = kotlin.io.path.createTempDirectory(directory = tmpDir, prefix = "nestedTmpDir")
        kotlin.io.path.createTempFile(directory = tmpDir, prefix = "file1", suffix = ".txt")
        kotlin.io.path.createTempFile(directory = tmpDir, prefix = "file2", suffix = ".txt")
        kotlin.io.path.createTempFile(directory = nestedTmpDir, prefix = "file2", suffix = ".txt")

        val di = currentDirToDisplayItem(tmpDir)

        assertEquals(3, di.size)
    }

    @Test
    fun testEmptyListIfCurrentDirIsNull(){
        val tmpDir = kotlin.io.path.createTempDirectory(prefix = "tmpDir")

        val di = currentDirToDisplayItem(tmpDir)
        assertEquals(0, di.size)
    }
}