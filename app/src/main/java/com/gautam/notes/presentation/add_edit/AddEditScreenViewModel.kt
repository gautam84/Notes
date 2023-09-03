package com.gautam.notes.presentation.add_edit

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.gautam.notes.data.repository.NoteRepository
import com.gautam.notes.domain.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditScreenViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    private val _titleText = mutableStateOf("")
    val titleText: State<String> = _titleText

    private val _contentText = mutableStateOf("")
    val contentText: State<String> = _contentText

    fun changeTitleText(
        text: String
    ) {
        _titleText.value = text

    }

    fun changeContentText(
        text: String
    ) {
        _contentText.value = text

    }

    fun save(context: Context, navHostController: NavHostController) {

        viewModelScope.launch {
            if (_titleText.value == "" ||  _contentText.value == ""){
                Toast.makeText(context, "Please enter a valid Title and content", Toast.LENGTH_SHORT).show()
            } else {
                repository.insertNote(
                    Note(
                        title = _titleText.value,
                        content = _contentText.value
                    )
                )
                navHostController.navigate("home_screen")
            }

        }
    }


}