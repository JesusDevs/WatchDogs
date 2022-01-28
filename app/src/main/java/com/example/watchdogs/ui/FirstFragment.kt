package com.example.watchdogs.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.watchdogs.R
import com.example.watchdogs.adapter.DogAdapter
import com.example.watchdogs.databinding.FragmentFirstBinding
import com.example.watchdogs.viewmodel.DogBreedViewmodel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val mViewModel : DogBreedViewmodel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //  instnaciar adapter , recycler
        val adapter = DogAdapter()


        lifecycleScope.launch {
            //get data pendiente crear metodo para pasar variables Hard Code para test
            mViewModel.getDogoData(10, 30, 0)

        }
        //observar data y setear adapter
        mViewModel.allDogData.observe(viewLifecycleOwner, Observer {
            it.let {


                //actualizar valores del adapter
                adapter.update(it)
                Log.d("DATOS", "$it")
            }
        })

        //instanciar recycler,observar datades de internet ,set adapter
        setAdapter(adapter)
        adapter.selectedItem().observe(viewLifecycleOwner, Observer {
            //pasando data second fr
            val bundle = Bundle()
            bundle.putString("name",it.name)
            bundle.putString("breedFor",it.bredFor)
            bundle.putString("img", it.image.url)
            bundle.putString("lifeSpan",it.lifeSpan)
            bundle.putString("origin",it.origin)
            bundle.putInt("idBreed",it.id)
            bundle.putString("temperament",it.temperament)
            bundle.putString("weight",it.weight.metric)

            //crear metodo id para traer mas fotos u otra consulta luego del Onclick

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
        })
    }




    private fun setAdapter(adapter: DogAdapter) {
        //reycler
        setRecyclerView(adapter)


    }
        private fun setRecyclerView(adapter: DogAdapter) {
            binding.rvView2.layoutManager = LinearLayoutManager(context)
            binding.rvView2.adapter = adapter
            binding.rvView2.addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}