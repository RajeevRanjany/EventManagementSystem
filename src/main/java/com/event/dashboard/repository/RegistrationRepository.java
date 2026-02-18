package com.event.dashboard.repository;

import com.event.dashboard.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    long countByEventId(Long eventId);

    boolean existsByUserIdAndEventId(Long userId, Long eventId);
}
