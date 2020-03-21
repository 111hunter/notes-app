package com.jpa.springjpademo.controller;

import com.jpa.springjpademo.entity.Notes;
import com.jpa.springjpademo.service.NotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {
    @Autowired
    NotesService notesService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Notes> getAllNotes() {
        return notesService.getAllNotes();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Notes addNotes(@RequestBody Notes notes) {
        return notesService.addNotes(notes);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Notes updateNotes(@RequestParam("notes_id") String id, @RequestBody Notes notes) {
        return notesService.updateNotes(id, notes);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Notes getNotes(@PathVariable("id") String id) {
        return notesService.getNotesById(id);
    }

    @RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
    public void deleteAllNotes() {
        notesService.deleteAllNotes();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteNotes(@RequestParam("notes_id") String id) {
        return notesService.deleteNotesById(id);
    }
}
