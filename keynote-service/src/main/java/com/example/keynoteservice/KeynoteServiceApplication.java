package com.example.keynoteservice;

import com.example.keynoteservice.entities.Keynote;
import com.example.keynoteservice.repository.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KeynoteRepository keynoteRepository) {
        return args -> {
            keynoteRepository.save(Keynote.builder()
                            .nom("KOUSTA")
                            .prenom("Soufiane")
                            .email("soufianekousta@gmail.com")
                            .fonction("cybersecurity")
                    .build());
            keynoteRepository.save(Keynote.builder()
                    .nom("hardizi")
                    .prenom("Achraf")
                    .email("hachraf@gmail.com")
                    .fonction("devops")
                    .build());
            keynoteRepository.save(Keynote.builder()
                    .nom("kandil")
                    .prenom("safone")
                    .email("safeone@gmail.com")
                    .fonction("ai")
                    .build());
            keynoteRepository.findAll().forEach(k->{
                System.out.println("=======================");
                System.out.println(k.getNom());
                System.out.println(k.getPrenom());
                System.out.println(k.getEmail());
                System.out.println(k.getFonction());
                System.out.println("=======================");
            });
        };
    }
}
