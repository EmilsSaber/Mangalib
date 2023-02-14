package kg.example.mangalib.di

import kg.example.mangalib.domein.usecase.GetAllMangaUseCase
import kg.example.mangalib.domein.usecase.GetSearchMangaUseCase
import kg.example.mangalib.domein.usecase.GetTopMangaUseCase
import org.koin.dsl.module

val domainModule = module {
    factory <GetTopMangaUseCase>{
        GetTopMangaUseCase(get())
    }
    factory {
        GetAllMangaUseCase(get())
    }
    factory {
        GetSearchMangaUseCase(get())
    }
    /*factory {
        val postRepository: MangaRepository =
            MangaRepositoryImpl(get())
        postRepository
    }*/
}