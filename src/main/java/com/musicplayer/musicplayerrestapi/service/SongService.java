package com.musicplayer.musicplayerrestapi.service;

import com.musicplayer.musicplayerrestapi.Repositoies.SongRepository;
import com.musicplayer.musicplayerrestapi.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {


    private SongRepository songRepository;

    @Autowired
    public SongService (SongRepository songRepository){
           this.songRepository = songRepository;
    }

    public void saveSong(Song song){
          songRepository.save(song);
    }
}
