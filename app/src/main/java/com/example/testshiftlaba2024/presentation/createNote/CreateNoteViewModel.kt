package com.example.testshiftlaba2024.presentation.createNote

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshiftlaba2024.domain.NoteRepository
import com.example.testshiftlaba2024.data.storage.Note
import kotlinx.coroutines.launch

class CreateNoteViewModel(private val repository: NoteRepository) : ViewModel() {
    val note = repository.getAllNotes()
    var newNoteTitle = ""
    var newNoteBody = ""

    private val _navigateToNotesList = MutableLiveData<Boolean>(false)
    val navigateToNotesList : LiveData<Boolean>
        get() = _navigateToNotesList

    fun addNote(view: View){
        viewModelScope.launch {
            val note = Note()
            note.noteTitle = newNoteTitle
            note.noteBody = newNoteBody
            repository.insertNote(note)
            _navigateToNotesList.value = true
        }
        hideKeyboard(view)
    }

    fun onNavigateToNotesList(){
        _navigateToNotesList.value = false
    }

    fun hideKeyboard(view: View) {
        val inputMethodManager =
            view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}