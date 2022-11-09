package com.spotify.project.services;

import com.spotify.project.models.Artist;
import com.spotify.project.models.SongArtist;
import com.spotify.project.repository.SongArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongArtistService {
    @Autowired
    private SongArtistRepository repository;

    public Optional<SongArtist> getSongArtistById(int id)
    {
        return repository.findById(id);
    }
}
