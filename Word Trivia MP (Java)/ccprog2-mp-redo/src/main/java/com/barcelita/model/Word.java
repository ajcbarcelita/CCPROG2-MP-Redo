package com.barcelita.model;

import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<Trivia> trivias;

    public Word(String word) {
        this.word = word;
        this.trivias = new ArrayList<Trivia>();
    }

    public Word(String word, ArrayList<Trivia> trivias) {
        this.word = word;
        this.trivias = trivias;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<Trivia> getTrivias() {
        return trivias;
    }

    public void setTrivias(ArrayList<Trivia> trivias) {
        this.trivias = trivias;
    }
}
