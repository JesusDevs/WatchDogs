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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FirstFragment : Fragment() {
    // crear instancia viewmodel

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
        setAdapter(adapter)


        mViewModel.getDogoData()

    mViewModel.allDogData.observe(viewLifecycleOwner, Observer {
        it.let {


                Log.d("fragment", "breeds + $it")

                adapter.update(it)


                //aca actualizar el adapter
                Log.d("DATOS", "$it")
            }


    })
/*
        adapter.selectedItem().observe(viewLifecycleOwner) {
            it?.let {

                //pasando data
                val bundle = Bundle()
                //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)

            }
        }*/

      /*  binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

*/
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


    private fun selectItemFromAdapter(adapter: DogAdapter) {
        adapter.selectedItem().observe(viewLifecycleOwner, Observer {
          //crear metodo id
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        })
    }
    private fun setAdapter(adapter: DogAdapter) {
        setRecyclerView(adapter)
       // selectItemFromAdapter(adapter)
        mViewModel.allDogData .observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()

    }
}