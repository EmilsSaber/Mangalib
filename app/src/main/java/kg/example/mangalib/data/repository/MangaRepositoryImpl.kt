package kg.example.mangalib.data.repository
import kg.example.mangalib.data.mapper.toDResult
import kg.example.mangalib.data.remote.ApiServise
import kg.example.mangalib.domein.modelApi.DResult
import kg.example.mangalib.domein.repository.MangaRepository
import kg.example.mangalib.domein.utils.Resourse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException

class MangaRepositoryImpl(private val apiSer: ApiServise) : MangaRepository {
    override fun getTopManga(): Flow<Resourse<List<DResult>>> = flow {
            emit(Resourse.Loading())
            try {
                val api = apiSer.getTopManga().map {it.toDResult()}
                emit(Resourse.Success(api))
            } catch (ioException: IOException) {
                emit(Resourse.Error(ioException.localizedMessage ?: "Fatal, i don't know"))
            }
        }.flowOn(Dispatchers.IO)

    override fun getAllManga(): Flow<Resourse<List<DResult>>> = flow {
        emit(Resourse.Loading())
        try {
            val api = apiSer.getMangaList().map {it.toDResult()}
            emit(Resourse.Success(api))
        } catch (ioException: IOException) {
            emit(Resourse.Error(ioException.localizedMessage ?: "Fatal, i don't know"))
        }
    }

    override fun getSearchManga(search:String): Flow<Resourse<List<DResult>>> = flow {
        emit(Resourse.Loading())
        try {
            val api = apiSer.getMangaSearch(search).map {it.toDResult()}
            emit(Resourse.Success(api))
        } catch (ioException: IOException) {
            emit(Resourse.Error(ioException.localizedMessage ?: "Fatal, i don't know"))
        }
    }

}