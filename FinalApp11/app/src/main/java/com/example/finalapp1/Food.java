package com.example.finalapp1;

import java.io.Serializable;

public class Food extends Good implements Serializable {

    private String expirationDate;
    private String productionDate;

    public Food(String initialCode, String initialTime, String initialName,
                double initialValue, String initialSituation, String initialExpirationDate,
                String initialProductionDate){
    	
    	super(initialCode,initialTime,initialName,initialValue,initialSituation);
    	
    	this.expirationDate =  initialExpirationDate;
    	this.productionDate = initialProductionDate;
    }

    public String getExpirationDate(){
        return expirationDate;
    }

    public void setExpirationDate(String newExpirationDate){
    	expirationDate = newExpirationDate;
    }

    public String getProductionDate(){
        return productionDate;
    }

    public void setProductionDate(String newProductionDate){
    	productionDate = newProductionDate;
    }

    public String toString() {
 	   
 	   String foodString = super.getCode() + "_" + super.getName() + "_" 
 				+ "$" + super.getValue() + "_" + this.getProductionDate()
 				+ "_" + this.getExpirationDate() ;
 	   return foodString;
    }
}
