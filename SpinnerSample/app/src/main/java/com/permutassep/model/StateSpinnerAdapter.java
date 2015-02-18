package com.permutassep.model;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StateSpinnerAdapter implements SpinnerAdapter{

    private Context context;
    private ArrayList<State> states = new ArrayList<State>();

    public StateSpinnerAdapter(Context context, ArrayList<State> states){
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
        return states.get(position).getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public int getItemViewType(int position) {
        return Adapter.IGNORE_ITEM_VIEW_TYPE;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
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
