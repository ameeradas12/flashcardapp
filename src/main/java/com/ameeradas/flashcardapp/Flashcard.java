package com.ameeradas.flashcardapp;

public class Flashcard {
    private String question;
    private String answer;

    public Flashcard(String q, String a){
        question = q;
        answer = a;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean checkAnswer(String guess) {
        return guess.trim().equalsIgnoreCase(answer);
    }
}