package com.example.keynoteservice.service;

import com.example.keynoteservice.dto.KeynoteRequest;
import com.example.keynoteservice.dto.KeynoteResponse;
import com.example.keynoteservice.entities.Keynote;
import com.example.keynoteservice.mapper.KeynoteMapper;
import com.example.keynoteservice.repository.KeynoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class KeynoteService {

    private final KeynoteRepository keynoteRepository;
    private final KeynoteMapper keynoteMapper;

    public KeynoteResponse createKeynote(KeynoteRequest request) {
        Keynote keynote = keynoteMapper.toEntity(request);
        Keynote savedKeynote = keynoteRepository.save(keynote);
        return keynoteMapper.toResponse(savedKeynote);
    }

    public KeynoteResponse getKeynoteById(Long id) {
        Keynote keynote = keynoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Keynote not found with id: " + id));
        return keynoteMapper.toResponse(keynote);
    }

    public List<KeynoteResponse> getAllKeynotes() {
        return keynoteRepository.findAll().stream()
                .map(keynoteMapper::toResponse)
                .collect(Collectors.toList());
    }

    public KeynoteResponse updateKeynote(Long id, KeynoteRequest request) {
        Keynote existingKeynote = keynoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Keynote not found with id: " + id));
        
        existingKeynote.setNom(request.getNom());
        existingKeynote.setPrenom(request.getPrenom());
        existingKeynote.setEmail(request.getEmail());
        existingKeynote.setFonction(request.getFonction());
        
        Keynote updatedKeynote = keynoteRepository.save(existingKeynote);
        return keynoteMapper.toResponse(updatedKeynote);
    }

    public void deleteKeynote(Long id) {
        if (!keynoteRepository.existsById(id)) {
            throw new RuntimeException("Keynote not found with id: " + id);
        }
        keynoteRepository.deleteById(id);
    }
}
