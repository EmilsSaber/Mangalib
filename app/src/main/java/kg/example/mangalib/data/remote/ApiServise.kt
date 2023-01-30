package kg.example.mangalib.data.remote

import kg.example.mangalib.data.remote.modelApi.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiServise {
    @GET("v1/manga")
    fun getMangaList(): Call<List<Result>>
}