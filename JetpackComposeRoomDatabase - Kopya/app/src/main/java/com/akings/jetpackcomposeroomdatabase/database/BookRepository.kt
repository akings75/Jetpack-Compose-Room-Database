package com.akings.jetpackcomposeroomdatabase.database
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun getBooksFromRoom(): Flow<List<Book>>

    suspend fun getBookFromRoom(id: Int): Flow<Book>

    suspend fun addBookToRoom(book: Book)

    suspend fun updateBookInRoom(book: Book)

    suspend fun deleteBookFromRoom(book: Book)

    suspend fun deleteAll()


}