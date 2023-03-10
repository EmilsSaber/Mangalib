package kg.example.mangalib.domein.usecase

import kg.example.mangalib.domein.repository.MangaRepository
import kg.example.mangalib.domein.utils.Resourse
import kotlinx.coroutines.flow.Flow

class GetAllMangaUseCase(private val repository: MangaRepository) {
    fun getAllManga() = repository.getAllManga()

}