package com.globalsolution.mentessolidarias.controller.consulta.googleCalendar;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class GoogleMeetController {
    @Autowired
    private Calendar calendarService;

    @GetMapping("/meet-link")
    public String createMeetLink() throws IOException, GeneralSecurityException {
        Event event = new Event()
                .setSummary("Reunião")
                .setDescription("Descrição da reunião");

        LocalDateTime startDateTime = LocalDateTime.now().plusHours(1); // Data e hora de início da reunião
        LocalDateTime endDateTime = startDateTime.plusMinutes(1);
        EventDateTime start = new EventDateTime()
                .setDateTime(toDateTime(startDateTime))
                .setTimeZone("America/Sao_Paulo");
        event.setStart(start);

        EventDateTime end = new EventDateTime()
                .setDateTime(toDateTime(endDateTime))
                .setTimeZone("America/Sao_Paulo");
        event.setEnd(end);

        Event createdEvent = calendarService.events().insert("primary", event).execute();

        return createdEvent.getHangoutLink();
    }

    private static com.google.api.client.util.DateTime toDateTime(LocalDateTime localDateTime) {
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return new com.google.api.client.util.DateTime(date.getTime());
    }
}