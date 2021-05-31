package project;

public class Food extends Good {

    private int expirationDate;
    private String productionDate;

    public Food(String initialCode, String initialTime, String initialName,
    		double initialValue, String initialSituation,int initialExpirationDate,
    		String initialProductionDate){
    	
    	super(initialCode,initialTime,initialName,initialValue,initialSituation);
    	
    	this.expirationDate =  initialExpirationDate;
    	this.productionDate = initialProductionDate;
    }

    public int getExpirationDate(){
        return expirationDate;
    }

    public void setExpirationDate(int newExpirationDate){
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
