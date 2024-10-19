package com.example.testshiftlaba2024.createNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshiftlaba2024.storage.Note
import com.example.testshiftlaba2024.storage.NoteDao
import kotlinx.coroutines.launch

class CreateNoteViewModel (val dao: NoteDao) : ViewModel() {
    val note = dao.getAll()
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
            dao.insert(note)
            _navigateToNotesList.value = true
        }
    }

    fun onNavigateToNotesList(){
        _navigateToNotesList.value = false
    }
}