package com.example.watchdogs.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

import com.example.watchdogs.databinding.ItemRvBinding
import com.example.watchdogs.pojo.DogApiResponseItem
import com.jesusdev.gamesfreepc.extensions.loadSvg

class DogAdapter: RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    private var listDogBreedItem = listOf<DogApiResponseItem>()

    private var listDogSelected =MutableLiveData<DogApiResponseItem>()



   fun update (list : List<DogApiResponseItem>) {

       listDogBreedItem = list
       notifyDataSetChanged()
   }
    fun selectedItem(): LiveData<DogApiResponseItem> {
        return listDogSelected
    }



    inner class DogViewHolder(private val binding : ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root)
    , View.OnClickListener{

        fun bindView (dogBreed: DogApiResponseItem){
            binding.titlesBreed.text =dogBreed.bredFor.toString()
           // binding.weight!!.text = dogBreed.weight.imperial
           // binding.imageView.loadSvg(dogBreed.image.url)
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            // observar elemento onlcik
            listDogSelected.value = listDogBreedItem[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
      return DogViewHolder(ItemRvBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bindView(  listDogBreedItem[position])
    }

    override fun getItemCount(): Int = listDogBreedItem.size


}
