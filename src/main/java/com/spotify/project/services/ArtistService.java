package com.spotify.project.services;

import com.spotify.project.models.Artist;
import com.spotify.project.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository repository;

    public List<Artist> getAllArtists() {
        List<Artist> artists = repository.findAll();
        if (artists.size() > 0)
            return artists;
        else
            return new ArrayList<>();
    }

    public Artist createOrUpdate(Artist artist) {
        List<Artist> artists = getAllArtists();
        for (Artist s : artists) {
            if (Objects.equals(s.getName(), artist.getName()) && s.getBirthDate() == artist.getBirthDate()) {
                artist.setId(artist.getId());
            }
        }
        artist = repository.save(artist);
        return artist;
    }

    public Optional<Artist> getArtistById(int id) {
        return repository.findById(id);
    }

    public void deleteArtistById(int id) {
        repository.deleteById(id);
    }
}
