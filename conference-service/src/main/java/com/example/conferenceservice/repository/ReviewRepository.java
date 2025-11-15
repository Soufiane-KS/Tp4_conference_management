package com.example.conferenceservice.repository;

import com.example.conferenceservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReviewRepository extends JpaRepository<Review, Long> {
}