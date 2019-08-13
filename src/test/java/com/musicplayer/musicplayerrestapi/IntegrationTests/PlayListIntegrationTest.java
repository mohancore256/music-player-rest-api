package com.musicplayer.musicplayerrestapi.IntegrationTests;

import TestUtils.TestPlaylist;
import com.musicplayer.musicplayerrestapi.models.Playlist;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
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
public class PlayListIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    private Playlist myplaylist;

    @Before
    public void testSetUp(){
        myplaylist = TestPlaylist.getTestPlaylist();
    }

    @Test
    public void postingplaylist_savesThePlaylist(){

        //act
        ResponseEntity<String> response = testRestTemplate.postForEntity("/playlist/save", myplaylist, String.class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("saved");
    }

}
