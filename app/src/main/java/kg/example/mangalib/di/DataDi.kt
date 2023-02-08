package kg.example.mangalib.di

import kg.example.mangalib.data.repository.MangaRepositoryImpl
import kg.example.mangalib.domein.repository.MangaRepository
import org.koin.dsl.module

val dataModule = module {

    single <MangaRepository>{
        MangaRepositoryImpl(get())
    }


}