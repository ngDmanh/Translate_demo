package com.example.myapplication.models;

import java.io.Serial;

import kotlin.jvm.internal.SerializedIr;

public class Us {
    private String text;
    private String media;
    private String _id;

    public void setText(String text) {
        this.text = text;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public String getMedia() {
        return media;
    }

    public String getId() {
        return _id;
    }
}
