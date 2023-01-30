package kg.example.mangalib.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kg.example.mangalib.data.remote.modelApi.Result
import kg.example.mangalib.databinding.FragmentAllMangaBinding

class AllMangaFragment : Fragment() {

    private lateinit var binding: FragmentAllMangaBinding
    //private lateinit var viewModel: AllMangaViewModel
    private var adapter = MangaListAdapter()
    private var list = arrayListOf<Result>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllMangaBinding.inflate(layoutInflater)
        return binding.root


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel = ViewModelProvider(this)[AllMangaViewModel::class.java]
        binding.recyclerManga.adapter = adapter
        viewModel.getMangaList().observe(viewLifecycleOwner){
            Toast.makeText(context, "kokoko", Toast.LENGTH_SHORT).show()
            Log.e("jojo", "onViewCreated:", )
             adapter.add(it)
        }
    }
}

