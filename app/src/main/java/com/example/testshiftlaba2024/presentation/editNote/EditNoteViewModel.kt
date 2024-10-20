package com.example.testshiftlaba2024.presentation.editNote

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
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

    fun updateNote(view: View){
        viewModelScope.launch {
            repository.updateNote(note.value!!)
            _navigateToNotesList.value = true
        }
        hideKeyboard(view)
    }

    fun deleteNote(view: View){
        viewModelScope.launch {
            repository.deleteNote(note.value!!)
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