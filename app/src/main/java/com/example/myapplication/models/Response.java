package com.example.myapplication.models;

import java.util.List;

public class Response {
    private Boolean status;
    private List<Word> data;

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setData(List<Word> data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public List<Word> getData() {
        return data;
    }
}
