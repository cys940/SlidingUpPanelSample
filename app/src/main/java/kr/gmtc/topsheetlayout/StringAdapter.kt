package kr.gmtc.topsheetlayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.gmtc.topsheetlayout.databinding.AdapterItemBinding

class StringAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var binding:AdapterItemBinding
    private val list = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = AdapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StringViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StringViewHolder)
             holder.binding.message.text = list[position]
    }

    override fun getItemCount(): Int = list.size

    fun addItem(item:String){
        list.add(item)
    }

    inner class StringViewHolder(binding: AdapterItemBinding):RecyclerView.ViewHolder(binding.root){
        val binding = binding
    }
}