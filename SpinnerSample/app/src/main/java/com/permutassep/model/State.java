package com.permutassep.model;

public class State {
    int id;
    String mStateName;

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
