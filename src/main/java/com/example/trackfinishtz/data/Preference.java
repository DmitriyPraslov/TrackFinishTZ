package com.example.trackfinishtz.data;

public class Preference {
    private int startWorkTime;
    private boolean workFromHomePreference;

    private Preference(int startWorkTime, boolean workFromHome) {
        this.startWorkTime = startWorkTime;
        this.workFromHomePreference = workFromHome;
    }

    public static Preference createPreference(int startWorkTime){
        return new Preference(startWorkTime, false);
    }

    public static Preference createHomePreference(){
        return new Preference(9, true);
    }

    public int getStartWorkTime() {
        return startWorkTime;
    }

    public boolean isWorkFromHome() {
        return workFromHomePreference;
    }
}
