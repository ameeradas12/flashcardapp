package com.ameeradas.flashcardapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FlashcardController {

    private Map<String, Deck> userDecks = new HashMap<>();
    private ObjectMapper mapper = new ObjectMapper();
    private String dataFolder = "data";

    @GetMapping("/cards")
    public List<Flashcard> getCards(@RequestParam String user) {
        Deck deck = loadOrGetDeck(user);
        return deck.getCards();
    }

    @PostMapping("/cards")
    public String addCard(@RequestParam String user, @RequestParam String question, @RequestParam String answer) {
        Deck deck = userDecks.getOrDefault(user, new Deck(user));
        deck.addCard(new Flashcard(question, answer));
        saveDeck(user, deck);
        userDecks.put(user, deck);
        return "Card added";
    }

      private Deck loadOrGetDeck(String user) {
        if (userDecks.containsKey(user)) {
            return userDecks.get(user);
        }

        File file = new File(dataFolder + "/" + user + ".json");
        Deck deck;

        if (file.exists()) {
            try {
                Flashcard[] savedCards = mapper.readValue(file, Flashcard[].class);
                deck = new Deck(user);
                for (Flashcard card : savedCards) {
                    deck.addCard(card);
                }
            } catch (IOException e) {
                deck = new Deck(user);
            }
        } else {
            deck = new Deck(user);
        }

        userDecks.put(user, deck);
        return deck;
    }

    private void saveDeck(String user, Deck deck) {
        try {
            File folder = new File(dataFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            File file = new File(dataFolder + "/" + user + ".json");
            mapper.writeValue(file, deck.getCards());
        } catch (IOException e) {
            System.out.println("Failed to save deck for " + user);
        }
    }
}