package com.example.bharatreddit.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bharatreddit.R
import com.example.bharatreddit.model.CharacterItem
import com.example.bharatreddit.model.CharacterResult
import com.squareup.picasso.Picasso

class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        private val characterImage: ImageView = view.findViewById(R.id.character_image)
        private val characterName: TextView = view.findViewById(R.id.character_name)
        private val characterStatus: TextView = view.findViewById(R.id.character_status)
        private val characterOrigin: TextView = view.findViewById(R.id.character_origin)
        fun onBind(characterInfo: CharacterItem){
            Picasso.get().load(characterInfo.image)
                .placeholder(R.drawable.ic_baseline_bug_report_24)
                .into(
                characterImage
            )
            characterName.text = characterInfo.name
            characterStatus.text = characterInfo.status
            characterOrigin.text = characterInfo.origin.name
        }
    }

    private var data: CharacterResult? = null

    fun updateData(data: CharacterResult){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharacterViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.character_item,
            parent,
            false
        ))

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        data?.let {
            holder.onBind(it.results[position])
        }
    }

    override fun getItemCount() = data?.results?.size ?: 0


}