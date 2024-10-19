package com.example.testshiftlaba2024.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testshiftlaba2024.storage.NoteDao

class NotesViewModel (val dao : NoteDao) : ViewModel() {

    private val _navigateToNoteEditor = MutableLiveData<Long?>()
    val navigateToNoteEditor: LiveData<Long?>
        get() = _navigateToNoteEditor

    val notes = dao.getAll()

    val notesCountLiveData: LiveData<Int> = dao.getCount()

    fun onNoteClicked(taskId: Long){
        _navigateToNoteEditor.value = taskId
    }

    fun onNoteNavigated(){
        _navigateToNoteEditor.value = null
    }
}