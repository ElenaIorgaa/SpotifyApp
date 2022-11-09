package com.spotify.project.mappingservices;

import com.spotify.project.dtos.SongDto;
import com.spotify.project.models.Artist;
import com.spotify.project.models.Song;

import java.util.List;
import java.util.stream.Collectors;

public class SongMappingService {
    public SongDto mapSongToDto(Song song) {
        List<String> artists = song.getArtists().stream()
                .map(Artist::getName)
                .collect(Collectors.toList());
        return new SongDto(song.getId(), song.getTitle(),
                song.getDuration(), song.getLanguage(),
                song.getReleaseDate(), artists);
    }
}
