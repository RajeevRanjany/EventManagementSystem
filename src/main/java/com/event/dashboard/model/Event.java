package com.event.dashboard.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime eventDate;

    private int maxCapacity;

    private int currentRegistrations = 0;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private User organizer;

}
