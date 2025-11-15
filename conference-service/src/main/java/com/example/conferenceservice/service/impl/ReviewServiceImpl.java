package com.example.conferenceservice.service.impl;

import com.example.conferenceservice.dto.ReviewRequest;
import com.example.conferenceservice.dto.ReviewResponse;
import com.example.conferenceservice.entity.Review;
import com.example.conferenceservice.exception.ResourceNotFoundException;
import com.example.conferenceservice.mapper.ReviewMapper;
import com.example.conferenceservice.repository.ReviewRepository;
import com.example.conferenceservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ReviewResponse> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ReviewResponse getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));
        return reviewMapper.toDto(review);
    }

    @Override
    public ReviewResponse createReview(ReviewRequest reviewRequest) {
        Review review = reviewMapper.toEntity(reviewRequest);
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.toDto(savedReview);
    }

    @Override
    public ReviewResponse updateReview(Long id, ReviewRequest reviewRequest) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));
        
        reviewMapper.updateFromRequest(reviewRequest, existingReview);
        Review updatedReview = reviewRepository.save(existingReview);
        return reviewMapper.toDto(updatedReview);
    }

    @Override
    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new ResourceNotFoundException("Review not found with id: " + id);
        }
        reviewRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReviewResponse> getReviewsByConferenceId(Long conferenceId) {
        return reviewRepository.findById(conferenceId).stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }
}
