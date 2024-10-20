package com.example.testshiftlaba2024.editNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testshiftlaba2024.NoteRepository

class EditNoteViewModelFactory (private val noteId: Long,
                                private val repository: NoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditNoteViewModel::class.java)) {
            return EditNoteViewModel(noteId, repository) as T
        }
        throw IllegalArgumentException("Unknown VM")
    }
}