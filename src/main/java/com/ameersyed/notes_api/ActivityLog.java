package com.ameersyed.notes_api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "activity_logs")
public class ActivityLog {

    @Id
    private String id;
    private String action;
    private Long noteId;
    private LocalDateTime timestamp;

    public ActivityLog(String action, Long noteId) {
        this.action = action;
        this.noteId = noteId;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getAction() { return action; }
    public Long getNoteId() { return noteId; }
    public LocalDateTime getTimestamp() { return timestamp; }
}