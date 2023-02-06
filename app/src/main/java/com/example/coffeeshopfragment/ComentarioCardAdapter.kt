package com.example.coffeeshopfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComentarioCardAdapter(var items: ArrayList<ComentarioCard>) :
    RecyclerView.Adapter<ComentarioCardAdapter.TarjViewHolder>() {
    lateinit var onClick: (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var texto: TextView



        init {
            texto = itemView.findViewById(R.id.comentario)
        }

        fun bindTarjeta(t: ComentarioCard, onClick: (View) -> Unit) = with(itemView) {
            texto.setText(t.comentario)
            setOnClickListener { onClick(itemView) }

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.coment_item, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}