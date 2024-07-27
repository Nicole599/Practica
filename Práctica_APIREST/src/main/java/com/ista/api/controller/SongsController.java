package com.ista.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.api.entity.Songs;
import com.ista.api.service.SongsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/songs")
public class SongsController {

    @Autowired
    private SongsService songService;

    @PostMapping
    public ResponseEntity<Songs> createSong(@RequestBody Songs song) {
        Songs createdSong = songService.createSong(song);
        return ResponseEntity.status(201).body(createdSong);
    }

    @GetMapping
    public List<Songs> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Songs> getSongById(@PathVariable Long id) {
        return songService.getSongById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSong(@PathVariable Long id, @RequestBody Songs song) {
        Songs updatedSong = songService.updateSong(id, song);
        if (updatedSong != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }
}