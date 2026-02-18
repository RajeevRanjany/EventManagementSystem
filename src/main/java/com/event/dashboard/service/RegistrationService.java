package com.event.dashboard.service;

import com.event.dashboard.model.Event;
import com.event.dashboard.model.Registration;
import com.event.dashboard.model.User;
import com.event.dashboard.repository.EventRepository;
import com.event.dashboard.repository.RegistrationRepository;
import com.event.dashboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Transactional
    public String registerUser(Long userId, Long eventId) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (registrationRepository.existsByUserIdAndEventId(userId, eventId)) {
            throw new RuntimeException("User already registered for this event");
        }

        if (event.getCurrentRegistrations() >= event.getMaxCapacity()) {
            throw new RuntimeException("Event is full");
        }

        Registration registration = Registration.builder()
                .user(user)
                .event(event)
                .registeredAt(LocalDateTime.now())
                .build();

        registrationRepository.save(registration);

        long count = registrationRepository.countByEventId(eventId);
        event.setCurrentRegistrations((int) count);

        eventRepository.save(event);

        return "Registration successful";
    }

    public long getRegistrationCount(Long eventId) {
        return registrationRepository.countByEventId(eventId);
    }
}
