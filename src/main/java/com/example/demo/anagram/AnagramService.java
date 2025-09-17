package com.example.demo.anagram;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnagramService {

    private final AnagramRepository anagramRepository;

    public AnagramService(AnagramRepository anagramRepository) {
        this.anagramRepository = anagramRepository;
    }

    public List<String> findAnagrams(String word) throws IOException {
        var anagrams = new ArrayList<String>();
        var wordList = anagramRepository.loadWordList();
        var sortedWord = sortWords(word).toLowerCase();
        wordList.forEach( w -> {
            if (sortedWord.equals(sortWords(w))) anagrams.add(w);
        });
        return anagrams.stream().filter(w -> !w.equals(word)).toList();
    }

    private String sortWords(String word) {
        var characters = word.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }


}
