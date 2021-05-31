package com.example.finalapp1;


public class Good2 {
    private int code;
    private String time;
    private String name;
    private double value;
    private String situation;

    public Good2(int initialCode, String initialTime, String initialName,
                 double initialValue, String initialSituation){

        this.code = initialCode;
        this.time = initialTime;
        this.name = initialName;
        this.value = initialValue;
        this.situation = initialSituation;
    }
    public int getCode() {
        return this.code;
    }

    public void setCode(int newCode) {
        code = newCode;
    }


    public String getTime(){
        return time;
    }

    public void setTime(String newTime){
        time = newTime;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public double getValue(){
        return value;
    }

    public void setValue(float newValue){
        value = newValue;
    }

    public String getStituation(){
        return situation;
    }

    public void setSituation(String newSituation){
        situation = newSituation;
    }

    public String toString() {
        String toString = name + "_" + code + "_" + "$" + value + "_"
                + time + "_" + situation;
        return toString;
    }

}