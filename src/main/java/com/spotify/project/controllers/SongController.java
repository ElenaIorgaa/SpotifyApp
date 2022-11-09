package com.spotify.project.controllers;

import com.spotify.project.dtos.SongDto;
import com.spotify.project.mappingservices.SongMappingService;
import com.spotify.project.services.SongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongMappingService songMappingService = new SongMappingService();

    private final SongService songService;

    public SongController(SongService songService) {
        super();
        this.songService = songService;
    }

    @GetMapping
    public List<SongDto> getAllSongs() {
        return songService.getAllSongs().stream()
                .map(songMappingService::mapSongToDto)
                .collect(Collectors.toList());

    }
}
