package com.permutassep.inegifacil;

import com.permutassep.inegifacil.model.City;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface  IInegiFacilService {

    @GET("/cities/{id}")
    void getCities(@Path("id") String id, Callback<List<City>> callback);
}
