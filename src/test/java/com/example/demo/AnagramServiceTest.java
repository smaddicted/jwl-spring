package com.example.demo;

import com.example.demo.anagram.AnagramRepository;
import com.example.demo.anagram.AnagramService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.io.IOException;
import java.util.Set;

import static org.mockito.Mockito.when;

@SpringBootTest
public class AnagramServiceTest {

    @Autowired
    private AnagramService anagramService;

    @MockitoBean
    private AnagramRepository anagramRepository;

    @Test
    void shouldReturnAnagrams() throws IOException {
        var wordList = Set.of("pots", "post", "spot", "stop", "tops");

        when(anagramRepository.loadWordList()).thenReturn(wordList);
        var result = anagramService.findAnagrams("spot");
        assert result.size() == 4;
    }
}
