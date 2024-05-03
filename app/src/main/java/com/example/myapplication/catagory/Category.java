package com.example.myapplication.catagory;

import android.widget.TextView;

import java.util.List;

public class Category {
    private String nameCategory;
    private TextView tvWord;
    public Category(String nameCategory, TextView tvWord) {
        this.nameCategory = nameCategory;
        this.tvWord = tvWord;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public TextView getTvWord() {
        return tvWord;
    }

    public void setTvWord(TextView tvWord) {
        this.tvWord = tvWord;
    }
}
