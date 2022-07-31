data class DisplayItem (
    val type: Type,
    val name: String
)

enum class Type {
    DIRECTORY, FILE
}
