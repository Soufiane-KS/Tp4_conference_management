package com.example.conferenceservice.service;

import com.example.conferenceservice.dto.ConferenceRequest;
import com.example.conferenceservice.dto.ConferenceResponse;
import com.example.conferenceservice.dto.ReviewResponse;

import java.util.List;

public interface ConferenceService {
    List<ConferenceResponse> getAllConferences();
    ConferenceResponse getConferenceById(Long id);
    ConferenceResponse createConference(ConferenceRequest conferenceRequest);
    ConferenceResponse updateConference(Long id, ConferenceRequest conferenceRequest);
    void deleteConference(Long id);
    List<ReviewResponse> getReviewsByConferenceId(Long conferenceId);
    double calculateAverageRating(Long conferenceId);
    ConferenceResponse addReviewToConference(Long conferenceId, Long reviewId);
}