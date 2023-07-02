package com.vizcarra.domenica.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vizcarra.domenica.data.entities.Datos
import com.vizcarra.domenica.databinding.ItemEmailBinding

class EmailListAdapter(
    private val items: List<Datos>,
    private val onItemClick: (Datos) -> Unit
) : RecyclerView.Adapter<EmailListAdapter.EmailViewHolder>() {

    inner class EmailViewHolder(private val binding: ItemEmailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Datos) {
            binding.textViewName.text = item.nombre
            binding.textViewSubject.text = item.asunto

            Picasso.get().load(item.imagen).into(binding.imageViewEmail)

            itemView.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEmailBinding.inflate(inflater, parent, false)
        return EmailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
