package kg.example.mangalib.domein.repository
import kotlinx.coroutines.flow.Flow
import kg.example.mangalib.domein.modelApi.DResult
import kg.example.mangalib.domein.utils.Resourse

interface MangaRepository {

    fun getTopManga():Flow<Resourse<List<DResult>>>
    fun getAllManga():Flow<Resourse<List<DResult>>>

    fun getSearchManga(search:String):Flow<Resourse<List<DResult>>>

}