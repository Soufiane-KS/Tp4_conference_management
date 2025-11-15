package com.example.conferenceservice.service;

import com.example.conferenceservice.dto.ReviewRequest;
import com.example.conferenceservice.dto.ReviewResponse;

import java.util.List;

public interface ReviewService {
    List<ReviewResponse> getAllReviews();
    ReviewResponse getReviewById(Long id);
    ReviewResponse createReview(ReviewRequest reviewRequest);
    ReviewResponse updateReview(Long id, ReviewRequest reviewRequest);
    void deleteReview(Long id);
    List<ReviewResponse> getReviewsByConferenceId(Long conferenceId);
}
