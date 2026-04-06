package com.ameersyed.notes_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteRepository repository;

    @GetMapping
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return repository.save(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note updated) {
        return repository.findById(id).map(note -> {
            note.setTitle(updated.getTitle());
            note.setContent(updated.getContent());
            return repository.save(note);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id) {
        repository.deleteById(id);
        return "Note " + id + " deleted";
    }
}