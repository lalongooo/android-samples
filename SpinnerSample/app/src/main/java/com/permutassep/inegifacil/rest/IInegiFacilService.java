package com.permutassep.inegifacil.rest;

import com.permutassep.inegifacil.model.City;
import com.permutassep.inegifacil.model.Town;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface  IInegiFacilService {

    @GET("/cities/{id}")
    void getCities(@Path("id") String id, Callback<List<City>> callback);

    @GET("/towns/{stateId}/{cityId}")
    void getTowns(@Path("stateId") String stateId, @Path("cityId") String cityId, Callback<List<Town>> callback);
}
