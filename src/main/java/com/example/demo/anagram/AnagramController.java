package com.example.demo.anagram;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/anagram")
public class AnagramController {

    private final AnagramService anagramService;

    public AnagramController(AnagramService anagramService) {
        this.anagramService = anagramService;
    }

    @GetMapping("/{word}")
    public List<String> findAnagram(@PathVariable("word") String word) throws IOException {
        return anagramService.findAnagrams(word);
    }
}
