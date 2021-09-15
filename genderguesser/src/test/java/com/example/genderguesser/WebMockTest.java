package com.example.genderguesser;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.genderguesser.GenderTokens.GenderToken;
import com.example.genderguesser.GenderTokens.GenderTokenController;
import com.example.genderguesser.GenderTokens.GenderTokenService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(GenderTokenController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GenderTokenService service;

    @Test
    public void gendertokensShouldReturnMessageFromService() throws Exception {
        when(service.getGenderTokens_static("male")).thenReturn(List.of(
                new GenderToken(
                        1L,
                        "It's alive",
                        "")));

        this.mockMvc.perform(get("/api/gendertokens")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("ADAM")));
    }
}