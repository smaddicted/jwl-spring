package com.example.demo.anagram;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class AnagramRepository {

    private final String filename = "words.txt";

    public Set<String> loadWordList() throws IOException {
        var wordList = new ArrayList<String>();

        try (var words = getClass().getClassLoader().getResourceAsStream(filename)) {
            var reader = new BufferedReader(new InputStreamReader(words));
            String word;
            while ((word = reader.readLine()) != null) {
                wordList.add(word.toLowerCase());
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return new HashSet<>(wordList);
    }
}
