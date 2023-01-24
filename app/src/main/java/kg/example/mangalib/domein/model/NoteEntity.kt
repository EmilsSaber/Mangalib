package kg.example.mangalib.domein.model

data class NoteEntity(
    val id: Int,
    val title: String,
    val description: String,
    val createAt: Long
)