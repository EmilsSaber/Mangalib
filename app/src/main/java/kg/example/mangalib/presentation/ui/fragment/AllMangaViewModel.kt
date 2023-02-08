package kg.example.mangalib.presentation.ui.fragment
import kg.example.mangalib.domein.modelApi.DResult
import kg.example.mangalib.domein.usecase.GetAllMangaUseCase
import kg.example.mangalib.domein.utils.UiState
import kg.example.mangalib.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class AllMangaViewModel(private val getAllMangaUseCase: GetAllMangaUseCase): BaseViewModel(){
    private val _getAllManga = MutableStateFlow<UiState<List<DResult>>>(UiState.Empty())
    val getAllManga = _getAllManga.asStateFlow()

    fun getAllManga() {
        getAllMangaUseCase.getAllManga().collectFlow(_getAllManga)
    }
}