package kg.example.mangalib.utils

import android.app.Application
import kg.example.mangalib.data.repository.Repository

class App: Application() {
    val repository: Repository by lazy {
        Repository()
    }
}