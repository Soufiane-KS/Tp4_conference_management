package com.example.conferenceservice.dto;

import com.example.conferenceservice.entity.Conference.ConferenceType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConferenceRequest {
    private String title;
    private ConferenceType type;
    private LocalDateTime date;
    
    @Min(value = 1, message = "Duration must be at least 1 minute")
    @Max(value = 1440, message = "Duration cannot exceed 24 hours (1440 minutes)")
    private Integer duration; // in minutes
    
    @Min(value = 0, message = "Attendees count cannot be negative")
    private Integer attendeesCount = 0;
}
