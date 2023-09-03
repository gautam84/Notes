package com.gautam.notes.presentation.add_edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditScreen(
    navController: NavHostController,
    viewModel: AddEditScreenViewModel = hiltViewModel(),

    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
val context = LocalContext.current


        TextField(
            label = { Text(text = "Enter Title") },
            value = viewModel.titleText.value,
            onValueChange = {
                viewModel.changeTitleText(it)
            },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            modifier = Modifier.height(150.dp),
            label = { Text(text = "Enter Content") },
            value = viewModel.contentText.value,
            onValueChange = {
                            viewModel.changeContentText(it)
            },
            singleLine = false
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.save(context) }) {
            Text(text = "Save")
        }

    }
}