package com.example.testshiftlaba2024.presentation.noteItem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testshiftlaba2024.databinding.NoteItemBinding
import com.example.testshiftlaba2024.data.storage.Note

class NoteItemAdapter (private val clickListener: (noteId : Long) -> Unit)
    : ListAdapter<Note, NoteItemAdapter.NoteItemViewHolder>(NoteDiffItemCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            NoteItemViewHolder = NoteItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    class NoteItemViewHolder(private val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root){

        companion object {
            fun inflateFrom(parent: ViewGroup): NoteItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NoteItemBinding.inflate(layoutInflater, parent, false)
                return NoteItemViewHolder(binding)
            }
        }

        fun bind(item: Note, clickListener: (noteId: Long) -> Unit){
            binding.note = item
            binding.root.setOnClickListener { clickListener(item.noteId) }
        }
    }

}