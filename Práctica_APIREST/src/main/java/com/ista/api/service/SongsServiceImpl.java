package com.ista.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.api.dao.ISongsDao;
import com.ista.api.entity.Songs;

@Service
public class SongsServiceImpl implements SongsService {

    @Autowired
    private ISongsDao songDao;

    @Override
    public Songs createSong(Songs song) {
        return songDao.save(song);
    }

    @Override
    public List<Songs> getAllSongs() {
        return songDao.findAll();
    }

    @Override
    public Optional<Songs> getSongById(Long id) {
        return songDao.findById(id);
    }

    @Override
    public Songs updateSong(Long id, Songs song) {
        Optional<Songs> existingSong = songDao.findById(id);
        if (existingSong.isPresent()) {
            Songs updatedSong = existingSong.get();
            updatedSong.setTitle(song.getTitle());
            updatedSong.setArtist(song.getArtist());
            updatedSong.setAlbum(song.getAlbum());
            updatedSong.setYear(song.getYear());
            return songDao.save(updatedSong);
        }
        return null;
    }

    @Override
    public void deleteSong(Long id) {
    	songDao.deleteById(id);
    }
}
