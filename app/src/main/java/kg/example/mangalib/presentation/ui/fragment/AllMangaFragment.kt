package kg.example.mangalib.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import kg.example.mangalib.data.remote.modelApi.Result
import kg.example.mangalib.databinding.FragmentAllMangaBinding
import kg.example.mangalib.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
class AllMangaFragment : BaseFragment<FragmentAllMangaBinding>() {
    private val viewModel: AllMangaViewModel by sharedViewModel()
    private lateinit var adapter: MangaListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MangaListAdapter()
    }
    override fun inflate(layoutInflater: LayoutInflater): FragmentAllMangaBinding {
        return FragmentAllMangaBinding.inflate(layoutInflater)
    }

    override fun initListener() {

        viewModel.getAllManga()
        viewModel.getAllManga.collectState(
            onLoading = {
                binding.progressBar.isVisible = true
            },
            Error = {
                Log.e("ololo", "error: " )
                binding.progressBar.isVisible = false

            },
            onSuccess = {
                binding.progressBar.isVisible = false
                binding.recyclerManga.adapter =adapter
                adapter.add(it)
                Toast.makeText(requireContext(),"success",Toast.LENGTH_SHORT).show()
                Log.e("ololo", "success: " )
            })


        viewModel.getSearchManga.collectState(

            onLoading = {
                binding.progressBar.isVisible = true
            },
            Error = {
                Log.e("ololo", "error: " )
                binding.progressBar.isVisible = false

            },
            onSuccess = {
                binding.progressBar.isVisible = false
                binding.recyclerManga.adapter =adapter
                adapter.add(it)
                Toast.makeText(requireContext(),"success",Toast.LENGTH_SHORT).show()
                Log.e("ololo", "success: " )
            }

        )
    }

}

