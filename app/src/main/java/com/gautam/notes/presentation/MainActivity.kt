package com.gautam.notes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gautam.notes.presentation.add_edit.AddEditScreen
import com.gautam.notes.presentation.home.HomeScreen
import com.gautam.notes.ui.theme.NotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetupNavigation()
                }
            }
        }
    }
}

@Composable
fun SetupNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_screen" ){

        composable(
            route = "home_screen"
        ){
            HomeScreen(navController = navController)
        }

        composable(
            route = "add_edit_screen"
        ){
            AddEditScreen(navController = navController)
        }
    }
}
