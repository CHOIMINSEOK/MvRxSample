package io.minseok.mvrxsample.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.minseok.mvrxsample.R
import kotlinx.android.synthetic.main.viewholder_item.view.*

class ListItemAdapter: RecyclerView.Adapter<ListItemAdapter.ItemViewHolder>() {

    var items: List<String> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_item, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(item: String) {

                with(itemView) {
                    text.text = item
                }
        }
    }
}