package com.example.android1gu;

public final class ActivitySaver {

    private static ActivitySaver instance;
    private  String city;
    private int counter = 0 ;

    private ActivitySaver() {

    }

    public static ActivitySaver getInstance(){
        if(instance==null) instance = new ActivitySaver();
        return instance;
    }
    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public int getCounter(){
        return counter;
    }

    public void incrementCounter() {
        this.counter++;
    }
}
