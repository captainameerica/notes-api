package com.ameersyed.notes_api;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
@RestController@RequestMapping("/notes")

public class NoteController {

    private final List<Note> notes = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public List<Note> getAllNotes() {
        return notes;
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        note.setId(counter.incrementAndGet());
        notes.add(note);
        return note;
    }
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note updated) {
        for (Note note : notes ) {
            if (note.getId().equals(id)) {
                note.setTitle(updated.getTitle());
                note.setContent(updated.getContent());
                return note;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id) {
        notes.removeIf(note -> note.getId().equals(id));
        return "Note " + id + " deleted";
    }
}
