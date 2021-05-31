package com.example.finalapp1;

import java.io.Serializable;

public class Trouser extends Good implements Serializable {
    private int highTemperature;
    private int lowTemperature;
    private String weather;
    private String color;
    private String fabric;
    
    public Trouser(String initialCode, String initialTime, String initialName,
    		double initialValue, String initialSituation, int initialHighTemperature, 
    		int initialLowTemperature, String initialWeather, String initialColor, 
    		 String initialFabric){
    	
    	super(initialCode,initialTime,initialName,initialValue,initialSituation);
    	
    	this.highTemperature = initialHighTemperature;
    	this.lowTemperature = initialLowTemperature;
    	this.weather = initialWeather;
    	this.color = initialColor;
    	this.fabric = initialFabric;
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


    public String getFabric(){
        return fabric;
    }

    public void setFabric(String newFabric){
    	fabric = newFabric;
    }

    public String toString() {
    	
    	String trouserString = super.getCode() + "_" + super.getName() + "_"
    						+ "$" + super.getValue() + "_" + this.getColor()
    						+ "_" + this.getFabric() + "_" + super.getTime();
    	return trouserString;

    }
    public String todisplayeasyString(){
        String str="名称："+super.getName()
                +"\n价格："+super.getValue()
                +"\n颜色："+this.getColor();
        return str;
    }
    

}
