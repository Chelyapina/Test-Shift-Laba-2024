package com.example.testshiftlaba2024.domain

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.testshiftlaba2024.data.storage.Note
import com.example.testshiftlaba2024.data.storage.NoteDao
import com.example.testshiftlaba2024.data.storage.NoteDatabase

object NoteRepository {
    private val instance = NoteRepository
    private lateinit var noteDao: NoteDao

    fun getInstance(application: Application): NoteRepository {
        if (!NoteRepository::noteDao.isInitialized) {
            noteDao = NoteDatabase.getInstance(application).noteDao
        }
        return instance
    }

    suspend fun insertNote(note: Note) = noteDao.insert(note)

    suspend fun updateNote(note: Note) = noteDao.update(note)

    suspend fun deleteNote(note: Note) = noteDao.delete(note)

    fun getAllNotes(): LiveData<List<Note>> = noteDao.getAll()

    fun getNoteById(noteId: Long): LiveData<Note> = noteDao.get(noteId)

    fun getCountNote(): LiveData<Int> = noteDao.getCount()
}