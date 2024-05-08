package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Meaning;

import java.util.ArrayList;
import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningAdapter.MeaningViewHolder> {
    private final List<Meaning> listMeaning;

    public MeaningAdapter(List<Meaning> listMeaning) {
        this.listMeaning = listMeaning == null ? new ArrayList<>() : listMeaning;
    }

    @NonNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meaning, parent, false);
        return new MeaningViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {
        if (position < listMeaning.size()) {
            Meaning meaning = listMeaning.get(position);
            if (meaning != null) holder.binData(meaning);
        }
    }

    @Override
    public int getItemCount() {
        return listMeaning.size();
    }

    public static class MeaningViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvMeaning;
        private final RecyclerView rcvExamples;

        public MeaningViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMeaning = itemView.findViewById(R.id.tvMeaning);
            rcvExamples = itemView.findViewById(R.id.rcvExamples);
        }

        public void binData(@NonNull Meaning meaning) {
            tvMeaning.setText(meaning.getMeaning());

            ExampleAdapter exampleAdapter = new ExampleAdapter(meaning.getExamples());
            rcvExamples.setAdapter(exampleAdapter);
            exampleAdapter.notifyDataSetChanged();
        }
    }
}
