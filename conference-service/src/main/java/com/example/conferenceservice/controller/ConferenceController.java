package com.example.conferenceservice.controller;

import com.example.conferenceservice.dto.ConferenceRequest;
import com.example.conferenceservice.dto.ConferenceResponse;
import com.example.conferenceservice.dto.ReviewResponse;
import com.example.conferenceservice.service.ConferenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
@RequiredArgsConstructor
public class ConferenceController {

    private final ConferenceService conferenceService;

    @GetMapping
    public List<ConferenceResponse> getAllConferences() {
        return conferenceService.getAllConferences();
    }

    @GetMapping("/{id}")
    public ConferenceResponse getConferenceById(@PathVariable Long id) {
        return conferenceService.getConferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConferenceResponse createConference(@Valid @RequestBody ConferenceRequest conferenceRequest) {
        return conferenceService.createConference(conferenceRequest);
    }

    @PutMapping("/{id}")
    public ConferenceResponse updateConference(
            @PathVariable Long id,
            @Valid @RequestBody ConferenceRequest conferenceRequest) {
        return conferenceService.updateConference(id, conferenceRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConference(@PathVariable Long id) {
        conferenceService.deleteConference(id);
    }

    @GetMapping("/{id}/reviews")
    public List<ReviewResponse> getConferenceReviews(@PathVariable Long id) {
        return conferenceService.getReviewsByConferenceId(id);
    }
}
