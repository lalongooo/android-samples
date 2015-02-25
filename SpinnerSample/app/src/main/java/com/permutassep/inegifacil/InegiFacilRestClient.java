package com.permutassep.inegifacil;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by jorge.hernandez on 2/24/2015.
 */
public class InegiFacilRestClient {

    private static IInegiFacilService REST_CLIENT;
    private static String ROOT = "http://inegifacil.com/";

    static {
        setupRestClient();
    }

    private InegiFacilRestClient() {}

    public static IInegiFacilService get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ROOT)
                .build();
//                .setClient(new OkClient(new OkHttpClient()))
//                .builder.setLogLevel(RestAdapter.LogLevel.FULL);

        REST_CLIENT = restAdapter.create(IInegiFacilService.class);
    }
}
