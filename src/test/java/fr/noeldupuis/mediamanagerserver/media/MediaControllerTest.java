package fr.noeldupuis.mediamanagerserver.media;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MediaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getOnMediasReturns200() throws Exception {
        this.mockMvc.perform(get("/medias"))
                .andExpect(status().isOk());
    }

    @Test
    public void getOnMediasReturnNoData() throws Exception {
        this.mockMvc.perform(get("/medias"))
                .andExpect(content().string("[]"));
    }

    @Test
    public void postMediaReturns200andMediaData() throws Exception {
        MediaDTO mediaDTO = MediaDTO.builder()
                .name("Test Media")
                .type("MOVIE")
                .id(2L).build();
        this.mockMvc.perform(
                post("/medias")
                        .content(new ObjectMapper().writeValueAsString(mediaDTO))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").isString())
                .andExpect(jsonPath("$.name").value("Test Media"))
                .andExpect(jsonPath("$.type").isString())
                .andExpect(jsonPath("$.type").value("MOVIE"));
    }

}