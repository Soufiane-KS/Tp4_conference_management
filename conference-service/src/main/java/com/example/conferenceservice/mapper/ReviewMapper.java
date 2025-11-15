package com.example.conferenceservice.mapper;

import com.example.conferenceservice.dto.ReviewRequest;
import com.example.conferenceservice.dto.ReviewResponse;
import com.example.conferenceservice.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public ReviewResponse toDto(Review review) {
        if (review == null) {
            return null;
        }

        return ReviewResponse.builder()
                .id(review.getId())
                .text(review.getText())
                .rating(review.getRating())
                .date(review.getDate())
                .build();
    }

    public Review toEntity(ReviewRequest request) {
        if (request == null) {
            return null;
        }

        return Review.builder()
                .text(request.getText())
                .rating(request.getRating())
                .build();
    }

    public void updateFromRequest(ReviewRequest request, Review review) {
        if (request == null || review == null) {
            return;
        }

        if (request.getText() != null) {
            review.setText(request.getText());
        }
        if (request.getRating() != null) {
            review.setRating(request.getRating());
        }
    }
}