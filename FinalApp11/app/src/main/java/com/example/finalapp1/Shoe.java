package com.example.finalapp1;

import java.io.Serializable;

public class Shoe extends Good implements Serializable {
    private double size;
    private String color;
    private String weather;
    private int highTemperature;
    private int lowTemperature;

    public Shoe(String initialCode, String initialTime, String initialName,
    		double initialValue, String initialSituation, int initialHighTemperature, 
    		int initialLowTemperature, String initialWeather, String initialColor,
    		double initialSize){
    	
    	super(initialCode,initialTime,initialName,initialValue,initialSituation);
    	this.size = initialSize;
    	this.color = initialColor;
    	this.highTemperature = initialHighTemperature;
    	this.lowTemperature = initialLowTemperature;
    	this.weather = initialWeather;
    }
    
    public int getHigtTemperature(){
        return highTemperature;
    }

    public void setHighTemperature(int newHighTemperature){
    	highTemperature = newHighTemperature;
    }

    public int getLowTemperature(){
        return lowTemperature;
    }

    public void setLowTemperature(int newLowTemperature){
    	lowTemperature = newLowTemperature;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String newColor){
    	color = newColor;
    }

    public String getWeather(){
        return weather;
    }

    public void setWeather(String newWeather){
    	weather = newWeather;
    }

    public double getSize(){
        return size;
    }

    public void setSize(float newSize){
    	size = newSize;
    }

    public String toString() {
 	   
 	   String shoeString = super.getCode() + "_" + super.getName() + "_" 
 				+ "$" + super.getValue() + "_" + this.getColor()
 				+ "_" + this.getSize() + "_" + super.getTime();
 	   return shoeString;
    }
    

}
