package com.musicplayer.musicplayerrestapi.ServiceTest;

import TestUtils.TestSongs;
import com.musicplayer.musicplayerrestapi.Repositoies.SongRepository;
import com.musicplayer.musicplayerrestapi.models.Song;
import com.musicplayer.musicplayerrestapi.service.SongService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class SongServiceTest {

    @Mock
    private SongRepository songRepository;

    @Autowired
    private SongService songService;

    @Before
    public void setUp(){
        songService = new SongService(songRepository);
    }

    @Test
    public void saveSong_savesTheSong(){
        //arrange
        Song song = TestSongs.getSongs().get(3);

        //act
        songService.saveSong(song);
        verify(songRepository, times(1)).save(song) ;

    }
}
