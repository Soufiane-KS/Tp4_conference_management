package com.example.conferenceservice.mapper;

import com.example.conferenceservice.dto.ConferenceRequest;
import com.example.conferenceservice.dto.ConferenceResponse;
import com.example.conferenceservice.entity.Conference;
import org.springframework.stereotype.Component;
import lombok.Builder;

@Component
public class ConferenceMapper {
    
    public ConferenceResponse fromConference(Conference conference) {
        return ConferenceResponse.builder()
                .id(conference.getId())
                .title(conference.getTitle())
                .type(conference.getType())
                .date(conference.getDate())
                .duration(conference.getDuration())
                .attendeesCount(conference.getAttendeesCount())
                .score(conference.getScore())
                // Add reviews mapping if needed
                .build();
    }
    
    public Conference fromConferenceRequest(ConferenceRequest request) {
        return Conference.builder()
                .title(request.getTitle())
                .type(request.getType())
                .date(request.getDate())
                .duration(request.getDuration())
                .attendeesCount(request.getAttendeesCount() != null ? request.getAttendeesCount() : 0)
                .score(0.0) // Default score
                .build();
    }
    
    public void updateFromRequest(ConferenceRequest request, Conference conference) {
        conference.setTitle(request.getTitle());
        conference.setType(request.getType());
        conference.setDate(request.getDate());
        conference.setDuration(request.getDuration());
        if (request.getAttendeesCount() != null) {
            conference.setAttendeesCount(request.getAttendeesCount());
        }
    }
}
