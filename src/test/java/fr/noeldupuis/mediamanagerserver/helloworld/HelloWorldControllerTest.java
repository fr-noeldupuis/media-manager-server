package fr.noeldupuis.mediamanagerserver.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void callingGreetingsEndPointReturns200() throws Exception {
        this.mockMvc.perform(get("/greetings")).andExpect(status().isOk());
    }

    @Test
    public void callingGreetingsEndPointReturnsHelloWorldMessage() throws Exception {
        this.mockMvc.perform(get("/greetings"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }

}