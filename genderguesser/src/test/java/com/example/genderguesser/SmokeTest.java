package com.example.genderguesser;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.genderguesser.GenderTokens.GenderTokenController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private GenderTokenController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}