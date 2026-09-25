package com.ameeradas.flashcardapp;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private String name;
    private List<Flashcard> cards = new ArrayList<>();

    public Deck(String name){
        this.name = name;
    }

    public void addCard(Flashcard card){
        cards.add(card);
    }

    public List<Flashcard> getCards(){
        return cards;
    }

    public int size(){
        return cards.size();
    }

    public String getName(){
        return name;
    }
}