package com.permutassep.model;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class KeyValueSpinner implements SpinnerAdapter {
    Context context;
    ArrayList<State> states = new ArrayList<State>();

    public KeyValueSpinner(Context context, ArrayList<State> states){
        this.context =context;
        this.states = states;
    }

    @Override
    public int getCount() {
        return states.size();
    }

    @Override
    public State getItem(int position) {
        return states.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    //Note:-Create this two method getIDFromIndex and getIndexByID
    public int getIdFromIndex(int index) {
        return states.get(index).getId();
    }

    public int getIndexById(int id) {

        for (int i = 0;  states.get(id).getId() == id;i++){
            return i;
        }
        return -1;
    }

    @Override
    public int getViewTypeCount() {
        return android.R.layout.simple_spinner_dropdown_item;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return states.isEmpty();
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) { }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) { }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TextView textview = (TextView) inflater.inflate(android.R.layout.simple_spinner_dropdown_item, null);
        textview.setText(states.get(position).getStateName());
        return textview;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TextView textview = (TextView) inflater.inflate(android.R.layout.simple_spinner_dropdown_item, null);
        textview.setText(states.get(position).getStateName());
        return textview;
    }
}