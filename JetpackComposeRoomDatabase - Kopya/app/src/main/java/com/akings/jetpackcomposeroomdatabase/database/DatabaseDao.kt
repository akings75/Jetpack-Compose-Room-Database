package com.akings.jetpackcomposeroomdatabase.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * from BOOK_TABLE")
    fun getBooks(): Flow<List<Book>>

    @Query("SELECT * from BOOK_TABLE where id = :id")
    fun getBook(id: Int): Flow<Book>

    @Insert(onConflict = IGNORE)
    fun addBook(book: Book)

    @Update
    fun updateBook(book: Book)

    @Delete
    fun deleteBook(book: Book)

    @Query("DELETE FROM BOOK_TABLE")
    fun deleteAll()
}