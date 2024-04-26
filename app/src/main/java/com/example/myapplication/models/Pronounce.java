package com.example.myapplication.models;

public class Pronounce {
    private Us us;
    private Uk uk;
    private String _id;

    public void setUs(Us us) {
        this.us = us;
    }

    public void setUk(Uk uk) {
        this.uk = uk;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public Us getUs() {
        return us;
    }

    public Uk getUk() {
        return uk;
    }

    public String getId() {
        return _id;
    }
}