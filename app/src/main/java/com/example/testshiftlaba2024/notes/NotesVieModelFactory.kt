package com.example.testshiftlaba2024.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testshiftlaba2024.storage.NoteDao

class NotesViewModelFactory(private val dao : NoteDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesViewModel::class.java)){
            return NotesViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown VM")
    }
}