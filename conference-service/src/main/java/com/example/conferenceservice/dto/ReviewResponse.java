package com.example.conferenceservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder @Getter  @Setter
public class ReviewResponse {
    private Long id;
    private LocalDateTime date;
    private String text;
    private Integer rating;
}
