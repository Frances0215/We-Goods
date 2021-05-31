package project;

public class Other extends Good {
    private String attribute;

    public Other(String initialCode,String initialTime, String initialName,
    		double initialValue, String initialSituation,String initialAttribute){
    	
    	super(initialCode,initialTime,initialName,initialValue,initialSituation);
    	this.attribute = initialSituation;
    }
    
    public String getAttribute(){
        return attribute;
    }

    public void setAttribute(String newAttribute){
    	attribute = newAttribute;
    }
    
    public String toString() {
 	   
 	   String otherString = super.getCode() + "_" + super.getName() + "_" 
 				+ "$" + super.getValue() + "_" + this.getAttribute()
 				 + "_" + super.getTime();
 	   return otherString;
    }
}
