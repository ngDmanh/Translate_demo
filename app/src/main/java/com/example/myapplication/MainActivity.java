package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.WordAdapter;
import com.example.myapplication.api.CambridgeAPIClient;
import com.example.myapplication.api.CambridgeService;
import com.example.myapplication.models.CambridgeResponse;
import com.example.myapplication.models.Word;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private CambridgeService cambridgeService;

    // Khai báo biến
    private TextView tvTitle;
    private ImageButton ibFind;
    private EditText etWrite;
    private ImageButton ibClose;
    private RecyclerView rcvWords;
    private WordAdapter wordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    void initView() {
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.tvTitle);
        ibFind = findViewById(R.id.ibFind);
        etWrite = findViewById(R.id.etWrite);
        ibClose = findViewById(R.id.ibClose);
        rcvWords = findViewById(R.id.rcvWords);

        ibFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = etWrite.getText().toString();
                searchByKeyword(keyword);
            }
        });
        ibClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etWrite.setText(null);
            }
        });

        wordAdapter = new WordAdapter();
        rcvWords.setHasFixedSize(true);
        rcvWords.setAdapter(wordAdapter);
    }


    void initData() {
        cambridgeService = CambridgeAPIClient.getClient().create(CambridgeService.class);
    }
    void searchByKeyword(String keyword) {
        Call<CambridgeResponse> call = cambridgeService.searchByKeyword(keyword);
        call.enqueue(new Callback<CambridgeResponse>() {
            @Override
            public void onResponse(@NonNull Call<CambridgeResponse> call, @NonNull retrofit2.Response<CambridgeResponse> response) {
                CambridgeResponse cambridgeResponse = response.body();
                List<Word> listWord = cambridgeResponse != null && cambridgeResponse.getStatus() ? cambridgeResponse.getData() : new ArrayList<>();
                if (!listWord.isEmpty()) {
                    displayWords(listWord);
                } else {
                    Toast.makeText(MainActivity.this, "Call api error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CambridgeResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call api error", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }

    void displayWords(List<Word> listWord) {
        if (wordAdapter != null) {
            wordAdapter.setListWord(listWord);
            wordAdapter.notifyDataSetChanged();
        }
    }
}