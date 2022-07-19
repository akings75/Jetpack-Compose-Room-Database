package com.akings.jetpackcomposeroomdatabase

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.akings.jetpackcomposeroomdatabase.database.Book
import com.akings.jetpackcomposeroomdatabase.database.BooksViewModel
import com.akings.jetpackcomposeroomdatabase.navigation.Destinations

@Composable
fun BookListView(
    navController: NavController,
    onClick:(String) ->Unit,
) {
    val context = LocalContext.current
    val viewModel: BooksViewModel = hiltViewModel()


    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            "Book List View",
            style = MaterialTheme.typography.h4,
        )
        Spacer(modifier = Modifier.padding(bottom = 16.dp))
        CustomCardState(navController,viewModel )
        TodoList( viewModel = viewModel, navController = navController, onClick = onClick)
        Spacer(modifier = Modifier.padding(top = 32.dp))
    }
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TodoList(
    navController: NavController,
    viewModel: BooksViewModel = hiltViewModel(),
    onClick: (String) -> Unit,
) {
    viewModel.getBooks()
    LazyColumn() {
        items(viewModel.books) { book ->
            ListItem(
                text = { Text(text = book.name)},
                modifier = Modifier.clickable { onClick(book.id.toString())
                     },
                icon = {
                    IconButton(onClick = {
                        viewModel.deleteBook(book)
                    }) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = null
                        )
                    }
                }

            )
            Divider()
        }
    }
}


@Composable
private fun CustomCardState(
    navController: NavController,
    viewModel: BooksViewModel= hiltViewModel(),
) {
    Column() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Button( onClick = {
                navController.navigate(Destinations.AddBook)
            }) {
                Text(text =" Add Book")
            }
            Button( onClick = {
               viewModel.deleteAll()
            }) {
                Text(text = "Clear All")
            }
        }
    }
}