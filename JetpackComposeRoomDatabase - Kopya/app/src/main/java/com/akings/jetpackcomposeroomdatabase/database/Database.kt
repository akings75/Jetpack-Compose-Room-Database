package com.akings.jetpackcomposeroomdatabase.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDb : RoomDatabase() {
    abstract fun bookDao(): BookDao
}