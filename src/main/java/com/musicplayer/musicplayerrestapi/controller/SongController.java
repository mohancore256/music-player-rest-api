package com.musicplayer.musicplayerrestapi.controller;

import com.musicplayer.musicplayerrestapi.Repositoies.SongRepository;
import com.musicplayer.musicplayerrestapi.models.Song;
import com.musicplayer.musicplayerrestapi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    public SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService ;

    }

    @PostMapping("song/save")
    public String postSong(@RequestBody Song song){
        songService.saveSong(song);
        return "saved";
    }
}
