package com.spotify.project.controllers;

import com.spotify.project.dtos.SongDto;
import com.spotify.project.models.Song;
import com.spotify.project.services.SongService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    @Autowired
    private ModelMapper modelMapper;

    private SongService songService;

    public SongController(SongService songService)
    {
        super();
        this.songService = songService;
    }
    @GetMapping
    public List<SongDto> getAllSongs()
    {
        return songService.getAllSongs().stream()
                .map(song ->
                        modelMapper.map(song, SongDto.class))
                .collect(Collectors.toList());

    }
}
