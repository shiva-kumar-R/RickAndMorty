package com.example.rickandmorty.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty.R
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.databinding.ItemCharacterBinding
import com.example.rickandmorty.model.Status
import com.google.android.material.textview.MaterialTextView

class CharacterViewHolder(private val binding: ItemCharacterBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Character) = with(binding) {
        ivAvatar.load(item.image)
        tvName.text = item.name
        tvStatus.text = item.status.toString()
        tvStatus.setDrawable(item.status)
    }

    private fun MaterialTextView.setDrawable(status: Status) = when (status) {
        Status.ALIVE -> compoundDrawables[0]?.setTint(resources.getColor(R.color.green_a700, null))
        Status.DEAD -> compoundDrawables[0]?.setTint(resources.getColor(R.color.red_a700, null))
        Status.UNKNOWN -> compoundDrawables[0]?.setTint(resources.getColor(R.color.gray_700, null))
    }
}