package com.example.myapplication.models;

import java.util.List;

public class Phrases {
    private String title;
    private String info;
    private List<Meaning> meanings;
    private  String _id;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public String getId() {
        return _id;
    }
}
