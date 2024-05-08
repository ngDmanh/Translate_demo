package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Content;
import com.example.myapplication.models.Word;

import java.util.ArrayList;
import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {
    private final List<Content> listContent;

    public ContentAdapter(List<Content> listContent) {
        this.listContent = listContent == null ? new ArrayList<>() : listContent;
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        if (position < listContent.size()) {
            Content content = listContent.get(position);
            if (content != null) holder.binData(content);
        }
    }

    @Override
    public int getItemCount() {
        return listContent.size();
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvGuideWord;
        private final RecyclerView rcvMeanings;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGuideWord = itemView.findViewById(R.id.tvGuideWord);
            rcvMeanings = itemView.findViewById(R.id.rcvMeanings);
        }

        public void binData(@NonNull Content content) {
            tvGuideWord.setText(content.getGuideWord());
            MeaningAdapter meaningAdapter = new MeaningAdapter(content.getMeanings());
            rcvMeanings.setAdapter(meaningAdapter);
            meaningAdapter.notifyDataSetChanged();
        }
    }


}
