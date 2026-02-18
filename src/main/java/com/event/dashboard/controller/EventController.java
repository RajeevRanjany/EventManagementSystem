package com.event.dashboard.controller;

import com.event.dashboard.dto.EventRequest;
import com.event.dashboard.model.Event;
import com.event.dashboard.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping("/{organizerId}")
    public Event createEvent(@RequestBody EventRequest request,
                             @PathVariable Long organizerId) {

        Event event = Event.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .eventDate(java.time.LocalDateTime.parse(request.getEventDate()))
                .maxCapacity(request.getMaxCapacity())
                .build();

        return eventService.createEvent(event, organizerId);
    }


    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }


}
