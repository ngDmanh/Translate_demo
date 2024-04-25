package com.example.myapplication.models;

import java.util.List;

public class Content {
    private String guideword;
    private List<Meaning> meanings;
    private List<Phrases> phrases;
    private String _id;

    public String getGuideword() {
        return guideword;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public Content(List<Phrases> phrases) {
        this.phrases = phrases;
    }

    public String getId() {
        return _id;
    }
}