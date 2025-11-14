package com.example.keynoteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KeynoteRequest {
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
}
