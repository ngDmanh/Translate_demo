package com.example.myapplication.models;
import java.util.List;
public class Meaning {
    private String info;
    private String meaning;
    private List<String> examples;
    private String _id;

    public void setInfo(String info) {
        this.info = info;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setExamples(List<String> examples) {
        this.examples = examples;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getInfo() {
        return info;
    }

    public String getMeaning() {
        return meaning;
    }

    public List<String> getExamples() {
        return examples;
    }

    public String getId() {
        return _id;
    }
}
