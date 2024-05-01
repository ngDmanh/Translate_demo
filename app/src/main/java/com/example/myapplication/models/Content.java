package com.example.myapplication.models;

import java.util.List;

public class Content {
    private String guideword;
    private List<Meaning> meanings;
    private List<Phrases> phrases;
    private String _id;

    public void setGuideWord(String guideword) {
        this.guideword = guideword;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    public void setPhrases(List<Phrases> phrases) {
        this.phrases = phrases;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getGuideWord() {
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