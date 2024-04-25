package com.example.myapplication.models;

public class Word {
    private String _id;
    private String category;
    private String title;
    private String grammar;
    private Pronounce pronounce;
    private String infl;
    private String info;

    private Content contents;

    private Integer __v;

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

    public Content getContents() {
        return contents;
    }

    public Integer getV() {
        return __v;
    }
}
