package com.gautam.notes.presentation.add_edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.gautam.notes.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditScreenViewModel @Inject constructor(
    repository: NoteRepository
) : ViewModel() {

    private val _titleText = mutableStateOf("")
    val titleText: State<String> = _titleText

    private val _contentText = mutableStateOf("")
    val contentText: State<String> = _titleText


}