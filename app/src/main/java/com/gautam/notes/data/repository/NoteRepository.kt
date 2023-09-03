package com.gautam.notes.data.repository

import com.gautam.notes.data.data_source.NoteDao
import com.gautam.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val dao: NoteDao) {
     fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

     suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

     suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

     suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}