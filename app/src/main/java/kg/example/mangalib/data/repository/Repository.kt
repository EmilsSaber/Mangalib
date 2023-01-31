package kg.example.mangalib.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kg.example.mangalib.data.remote.ApiServise
import kg.example.mangalib.data.remote.RetrofitClient
import kg.example.mangalib.data.remote.modelApi.Result

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class Repository {

    private val apiService: ApiServise by lazy {
        RetrofitClient.create()
    }

    fun getMangaLists(): MutableLiveData<List<Result>> {
        return getMangaList()
    }

    private fun getMangaList(): MutableLiveData<List<Result>> {
        val data = MutableLiveData<List<Result>>()
//        data.value = Resource.loading()
        apiService.getMangaList().enqueue(
            object : Callback<List<Result>> {
                override fun onResponse(
                    call: Call<List<Result>>,
                    response: Response<List<Result>>
                ) {
                    if (response.isSuccessful) {
                        Log.e("ololo", "onResponse:" + response.body())
                        data.value = response.body()
                    }
                }
                override fun onFailure(call: Call<List<Result>>, t: Throwable) {
                    Log.e("ololo", "onFailure:${t.message}")
                }
            }
        )
        return data
    }
}