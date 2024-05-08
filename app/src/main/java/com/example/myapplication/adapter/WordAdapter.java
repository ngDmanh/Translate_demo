package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.models.Content;
import com.example.myapplication.models.Pronounce;
import com.example.myapplication.models.Uk;
import com.example.myapplication.models.Us;
import com.example.myapplication.models.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    private List<Word> listWord = new ArrayList<>();

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
        return new WordViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if (position < listWord.size()) {
            Word word = listWord.get(position);
            if (word != null) holder.bindData(word);
        }
    }

    @Override
    public int getItemCount() {
        return listWord.size();
    }

    public void setListWord(List<Word> listWord) {
        this.listWord = listWord;
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvCategory, tvTitle, tvGrammar, tvInfl, tvInfo;
        private final TextView tvPronounceUS;
        private final TextView tvPronounceUK;
        private final RecyclerView rcvContents;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvGrammar = itemView.findViewById(R.id.tvGrammar);
            tvPronounceUS = itemView.findViewById(R.id.tvPronounceUS);
            tvInfl = itemView.findViewById(R.id.tvInfl);
            tvInfo = itemView.findViewById(R.id.tvInfo);
            tvPronounceUK = itemView.findViewById(R.id.tvPronounceUK);
            rcvContents = itemView.findViewById(R.id.rcvContents);

        }

        public void bindData(@NonNull Word word) {
            tvCategory.setText(!Objects.equals(word.getCategory(), "") ? word.getCategory() : word.getTitle());
            tvTitle.setText(word.getTitle());
            tvGrammar.setText(word.getGrammar());
            tvInfl.setText(word.getInfl());
            tvInfo.setText(word.getInfo());
            Pronounce pronounce = word.getPronounce();
            Us us = pronounce == null ? null : pronounce.getUs();
            Uk uk = pronounce == null ? null : pronounce.getUk();

            tvPronounceUS.setText(us == null ? "" : us.getText());
            tvPronounceUK.setText(uk == null ? "" : uk.getText());

            ContentAdapter contentAdapter = new ContentAdapter(word.getContents());
            rcvContents.setHasFixedSize(true);
            rcvContents.setAdapter(contentAdapter);
            contentAdapter.notifyDataSetChanged();
        }
    }
}
