package com.example.demo.web;

import com.example.demo.domain.Greeting;
import com.example.demo.domain.GreetingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingRepository greetingRepository;

    @Test
    void greetingEndpointReturnsMessage() throws Exception {
        when(greetingRepository.findAll()).thenReturn(List.of(new Greeting("Salut")));

        mockMvc.perform(get("/api/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string("Salut"));
    }
}
