package com.ameeradas.flashcardapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class FlashcardController {

    private Deck testDeck = new Deck("test1");

    public FlashcardController() {
        testDeck.addCard(new Flashcard("What class is googer?", "Oni"));
        testDeck.addCard(new Flashcard("Is googer better than taco?", "Yes"));
        testDeck.addCard(new Flashcard("What's 2+2", "4"));
    }

    @GetMapping("/cards")
    public List<Flashcard> getCards() {
        return testDeck.getCards();
    }

    @PostMapping("/cards")
    public String addCard(@RequestParam String question, @RequestParam String answer) {
    Flashcard newCard = new Flashcard(question, answer);
    testDeck.addCard(newCard);
    return "Card added!";
    }
}