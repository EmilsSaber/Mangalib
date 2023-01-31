package kg.example.mangalib.presentation.ui.fragment

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kg.example.mangalib.data.remote.modelApi.Result
import kg.example.mangalib.databinding.ItemMangaBinding

class MangaListAdapter: RecyclerView.Adapter<MangaListAdapter.MangaListViewHolder>()  {

     var list = arrayListOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaListViewHolder {
        return MangaListViewHolder(ItemMangaBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: MangaListViewHolder, position: Int) {
      holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun add(mangalist:  List<Result>) {
//        this.list = mangalist as ArrayList<Result>
//        Log.d("ololo","s ArrayList<Item>")
//        mangalist.let { list.add(it) }
//        notifyDataSetChanged()
        list.addAll(mangalist)
        notifyDataSetChanged()
    }
   inner class MangaListViewHolder(private val binding: ItemMangaBinding):RecyclerView.ViewHolder(binding.root) {
       fun bind(list: Result) {
           binding.image.load(list.image)
//           binding.title.text = list.ru_name
       }
   }


}