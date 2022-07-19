package com.akings.jetpackcomposeroomdatabase

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.akings.jetpackcomposeroomdatabase.database.Book
import com.akings.jetpackcomposeroomdatabase.database.BooksViewModel
import com.akings.jetpackcomposeroomdatabase.navigation.Destinations


@Composable
fun AddBookView(navController: NavController
) {
    val viewModel: BooksViewModel = hiltViewModel()

    var kitap by rememberSaveable(viewModel.book.name){ mutableStateOf(viewModel.book.name) }
    Column(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        TextField(value =kitap , onValueChange = { kitap = it }, label = { Text(text = "Kitap Adı")}, modifier = Modifier.fillMaxWidth() )
        Spacer(modifier = Modifier.padding(4.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val book = Book(0,kitap)
                viewModel.addBook(book)
                navController.navigate(Destinations.BookList)
            }
        ){
            Text(text = "Save")
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val book = Book(viewModel.book.id,kitap)
                viewModel.updateBook(book)

                navController.navigate(Destinations.BookList)
            }
        ){
            Text(text = "Update")
        }

    }


}



