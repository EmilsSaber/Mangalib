package kg.example.mangalib.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import kg.example.mangalib.data.remote.modelApi.Result
import kg.example.mangalib.databinding.FragmentTopMangaBinding
import kg.example.mangalib.presentation.base.BaseFragment

import org.koin.androidx.viewmodel.ext.android.viewModel

class TopMangaFragment : BaseFragment<FragmentTopMangaBinding>() {
    private val viewModel: TopMangaViewModel by viewModel()
    private lateinit var adapter: MangaListAdapter
    private var list = arrayListOf<Result>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MangaListAdapter()
    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentTopMangaBinding {
        return FragmentTopMangaBinding.inflate(layoutInflater)
    }

    override fun initView() {
        viewModel.getTopManga()
        viewModel.getTopAllManga.collectState(
            onLoading = {

        },
            Error = {
                Log.e("ololo", "error: ")

            },
            onSuccess = {
                binding.recyclerManga.adapter = adapter
                adapter.add(it)
                Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
                Log.e("ololo", "success: ")
            })
    }


}