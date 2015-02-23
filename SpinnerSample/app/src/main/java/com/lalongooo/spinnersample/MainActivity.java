package com.lalongooo.spinnersample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.permutassep.model.State;
import com.permutassep.model.StateSpinnerAdapter;
import com.permutassep.model.StateSpinnerBaseAdapter;

import java.util.ArrayList;


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

        ArrayList<State> alStates = new ArrayList<State>();
        String [] states = getResources().getStringArray(R.array.states);

        for (int i = 0; i < states.length; i++){
            alStates.add(new State(i, states[i]));
        }

        spnState.setAdapter(new StateSpinnerBaseAdapter(getApplicationContext(), alStates));
        spnState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Log.i("INFO: ", "State name: " + ((State)parent.getItemAtPosition(position)).getStateName() + ", State id: " + ((State)parent.getItemAtPosition(position)).getId());


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
