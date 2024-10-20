package com.example.testshiftlaba2024.createNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshiftlaba2024.NoteRepository
import com.example.testshiftlaba2024.storage.Note
import kotlinx.coroutines.launch

class CreateNoteViewModel(private val repository: NoteRepository) : ViewModel() {
    val note = repository.getAllNotes()
    var newNoteTitle = ""
    var newNoteBody = ""

    private val _navigateToNotesList = MutableLiveData<Boolean>(false)
    val navigateToNotesList : LiveData<Boolean>
        get() = _navigateToNotesList

    fun addNote(){
        viewModelScope.launch {
            val note = Note()
            note.noteTitle = newNoteTitle
            note.noteBody = newNoteBody
            repository.insertNote(note)
            _navigateToNotesList.value = true
        }
    }

    fun onNavigateToNotesList(){
        _navigateToNotesList.value = false
    }
}