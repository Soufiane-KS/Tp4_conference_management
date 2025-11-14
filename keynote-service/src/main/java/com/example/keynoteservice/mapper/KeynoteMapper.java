package com.example.keynoteservice.mapper;

import com.example.keynoteservice.dto.KeynoteRequest;
import com.example.keynoteservice.dto.KeynoteResponse;
import com.example.keynoteservice.entities.Keynote;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface KeynoteMapper {
    
    Keynote toEntity(KeynoteRequest request);
    
    KeynoteResponse toResponse(Keynote keynote);
}
