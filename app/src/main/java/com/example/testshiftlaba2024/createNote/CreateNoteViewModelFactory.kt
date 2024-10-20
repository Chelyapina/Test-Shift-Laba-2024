package com.example.testshiftlaba2024.createNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testshiftlaba2024.NoteRepository

class CreateNoteViewModelFactory (private val repository : NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateNoteViewModel::class.java)){
            return CreateNoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown VM")
    }
}