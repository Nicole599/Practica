package com.ista.api.service;

import java.util.List;
import java.util.Optional;

import com.ista.api.entity.Playlist;

public interface PlaylistService {
    Playlist createPlaylist(Playlist playlist);
    List<Playlist> getAllPlaylists();
    Optional<Playlist> getPlaylistByName(String name);
    Playlist updatePlaylist(String name, Playlist playlist);
    void deletePlaylist(String name);
}
