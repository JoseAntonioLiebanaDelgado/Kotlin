package cat.salle.dbdemo

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import cat.salle.dbdemo.placeholder.PlaceholderContent.PlaceholderItem
import cat.salle.dbdemo.databinding.FragmentItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: MutableList<TvShow>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.tvtitle.text = item.title
        holder.tvgenre.text = item.genre
        holder.tvseasons.text = item.seasons.toString()
        holder.tvdate.text = item.creation_date
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvtitle: TextView = binding.tvShowTitle
        val tvgenre: TextView = binding.tvShowGenre
        val tvseasons: TextView = binding.tvShowSeasons
        val tvdate: TextView = binding.tvShowCreationDate

        override fun toString(): String {
            return super.toString() + " '" + tvtitle.text + "'" + tvgenre.text + "'" + tvseasons.text + "'" + tvdate.text + "'"
        }
    }

}