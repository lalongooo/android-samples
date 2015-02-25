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
import com.permutassep.inegifacil.rest.InegiFacilRestClient;
import com.permutassep.model.CitySpinnerBaseAdapter;
import com.permutassep.model.StateSpinnerBaseAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    private Spinner spnState;
    private Spinner spnMunicipality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnState = (Spinner) findViewById(R.id.spnState);
        spnMunicipality = (Spinner) findViewById(R.id.spnMunicipality);
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

                    try {
                        Log.i("INFO: ", "State name: " + selectedState.getStateName() + ", State id: " + selectedState.getId());
                        InegiFacilRestClient.get().getCities(String.valueOf(selectedState.getId()), new Callback<List<City>>() {
                            @Override
                            public void success(List<City> cities, Response response) {
                                Log.d("Number of cities:", (String.valueOf(cities.size())));
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
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
