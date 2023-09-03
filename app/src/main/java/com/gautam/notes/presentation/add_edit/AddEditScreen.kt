package com.gautam.notes.presentation.add_edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        var text by remember { mutableStateOf("") }

        TextField(value = text, onValueChange = {
            text = it
        })

    }
}