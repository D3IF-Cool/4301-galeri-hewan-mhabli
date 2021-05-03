package org.d3if4129.galerihewan2.ui.main

import Hewan
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if4129.galerihewan2.R
import org.d3if4129.galerihewan2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private lateinit var binding: FragmentMainBinding
    private lateinit var myAdapter: MainAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        myAdapter = MainAdapter()
        with(binding.recyclerView) {
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    RecyclerView.VERTICAL
                )
            )
//            adapter = MainAdapter(getData())
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner, {
            myAdapter.updateData(it)
        })
    }
}

//    private fun getData(): List<Hewan> {
//        return listOf(
//                Hewan("Angsa", "Cygnus olor", R.drawable.angsa),
//                Hewan("Ayam", "Gallus gallus", R.drawable.ayam),
//                Hewan("Bebek", "Cairina moschata", R.drawable.bebek),
//                Hewan("Domba", "Ovis ammon", R.drawable.domba),
//                Hewan("Kalkun", "Meleagris gallopavo", R.drawable.kalkun),
//                Hewan("Kambing", "Capricornis sumatrensis", R.drawable.kambing),
//                Hewan("Kelinci", "Oryctolagus cuniculus", R.drawable.kelinci),
//                Hewan("Kerbau", "Bubalus bubalis", R.drawable.kerbau),
//                Hewan("Kuda", "Equus caballus", R.drawable.kuda),
//                Hewan("Sapi", "Bos taurus", R.drawable.sapi)
//        )
//    }
//}
