package com.akings.jetpackcomposeroomdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akings.jetpackcomposeroomdatabase.navigation.NavigationComponent
import com.akings.jetpackcomposeroomdatabase.ui.theme.JetpackComposeRoomDatabaseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeRoomDatabaseTheme {
                // A surface container using the 'background' color from the theme

                    NavigationComponent()
            }
        }
    }
}


