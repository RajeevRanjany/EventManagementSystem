package com.event.dashboard.controller;

import com.event.dashboard.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/{eventId}/user/{userId}")
    public String register(@PathVariable Long eventId,
                           @PathVariable Long userId) {
        return registrationService.registerUser(userId, eventId);
    }

    @GetMapping("/count/{eventId}")
    public long getCount(@PathVariable Long eventId) {
        return registrationService.getRegistrationCount(eventId);
    }
}
