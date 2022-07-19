package com.akings.jetpackcomposeroomdatabase.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akings.jetpackcomposeroomdatabase.AddBookView
import com.akings.jetpackcomposeroomdatabase.BookListView
import com.akings.jetpackcomposeroomdatabase.database.BooksViewModel
import com.akings.jetpackcomposeroomdatabase.ui.theme.JetpackComposeRoomDatabaseTheme

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    JetpackComposeRoomDatabaseTheme {
        NavHost(navController = navController, startDestination = Destinations.BookList) {
            composable(Destinations.BookList,

                ){

                BookListView(navController,onClick = {bookId ->navController.navigate(Destinations.AddBook+"?bookId=$bookId")} )
            }

            composable(Destinations.AddBook+"?bookId={bookId}"
            )
                {
                    AddBookView(navController = navController)
                }

        }
    }
}