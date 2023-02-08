package kg.example.mangalib.presentation.ui.fragment


import kg.example.mangalib.domein.modelApi.DResult
import kg.example.mangalib.domein.usecase.GetTopMangaUseCase
import kg.example.mangalib.domein.utils.UiState
import kg.example.mangalib.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TopMangaViewModel(private val getTopMangaUseCase: GetTopMangaUseCase): BaseViewModel() {
    private val _getAllTopManga = MutableStateFlow<UiState<List<DResult>>>(UiState.Empty())
    val getTopAllManga = _getAllTopManga.asStateFlow()


    fun getTopManga(){
        getTopMangaUseCase.getTopManga().collectFlow(_getAllTopManga)
    }


}