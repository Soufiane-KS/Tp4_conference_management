package com.example.conferenceservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor @Builder @Getter @Setter
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    
    @Enumerated(EnumType.STRING)
    private ConferenceType type;
    private LocalDateTime date;
    private Integer duration;
    private Integer attendeesCount = 0;
    private Double score = 0.0;
    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
    
    public enum ConferenceType {
        ACADEMIC, COMMERCIAL
    }
}
