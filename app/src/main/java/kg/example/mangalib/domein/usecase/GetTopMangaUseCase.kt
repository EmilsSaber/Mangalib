package kg.example.mangalib.domein.usecase

import kg.example.mangalib.domein.modelApi.DResult
import kg.example.mangalib.domein.repository.MangaRepository
import kg.example.mangalib.domein.utils.Resourse
import kotlinx.coroutines.flow.Flow

class GetTopMangaUseCase(private val mangaRepository: MangaRepository) {

    fun getTopManga() = mangaRepository.getTopManga()
    }
