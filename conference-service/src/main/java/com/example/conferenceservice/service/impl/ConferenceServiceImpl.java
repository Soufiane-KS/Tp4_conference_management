package com.example.conferenceservice.service.impl;

import com.example.conferenceservice.dto.ConferenceRequest;
import com.example.conferenceservice.dto.ConferenceResponse;
import com.example.conferenceservice.dto.ReviewResponse;
import com.example.conferenceservice.entity.Conference;
import com.example.conferenceservice.exception.ResourceNotFoundException;
import com.example.conferenceservice.mapper.ConferenceMapper;
import com.example.conferenceservice.repository.ConferenceRepository;
import com.example.conferenceservice.service.ConferenceService;
import com.example.conferenceservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConferenceServiceImpl implements ConferenceService {
    
    private final ConferenceRepository conferenceRepository;
    private final ReviewService reviewService;
    private final ConferenceMapper conferenceMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ReviewResponse> getReviewsByConferenceId(Long conferenceId) {
        return reviewService.getReviewsByConferenceId(conferenceId);
    }
        @Override
    @Transactional(readOnly = true)
    public List<ConferenceResponse> getAllConferences() {
        return conferenceRepository.findAll().stream()
                .map(conferenceMapper::fromConference)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ConferenceResponse getConferenceById(Long id) {
        Conference conference = getConferenceOrThrow(id);
        return conferenceMapper.fromConference(conference);
    }

    @Override
    @Transactional
    public ConferenceResponse createConference(ConferenceRequest conferenceRequest) {
        Conference conference = conferenceMapper.fromConferenceRequest(conferenceRequest);
        Conference savedConference = conferenceRepository.save(conference);
        return conferenceMapper.fromConference(savedConference);
    }

    @Override
    @Transactional
    public ConferenceResponse updateConference(Long id, ConferenceRequest conferenceRequest) {
        Conference existingConference = getConferenceOrThrow(id);
        conferenceMapper.updateFromRequest(conferenceRequest, existingConference);
        existingConference.setId(id);
        Conference updatedConference = conferenceRepository.save(existingConference);
        return conferenceMapper.fromConference(updatedConference);
    }

    @Override
    @Transactional
    public void deleteConference(Long id) {
        Conference conference = getConferenceOrThrow(id);
        conferenceRepository.delete(conference);
    }

    @Override
    @Transactional
    public ConferenceResponse addReviewToConference(Long conferenceId, Long reviewId) {
        Conference conference = getConferenceOrThrow(conferenceId);
        ReviewResponse reviewResponse = reviewService.getReviewById(reviewId);
        
        // Here you would typically add the review to the conference
        // This is a simplified version - you might need to adjust based on your requirements
        // For example, you might want to update the conference's average score
        
        return conferenceMapper.fromConference(conference);
    }

    @Override
    @Transactional(readOnly = true)
    public double calculateAverageRating(Long conferenceId) {
        Conference conference = getConferenceOrThrow(conferenceId);
        return conference.getReviews().stream()
                .mapToInt(review -> review.getRating())
                .average()
                .orElse(0.0);
    }

    private Conference getConferenceOrThrow(Long id) {
        return conferenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conference not found with id: " + id));
    }

}
