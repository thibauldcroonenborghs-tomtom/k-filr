import java.io.File
import java.nio.file.Path

enum class FileType(val isDirectory: Boolean) {
    DIRECTORY(true),
    FILE(false);
}

fun typeFromFile(file: File): FileType? {
    return FileType.values()
        .firstOrNull { it.isDirectory == file.isDirectory }
}

//TODO: no permissions on Desktop because no files are displayed?
fun currentDirToDisplayItem(dir: Path): List<DisplayItem> {
    val files = dir.toFile().listFiles()
     if(files?.isNotEmpty() == true){
         return files.filter { it != dir.toFile() }
             .map { DisplayItem.fromFile(it.absoluteFile) }
             .toList()
     }
    return emptyList()
}