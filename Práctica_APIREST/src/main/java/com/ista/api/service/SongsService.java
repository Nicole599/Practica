package com.ista.api.service;

import java.util.List;
import java.util.Optional;

import com.ista.api.entity.Songs;

public interface SongsService {
    Songs createSong(Songs song);
    List<Songs> getAllSongs();
    Optional<Songs> getSongById(Long id);
    Songs updateSong(Long id, Songs song);
    void deleteSong(Long id);

}
