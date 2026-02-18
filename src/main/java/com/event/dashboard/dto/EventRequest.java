package com.event.dashboard.dto;

import lombok.Data;

@Data
public class EventRequest {
    private String title;
    private String description;
    private String eventDate;
    private int maxCapacity;
}
