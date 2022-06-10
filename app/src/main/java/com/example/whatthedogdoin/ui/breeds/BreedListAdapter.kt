package com.example.whatthedogdoin.ui.breeds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.whatthedogdoin.Constants
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.db.entities.Breed

class BreedListAdapter : ListAdapter<Breed, BreedListAdapter.BreedViewHolder>(
    BreedsComparator()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class BreedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameItemView: TextView = itemView.findViewById(R.id.breedAdapter)

        fun bind(breed: Breed?) {
            nameItemView.text = breed?.noun + " " + breed?.idCategory;

            itemView.setOnClickListener {
                val bundle = bundleOf(Constants.ID_KEY to breed?.id)
                itemView.findNavController().navigate(R.id.action_breed_to_breedDetail, bundle)
            }
        }

        companion object {
            fun create(parent: ViewGroup): BreedViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.breed_adapter, parent, false)
                return BreedViewHolder(view)
            }
        }
    }

    class BreedsComparator : DiffUtil.ItemCallback<Breed>() {
        override fun areItemsTheSame(oldItem: Breed, newItem: Breed): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Breed, newItem: Breed): Boolean {
            return oldItem.id == newItem.id
        }
    }
}