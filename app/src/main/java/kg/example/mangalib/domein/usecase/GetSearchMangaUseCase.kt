package kg.example.mangalib.domein.usecase

import kg.example.mangalib.domein.repository.MangaRepository

class GetSearchMangaUseCase(private val mangaRepository: MangaRepository) {
    fun getSearchManga(search:String) = mangaRepository.getSearchManga(search)
}