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

fun currentDirToDisplayItem(dir: Path): List<DisplayItem> {
    return dir.toFile()
        .walk()
        .filter { it != dir.toFile() }
        .map { DisplayItem.fromFile(it.absoluteFile) }
        .toList()
}