package kg.example.mangalib.utils

import android.R
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kg.example.mangalib.presentation.ui.fragment.AllMangaFragment
import kg.example.mangalib.presentation.ui.fragment.TopMangaFragment

class ViewPagerAdapter (fm: FragmentManager): FragmentPagerAdapter(fm){
    private val COUNT = 2

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AllMangaFragment()
            1 -> TopMangaFragment()
            else -> AllMangaFragment()
        }
    }

    override fun getCount(): Int {
        return COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Вся манга"
            1 -> return "Топ 100"
        }
        return ""
    }

}