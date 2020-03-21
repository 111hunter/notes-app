package com.jpa.springjpademo.service;

import com.jpa.springjpademo.dao.NotesDao;
import com.jpa.springjpademo.entity.Notes;
import com.jpa.springjpademo.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    @Autowired
    NotesDao notesDao;

    public List<Notes> getAllNotes() {
        return notesDao.findAll();
    }

    public Notes addNotes(Notes notes) {
        return notesDao.save(notes);
    }

    public Notes getNotesById(String id) {
        return notesDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notes", "id", id));
    }

    public Notes updateNotes(String id, Notes notes) {

        Notes tnotes = notesDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notes", "id", id));
        tnotes.setTitle(notes.getTitle());
        tnotes.setDescription(notes.getDescription());
        tnotes.setContent(notes.getContent());
        tnotes.setAuthor(notes.getAuthor());
        return notesDao.save(tnotes);

    }

    public ResponseEntity<?> deleteNotesById(String id) {
        Notes notes = notesDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notes", "id", id));
        notesDao.delete(notes);
        return ResponseEntity.ok().build();
    }

    public void deleteAllNotes() {
        notesDao.deleteAll();
    }

}
