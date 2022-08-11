import java.io.File

data class DisplayItem (
    val type: FileType,
    val name: String
){

    companion object Item {
        fun fromFile(file: File): DisplayItem {
            return DisplayItem(typeFromFile(file)!!, file.name)
        }
    }

}
