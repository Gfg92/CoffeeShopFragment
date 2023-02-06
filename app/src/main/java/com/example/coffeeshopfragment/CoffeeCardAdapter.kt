import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshopfragment.CoffeeCard
import com.example.coffeeshopfragment.R


class CoffeeCardAdapter(var items: ArrayList<CoffeeCard>) : RecyclerView.Adapter<CoffeeCardAdapter.CardViewHolder>() {
    lateinit var onClick: (View) -> Unit

    init {
        this.items = items
    }

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView
        var nombre: TextView
        var direccion: TextView
        var puntuacion: TextView
        val rb : RatingBar

        init {
            image = itemView.findViewById(R.id.imageView)
            nombre = itemView.findViewById(R.id.textViewNombre)
            direccion = itemView.findViewById(R.id.textViewDireccion)
            puntuacion = itemView.findViewById(R.id.punt)
            rb = itemView.findViewById(R.id.ratingBar2)
        }

        fun bindTarjeta(t: CoffeeCard, onClick: (View) -> Unit) = with(itemView) {
            image.setImageResource(t.image)
            nombre.setText(t.nombre)
            direccion.setText(t.direccion)
            setOnClickListener { onClick(itemView) }

            rb.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{ ratingBar, rating, fromUser ->
                puntuacion.text = rating.toString()
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardViewHolder {
        val itemView =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.coffee_item, viewGroup, false)
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: CardViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item,onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}