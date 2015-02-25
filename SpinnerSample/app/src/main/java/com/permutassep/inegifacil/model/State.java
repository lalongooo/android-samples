package com.permutassep.inegifacil.model;

import com.google.gson.annotations.Expose;

public class State {

    @Expose
    private int id;


    private String mStateName;

    public State(int id, String stateName) {
        this.id = id;
        this.mStateName = stateName;
    }

    public String getStateName() {
        return mStateName;
    }
    public void setStateName(String stateName) {
        this.mStateName = stateName;
    }
    public int getId() {
        return id;
    }
    public void setId(int iD) {
        id = iD;
    }
}
