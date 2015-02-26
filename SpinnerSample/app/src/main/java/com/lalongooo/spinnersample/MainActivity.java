package com.lalongooo.spinnersample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.permutassep.inegifacil.model.City;
import com.permutassep.inegifacil.model.State;
import com.permutassep.inegifacil.model.Town;
import com.permutassep.inegifacil.rest.InegiFacilRestClient;
import com.permutassep.model.CitySpinnerBaseAdapter;
import com.permutassep.model.StateSpinnerBaseAdapter;
import com.permutassep.model.TownSpinnerBaseAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity {

    private Spinner spnState;
    private Spinner spnMunicipality;
    private Spinner spnLocality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnState = (Spinner) findViewById(R.id.spnState);
        spnMunicipality = (Spinner) findViewById(R.id.spnMunicipality);
        spnLocality = (Spinner) findViewById(R.id.spnLocality);
        fillStates();
    }


    private void fillStates(){

        ArrayList<State> alStates = new ArrayList<>();
        String [] states = getResources().getStringArray(R.array.states);

        for (int i = 0; i < states.length; i++){
            alStates.add(new State(i, states[i]));
        }

        spnState.setAdapter(new StateSpinnerBaseAdapter(getApplicationContext(), alStates));
        spnState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                State selectedState = (State)parent.getItemAtPosition(position);
                if(selectedState.getId() != 0){

                    // Remove localities
                    if (spnLocality.getAdapter() != null && spnLocality.getAdapter().getCount() > 0){
                        spnLocality.setAdapter(null);
                    }

                    try {
                        InegiFacilRestClient.get().getCities(String.valueOf(selectedState.getId()), new Callback<List<City>>() {
                            @Override
                            public void success(List<City> cities, Response response) {
                                spnMunicipality.setAdapter(new CitySpinnerBaseAdapter(getApplicationContext(), cities));
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Log.d("An error occurred", "");
                            }
                        });

                    }catch (Exception ex){
                        Log.d("An error ocurred", ex.getMessage());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });


        spnMunicipality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                City selectedCity = (City) parent.getItemAtPosition(position);
                if(position != 0){
                    try {
                        InegiFacilRestClient.get().getTowns(String.valueOf(selectedCity.getClaveEntidad()), String.valueOf(selectedCity.getClaveMunicipio()), new Callback<List<Town>>() {
                            @Override
                            public void success(List<Town> towns, Response response) {
                                spnLocality.setAdapter(new TownSpinnerBaseAdapter(getApplicationContext(), towns));
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Log.d("An error occurred", "");
                            }
                        });

                    }catch (Exception ex){
                        Log.d("An error ocurred", ex.getMessage());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
