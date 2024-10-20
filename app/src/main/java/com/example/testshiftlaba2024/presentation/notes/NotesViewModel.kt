package com.example.testshiftlaba2024.presentation.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testshiftlaba2024.domain.NoteRepository

class NotesViewModel(repository: NoteRepository) : ViewModel() {

    private val _navigateToNoteEditor = MutableLiveData<Long?>()
    val navigateToNoteEditor: LiveData<Long?>
        get() = _navigateToNoteEditor

    val notes = repository.getAllNotes()

    val notesCountLiveData: LiveData<Int> = repository.getCountNote()

    fun onNoteClicked(taskId: Long){
        _navigateToNoteEditor.value = taskId
    }

    fun onNoteNavigated(){
        _navigateToNoteEditor.value = null
    }
}