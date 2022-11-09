package com.spotify.project.mappingservices;

import com.spotify.project.dtos.ArtistDto;
import com.spotify.project.models.Artist;
import com.spotify.project.models.Song;

import java.util.List;
import java.util.stream.Collectors;

public class ArtistMappingService {
    public ArtistDto mapArtistToDto(Artist artist) {
        List<String> songs = artist.getSongs().stream()
                .map(Song::getTitle)
                .collect(Collectors.toList());
        return new ArtistDto(artist.getId(), artist.getName(),
                artist.getNationality(), artist.getBirthDate(), songs);
    }
}
