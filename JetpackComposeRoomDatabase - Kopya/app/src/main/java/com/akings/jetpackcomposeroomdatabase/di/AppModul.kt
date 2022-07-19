package com.akings.jetpackcomposeroomdatabase.di

import android.content.Context
import androidx.room.Room
import com.akings.jetpackcomposeroomdatabase.database.BookDao
import com.akings.jetpackcomposeroomdatabase.database.BookDb
import com.akings.jetpackcomposeroomdatabase.database.BookRepository
import com.akings.jetpackcomposeroomdatabase.database.BookRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBookDb(
        @ApplicationContext
        context : Context
    ) = Room.databaseBuilder(
        context,
        BookDb::class.java,
        "BOOK_TABLE"
    ).build()

    @Provides
    fun provideBookDao(
        bookDb: BookDb
    ) = bookDb.bookDao()

    @Provides
    fun provideBookRepository(
        bookDao: BookDao
    ): BookRepository = BookRepositoryImpl(bookDao)
}