package com.example.watchdogs.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.watchdogs.R
import com.example.watchdogs.databinding.FragmentDetailBinding
import com.example.watchdogs.databinding.FragmentSecondBinding
import com.example.watchdogs.viewmodel.DogBreedViewmodel
import com.jesusdev.gamesfreepc.extensions.loadSvg

class SecondFragment : Fragment() {

    private var _binding:FragmentDetailBinding? = null
    private val mViewModel : DogBreedViewmodel by activityViewModels()


    var idBreed: Int =0
    var img: String = ""
    var origin: String = ""
    var lifeSpan = ""
    var name: String = ""
    var breedFor : String = ""
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    //agregar Metodo Oncreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            idBreed = it.getInt("id", 0)
            img = it.getString("img", "")
            name = it.getString("name", "")
            lifeSpan = it.getString("lifeSpan", "")
            breedFor  = it.getString("breedFor", "")
            origin  = it.getString("origin", "")

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //binding view should

        binding.titleEd.text = name
        binding.imageDog.loadSvg(img)
        binding.description.text =lifeSpan
        binding.origin.text =origin
        binding.breefFor.text = breedFor

        //button guardar fav , crear booleano de fav ,etc
        binding.guardarFav.setOnClickListener {
            Toast.makeText(context, "Guardado Como Favorito", Toast.LENGTH_SHORT).show()
        }
        binding.volver.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}