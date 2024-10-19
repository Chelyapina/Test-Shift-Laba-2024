package com.example.testshiftlaba2024.editNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshiftlaba2024.storage.NoteDao
import kotlinx.coroutines.launch

class EditNoteViewModel (noteId : Long, val dao : NoteDao) : ViewModel() {
    val note = dao.get(noteId)

    private val _navigateToNotesList = MutableLiveData<Boolean>(false)
    val navigateToNotesList : LiveData<Boolean>
        get() = _navigateToNotesList

    fun updateNote(){
        viewModelScope.launch {
            dao.update(note.value!!)
            _navigateToNotesList.value = true
        }
    }

    fun deleteNote(){
        viewModelScope.launch {
            dao.delete(note.value!!)
            _navigateToNotesList.value = true
        }
    }

    fun onNavigateToNotesList(){
        _navigateToNotesList.value = false
    }
}