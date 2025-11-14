package com.example.keynoteservice.controller;

import com.example.keynoteservice.dto.KeynoteRequest;
import com.example.keynoteservice.dto.KeynoteResponse;
import com.example.keynoteservice.service.KeynoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keynotes")
@RequiredArgsConstructor
public class KeynoteController {

    private final KeynoteService keynoteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public KeynoteResponse createKeynote(@RequestBody KeynoteRequest request) {
        return keynoteService.createKeynote(request);
    }

    @GetMapping("/{id}")
    public KeynoteResponse getKeynoteById(@PathVariable Long id) {
        return keynoteService.getKeynoteById(id);
    }

    @GetMapping
    public List<KeynoteResponse> getAllKeynotes() {
        return keynoteService.getAllKeynotes();
    }

    @PutMapping("/{id}")
    public KeynoteResponse updateKeynote(
            @PathVariable Long id,
            @RequestBody KeynoteRequest request) {
        return keynoteService.updateKeynote(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKeynote(@PathVariable Long id) {
        keynoteService.deleteKeynote(id);
    }
}
