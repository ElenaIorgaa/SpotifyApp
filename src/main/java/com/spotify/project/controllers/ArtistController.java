package com.spotify.project.controllers;

import com.spotify.project.dtos.ArtistDto;
import com.spotify.project.mappingservices.ArtistMappingService;
import com.spotify.project.services.ArtistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistMappingService artistMappingService = new ArtistMappingService();
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        super();
        this.artistService = artistService;
    }

    @GetMapping
    public List<ArtistDto> getAllArtists() {
        return artistService.getAllArtists().stream()
                .map(artistMappingService::mapArtistToDto)
                .collect(Collectors.toList());
    }
}
