package com.gautam.notes.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gautam.notes.data.repository.NoteRepository
import com.gautam.notes.domain.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {
    private val _notes = mutableStateOf(listOf<Note>())
    val notes: State<List<Note>> = _notes

    init {
        viewModelScope.launch {
            repository.getNotes().collect{
                _notes.value = it
            }
        }
    }

}