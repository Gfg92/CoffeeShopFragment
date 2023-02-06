package com.example.coffeeshopfragment

import CoffeeCardAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshopfragment.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val root = inflater.inflate(R.layout.fragment_first, container, false)
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = ArrayList<CoffeeCard>()
        items.add(CoffeeCard(R.mipmap.images, R.string.n0, R.string.d0))
        items.add(CoffeeCard(R.mipmap.images1, R.string.n1, R.string.d1))
        items.add(CoffeeCard(R.mipmap.images2, R.string.n2, R.string.d2))
        items.add(CoffeeCard(R.mipmap.images3, R.string.n3, R.string.d3))
        items.add(CoffeeCard(R.mipmap.images4, R.string.n4, R.string.d4))
        items.add(CoffeeCard(R.mipmap.images5, R.string.n5, R.string.d5))
        items.add(CoffeeCard(R.mipmap.images6, R.string.n6, R.string.d6))

        val rv: RecyclerView = view.findViewById(R.id.rv)
        val adapter = CoffeeCardAdapter(items)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter.onClick = {
            val t = items[rv.getChildAdapterPosition(it)]
            val bundle = bundleOf("NOM" to getString(t.nombre))
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
