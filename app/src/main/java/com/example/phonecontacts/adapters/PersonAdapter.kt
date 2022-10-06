package com.example.phonecontacts.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.phonecontacts.R
import com.example.phonecontacts.models.Person


class PersonAdapter(
    private val personList: List<Person>,
    private val onItemClicked: ((person: Person) -> Unit)
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val nameView: TextView = itemView.findViewById(R.id.name_textView)
        val fNameView: TextView = itemView.findViewById(R.id.f_name_textView)
        val phoneView: TextView = itemView.findViewById(R.id.phone_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val item = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.person_layout, parent, false)
        return PersonViewHolder(item)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val currentItem = personList[position]
        holder.nameView.text = currentItem.name
        holder.fNameView.text = currentItem.f_name
        holder.phoneView.text = currentItem.phone
        Glide
            .with(holder.imageView)
            .load(currentItem.image_url)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            onItemClicked(currentItem)
        }
    }

    override fun getItemCount() = personList.size
}


