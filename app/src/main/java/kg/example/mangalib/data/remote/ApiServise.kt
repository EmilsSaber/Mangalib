package kg.example.mangalib.data.remote

import android.icu.text.StringSearch
import kg.example.mangalib.data.remote.modelApi.Result
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiServise {
    @GET("v1/manga")
     suspend fun getMangaList(
    ): List<Result>
     @GET("v1/manga")
     suspend fun getMangaSearch(
        @Query("search") search: String,
    ): List<Result>
     @GET("v1/top-manga")
     suspend fun getTopManga():  List<Result>

}