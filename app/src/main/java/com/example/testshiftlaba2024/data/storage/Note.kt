package com.example.testshiftlaba2024.data.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note (
    @PrimaryKey(autoGenerate = true)
    var noteId: Long = 0L,
    @ColumnInfo(name = "task_title")
    var noteTitle: String = "",
    @ColumnInfo(name = "task_body")
    var noteBody: String = ""
)
