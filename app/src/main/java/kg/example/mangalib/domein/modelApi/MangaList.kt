package kg.example.mangalib.domein.modelApi

data class MangaList(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<DResult>
)