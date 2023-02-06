package com.example.coffeeshopfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {


    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_second, container, false)
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cometarios = ArrayList<ComentarioCard>()
        cometarios.add(ComentarioCard("Muy recomendable. Vovere seguro"))
        cometarios.add(ComentarioCard("Acogedor, muy buen ambiente"))
        cometarios.add(ComentarioCard("Buenos precios"))
        cometarios.add(ComentarioCard("Servicio algo flojo"))
        cometarios.add(ComentarioCard("Para repetir... Extensa carta de cafes"))

        val titulo = view.findViewById<TextView>(R.id.titulo)
        titulo.text= arguments?.getString("NOM")

        val rv = view.findViewById<RecyclerView>(R.id.rv2)

        rv.setHasFixedSize(true)

        val adapter = ComentarioCardAdapter(cometarios)
        rv.adapter = adapter
        rv.layoutManager = GridLayoutManager(context, 2)

        adapter.onClick = {
//            val t = cometarios[recView.getChildAdapterPosition(it)]
//            val bundle= bundleOf("NOM" to t.comentarios)
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }


//
//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }
override fun onDestroyView() {
        super.onDestroyView()
    }
}

