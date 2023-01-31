package kg.example.mangalib.presentation.ui.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.example.mangalib.data.remote.modelApi.Result
import kg.example.mangalib.utils.App


class AllMangaViewModel: ViewModel(){
    fun getMangaList(): MutableLiveData<List<Result>> {
       return App().repository.getMangaLists()
    }
}