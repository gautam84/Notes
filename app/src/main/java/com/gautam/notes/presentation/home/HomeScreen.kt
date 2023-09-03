package com.gautam.notes.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.gautam.notes.domain.model.Note

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center
        ) {


            val list by viewModel.notes


            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(8.dp)
            ) {
                item {
                    Text(text = "Your Notes...", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                }
                items(list.size) {
                    NoteCard(note = list[it])
                }


            }

        }
        Column(modifier = Modifier.padding(8.dp)) {
            FloatingActionButton(onClick = { navController.navigate("add_edit_screen") }) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = null)
            }
        }
    }
}


@Composable
fun NoteCard(
    note: Note
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = note.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = note.content)
        }


    }
}