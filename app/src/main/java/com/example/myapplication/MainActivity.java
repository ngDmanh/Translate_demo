package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.api.CambridgeAPIClient;
import com.example.myapplication.api.CambridgeService;
import com.example.myapplication.models.CambridgeResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private CambridgeService cambridgeService;

    // Khai báo biến
    TextView tvTitle;
    ImageButton ibFind;
    EditText etWrite;
    ImageButton ibClose;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        searchByKeyword("hello");

        // Thiết lập Adapter cho AutoCompleteTextView
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, suggestedWords);
//        autoCompleteTextView.setAdapter(adapter);
//        autoCompleteTextView.setThreshold(1); // Khắc phục lỗi ko hiện gợi ý
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
    void initView() {
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Khai báo biến
        tvTitle = findViewById(R.id.tvTitle);
        ibFind = findViewById(R.id.ibFind);
        etWrite = findViewById(R.id.etWrite);
        ibClose = findViewById(R.id.ibClose);
        tvResult = findViewById(R.id.tvResult);
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
                Log.d("test", new Gson().toJson(cambridgeResponse));
            }

            @Override
            public void onFailure(@NonNull Call<CambridgeResponse> call, Throwable t) {
                call.cancel();
            }
        });
    }
}