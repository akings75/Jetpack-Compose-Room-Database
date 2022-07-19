package com.akings.jetpackcomposeroomdatabase.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BOOK_TABLE")
data class Book(

    @PrimaryKey(autoGenerate = true)
    val id: Int =0,

    @ColumnInfo(name = "name")
    val name: String="",

    )