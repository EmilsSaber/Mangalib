package kg.example.mangalib.utils

import android.app.Application
import kg.example.mangalib.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule, dataModule, domainModule, networkModule)
        }
    }
}