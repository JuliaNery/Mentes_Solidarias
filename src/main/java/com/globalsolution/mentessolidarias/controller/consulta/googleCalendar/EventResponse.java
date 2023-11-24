package com.globalsolution.mentessolidarias.controller.consulta.googleCalendar;

import java.time.LocalDateTime;
import java.util.List;

public class EventResponse {
    private String id;
    private String summary;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<String> attendees;

    // Construtores, getters e setters

    // Exemplo de implementação dos construtores, getters e setters
    public EventResponse() {
    }

    public EventResponse(String id, String summary, String description, LocalDateTime start, LocalDateTime end, List<String> attendees) {
        this.id = id;
        this.summary = summary;
        this.description = description;
        this.start = start;
        this.end = end;
        this.attendees = attendees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<String> attendees) {
        this.attendees = attendees;
    }

    public String getHangoutLink() {
        return null;
    }
}