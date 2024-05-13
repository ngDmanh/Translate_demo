package com.example.myapplication.api;

import com.example.myapplication.models.CambridgeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CambridgeService {
    @GET("api/dictionary/cambridge")
    Call<CambridgeResponse> searchByKeyword(@Query("search") String keyword);
}
