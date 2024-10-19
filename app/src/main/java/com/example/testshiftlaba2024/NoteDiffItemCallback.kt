package com.example.testshiftlaba2024

import androidx.recyclerview.widget.DiffUtil
import com.example.testshiftlaba2024.storage.Note

class NoteDiffItemCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean
            = (oldItem.noteId == newItem.noteId)

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean
            = (oldItem == newItem)
}
