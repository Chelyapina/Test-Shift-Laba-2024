package com.example.testshiftlaba2024.presentation.createNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testshiftlaba2024.domain.NoteRepository

class CreateNoteViewModelFactory (private val repository : NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateNoteViewModel::class.java)){
            return CreateNoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown VM")
    }
}