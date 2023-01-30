package kg.example.mangalib.data.remote.modelApi

data class MangaList(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Result>
)