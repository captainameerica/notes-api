package com.ameersyed.notes_api;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final ActivityLogRepository activityLogRepository;

    public NoteService(NoteRepository noteRepository, ActivityLogRepository activityLogRepository) {
        this.noteRepository = noteRepository;
        this.activityLogRepository = activityLogRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(Note note) {
        Note saved = noteRepository.save(note);
        activityLogRepository.save(new ActivityLog("CREATE", saved.getId()));
        return saved;
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note updateNote(Long id, Note updatedNote) {
        updatedNote.setId(id);
        return noteRepository.save(updatedNote);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
        activityLogRepository.save(new ActivityLog("DELETE", id));
    }
}