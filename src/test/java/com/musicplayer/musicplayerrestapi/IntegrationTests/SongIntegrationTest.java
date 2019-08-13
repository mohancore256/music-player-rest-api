package com.musicplayer.musicplayerrestapi.IntegrationTests;


import TestUtils.TestPlaylist;
import TestUtils.TestSongs;
import com.musicplayer.musicplayerrestapi.models.Playlist;
import com.musicplayer.musicplayerrestapi.models.Song;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SongIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    private Song mysong;

    @Before
    public void testSetUp(){
        mysong = TestSongs.getSongs().get(3);
    }

    @Test
    public void postingSong_savesSong(){

        //act
        ResponseEntity<String> response = testRestTemplate.postForEntity("/song/save", mysong, String.class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("saved");
    }



}




