package com.example.lab1_and;

import com.example.lab1_and.Model.SPModel;
import com.example.lab1_and.Model.StudentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
     String DOMAIN = "http://192.168.0.105:3000/";
   @GET("/api/list")
    Call<List<SPModel>> getSanPhams();

    @POST("sanphams")
    Call<SPModel> createSanPham();
}
