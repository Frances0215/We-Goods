package project;

public class Bag extends Good {
    private String size;
    private String color;

    public Bag(String initialCode, String initialTime, String initialName,
    		double initialValue, String initialSituation,String initialSize,String initialColor){
    	
    	super(initialCode,initialTime,initialName,initialValue,initialSituation);
    	this.size = initialSize;
    	this.color = initialColor;
    }
    
    public String getSize(){
        return size;
    }

    public void setSize(String newSize){
    	size = newSize;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String newColor){
    	color = newColor;
    }

    public String toString() {
    	String trouserString = super.getCode() + "_" + super.getName() + "_" 
				+ "$" + super.getValue() + "_" + this.getColor()
				+ "_" + super.getTime();
    	return trouserString;
    }
    

}
