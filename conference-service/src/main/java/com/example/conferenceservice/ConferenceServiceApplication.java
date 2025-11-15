package com.example.conferenceservice;

import com.example.conferenceservice.entity.Conference;
import com.example.conferenceservice.entity.Review;
import com.example.conferenceservice.repository.ConferenceRepository;
import com.example.conferenceservice.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ConferenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ConferenceRepository conferenceRepository, ReviewRepository reviewRepository) {
        return args -> {
        if (conferenceRepository.count() == 0) {
            Conference devConf = conferenceRepository.save(
                Conference.builder()
                    .title("DevConf 2023")
                    .type(Conference.ConferenceType.COMMERCIAL)
                    .date(LocalDateTime.now().plusDays(30))
                    .duration(480)
                    .attendeesCount(500)
                    .score(4.5)
                    .build()
            );

            Conference researchConf = conferenceRepository.save(
                Conference.builder()
                    .title("AI Research Summit")
                    .type(Conference.ConferenceType.ACADEMIC)
                    .date(LocalDateTime.now().plusDays(60))
                    .duration(600)
                    .attendeesCount(200)
                    .score(4.8)
                    .build()
            );

            reviewRepository.save(
                Review.builder()
                    .text("Great conference with amazing speakers!")
                    .rating(5)
                    .conference(devConf)
                    .build()
            );

            reviewRepository.save(
                Review.builder()
                    .text("Well organized but the venue was small.")
                    .rating(4)
                    .conference(devConf)
                    .build()
            );

            reviewRepository.save(
                Review.builder()
                    .text("Cutting-edge research presented here.")
                    .rating(5)
                    .conference(researchConf)
                    .build()
            );
        };
    };
}}
