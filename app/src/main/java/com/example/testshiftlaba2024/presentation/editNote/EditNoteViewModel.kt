package com.example.testshiftlaba2024.presentation.editNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshiftlaba2024.domain.NoteRepository
import kotlinx.coroutines.launch

class EditNoteViewModel (noteId : Long, private val repository : NoteRepository) : ViewModel() {
    val note = repository.getNoteById(noteId)

    private val _navigateToNotesList = MutableLiveData<Boolean>(false)
    val navigateToNotesList : LiveData<Boolean>
        get() = _navigateToNotesList

    fun updateNote(){
        viewModelScope.launch {
            repository.updateNote(note.value!!)
            _navigateToNotesList.value = true
        }
    }

    fun deleteNote(){
        viewModelScope.launch {
            repository.deleteNote(note.value!!)
            _navigateToNotesList.value = true
        }
    }

    fun onNavigateToNotesList(){
        _navigateToNotesList.value = false
    }
}