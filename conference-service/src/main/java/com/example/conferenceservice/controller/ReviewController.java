package com.example.conferenceservice.controller;

import com.example.conferenceservice.dto.ReviewRequest;
import com.example.conferenceservice.dto.ReviewResponse;
import com.example.conferenceservice.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewResponse> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public ReviewResponse getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse createReview(@Valid @RequestBody ReviewRequest reviewRequest) {
        return reviewService.createReview(reviewRequest);
    }

    @PutMapping("/{id}")
    public ReviewResponse updateReview(
            @PathVariable Long id,
            @Valid @RequestBody ReviewRequest reviewRequest) {
        return reviewService.updateReview(id, reviewRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    @GetMapping("/conference/{conferenceId}")
    public List<ReviewResponse> getReviewsByConferenceId(@PathVariable Long conferenceId) {
        return reviewService.getReviewsByConferenceId(conferenceId);
    }
}
