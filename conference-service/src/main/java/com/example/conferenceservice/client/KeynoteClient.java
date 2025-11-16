package com.example.conferenceservice.client;

import com.example.conferenceservice.dto.KeynoteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "keynote-service")
public interface KeynoteClient {

    @GetMapping("/api/keynotes")
    List<KeynoteResponse> getAllKeynotes();

    @GetMapping("/api/keynotes/{id}")
    KeynoteResponse getKeynoteById(@PathVariable("id") Long id);
}
