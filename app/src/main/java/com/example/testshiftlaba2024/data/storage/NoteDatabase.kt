package com.example.testshiftlaba2024.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao : NoteDao

    companion object {
        @Volatile
        private var INSTANCE : NoteDatabase?= null

        fun getInstance(context : Context) : NoteDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "notes_database"
                    ).build()
                }
                return instance
            }
        }
    }
}