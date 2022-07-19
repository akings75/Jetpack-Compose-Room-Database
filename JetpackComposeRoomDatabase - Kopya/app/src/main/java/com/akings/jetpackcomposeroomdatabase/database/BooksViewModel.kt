package com.akings.jetpackcomposeroomdatabase.database

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val repo: BookRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var books by mutableStateOf(emptyList<Book>())
    var book by mutableStateOf(Book())

    init {
        Log.d("BookDetailViewModel", "SavedStateHandle...")
        savedStateHandle.get<String>("bookId")?.let { bookId ->
            Log.d("BookDetailViewModel", "BookId: $bookId")
            getBook(bookId.toInt()) }
    }


    fun getBooks() = viewModelScope.launch {
        repo.getBooksFromRoom().collect { response ->
            books = response

        }
    }

    fun getBook(id: Int) = viewModelScope.launch {
        repo.getBookFromRoom(id).collect { response ->
            book = response
        }
    }

    fun addBook(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        repo.addBookToRoom(book)
    }

    fun updateBook(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        repo.updateBookInRoom(book)
    }

    fun deleteBook(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        repo.deleteBookFromRoom(book)
    }
    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repo.deleteAll()
    }
}