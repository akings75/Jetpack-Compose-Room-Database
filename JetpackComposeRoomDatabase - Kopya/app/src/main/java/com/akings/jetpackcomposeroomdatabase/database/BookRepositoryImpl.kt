package com.akings.jetpackcomposeroomdatabase.database

class BookRepositoryImpl(
    private val bookDao: BookDao
) : BookRepository {
    override suspend fun getBooksFromRoom() = bookDao.getBooks()

    override suspend fun getBookFromRoom(id: Int) = bookDao.getBook(id)

    override suspend fun addBookToRoom(book: Book) = bookDao.addBook(book)

    override suspend fun updateBookInRoom(book: Book) = bookDao.updateBook(book)

    override suspend fun deleteBookFromRoom(book: Book) = bookDao.deleteBook(book)

    override suspend fun deleteAll() = bookDao.deleteAll()


}