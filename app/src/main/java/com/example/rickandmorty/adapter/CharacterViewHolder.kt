package com.example.rickandmorty.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.databinding.ItemCharacterBinding

class CharacterViewHolder(private val binding: ItemCharacterBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Character) = with(binding) {
            ivAvatar.load(item.image)
            tvName.text = item.name
            tvStatus.text = item.status.toString()
        }
}