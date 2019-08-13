package com.musicplayer.musicplayerrestapi.controllerTest;

import TestUtils.TestSongs;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicplayer.musicplayerrestapi.controller.SongController;
import com.musicplayer.musicplayerrestapi.models.Song;
import com.musicplayer.musicplayerrestapi.service.SongService;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(SongController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SongService songService;

    @Test
    public void postingSong_savingTheSong() throws Exception {
        //arrange
        Song song = TestSongs.getSongs().get(1);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/song/save")
                                                   .contentType(MediaType.APPLICATION_JSON)
                                                    .content(objectMapper.writeValueAsString(song));
       // assert
        mockMvc.perform(builder).andExpect(status().isOk());
        verify(songService, times(1)).saveSong(any(Song.class));

    }
}
