package com.example.demo;

import com.example.demo.anagram.AnagramService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class AnagramServiceIT {

    @Autowired
    private AnagramService anagramService;

    @Test
    void shouldReturnAnagrams() throws IOException {
        var result = anagramService.findAnagrams("meat");
        assert result.size() == 4;
    }

    @Test
    void shouldReturnNoAnagrams() throws IOException {
        var result = anagramService.findAnagrams("burrito");
        assert result.isEmpty();
    }
}
