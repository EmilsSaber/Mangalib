package kg.example.mangalib.presentation.ui.activity.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import kg.example.mangalib.databinding.FragmentHomeBinding
import kg.example.mangalib.presentation.base.BaseFragment
import kg.example.mangalib.presentation.ui.fragment.AllMangaViewModel
import kg.example.mangalib.presentation.ui.fragment.TopMangaViewModel
import kg.example.mangalib.utils.ViewPagerAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: AllMangaViewModel by sharedViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }
    override fun initView() {
        setupViewPager()
        binding.searchId.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.getSearchManga(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false           }

        })
    }
    private fun setupViewPager() {
        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(parentFragmentManager)
    }
}