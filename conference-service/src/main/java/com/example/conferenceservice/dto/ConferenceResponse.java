package com.example.conferenceservice.dto;

import com.example.conferenceservice.entity.Conference.ConferenceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConferenceResponse {
    private Long id;
    private String title;
    private ConferenceType type;
    private LocalDateTime date;
    private Integer duration; // in minutes
    private Integer attendeesCount;
    private Double score;
    private List<ReviewResponse> reviews;
}
