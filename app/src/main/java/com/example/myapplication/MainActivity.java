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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.api.CambridgeAPIClient;
import com.example.myapplication.api.CambridgeService;
import com.example.myapplication.catagory.Category;
import com.example.myapplication.catagory.CategoryAdapter;
import com.example.myapplication.models.CambridgeResponse;
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
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
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
        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);



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
    }
    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();

        listCategory.add(new Category("Category 1",null));
        listCategory.add(new Category("Category 2",null));
        listCategory.add(new Category("Category 3",null));
        listCategory.add(new Category("Category 4",null));
        listCategory.add(new Category("Category 5",null));
        listCategory.add(new Category("Category 6",null));
        listCategory.add(new Category("Category 7",null));
        listCategory.add(new Category("Category 8",null));

        return listCategory;
    }

    void initData() {
        cambridgeService = CambridgeAPIClient.getClient().create(CambridgeService.class);
    }
    void searchByKeyword(String keyword) {
        Call<CambridgeResponse> call = cambridgeService.searchByKeyword(keyword);
        call.enqueue(new Callback<CambridgeResponse>() {
            @Override
            public void onResponse(@NonNull Call<CambridgeResponse> call, @NonNull retrofit2.Response<CambridgeResponse> response) {
                Toast.makeText(MainActivity.this, "Call api Success", Toast.LENGTH_SHORT).show();
                CambridgeResponse cambridgeResponse = response.body();
//                if(cambridgeResponse != null && cambridgeResponse.getStatus()){
//                    tvResult.setText(String.valueOf(cambridgeResponse.getData()));
//                }
                Log.d("test", new Gson().toJson(cambridgeResponse));
            }

            @Override
            public void onFailure(@NonNull Call<CambridgeResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call api error", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }
}