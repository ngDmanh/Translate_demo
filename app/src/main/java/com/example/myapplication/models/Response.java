package com.example.myapplication.models;

import java.util.List;

public class Response {
    private Boolean status;
    private List<Word> data;

    public Boolean getStatus() {
        return status;
    }

    public List<Word> getData() {
        return data;
    }
}
