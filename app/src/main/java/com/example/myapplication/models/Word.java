package com.example.myapplication.models;

import java.util.List;

public class Word {
    private String _id;
    private String category;
    private String title;
    private String grammar;
    private Pronounce pronounce;
    private String infl;
    private String info;

    private List<Content> contents;

    private Integer __v;

    public void setId(String _id) {
        this._id = _id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGrammar(String grammar) {
        this.grammar = grammar;
    }

    public void setPronounce(Pronounce pronounce) {
        this.pronounce = pronounce;
    }

    public void setInfl(String infl) {
        this.infl = infl;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    public String getId() {
        return _id;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getGrammar() {
        return grammar;
    }

    public Pronounce getPronounce() {
        return pronounce;
    }

    public String getInfl() {
        return infl;
    }

    public String getInfo() {
        return info;
    }

    public List<Content> getContents() {
        return contents;
    }

    public Integer getV() {
        return __v;
    }
}
