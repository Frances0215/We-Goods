package project;

import java.util.*;
import java.io.*;

public class BoxList {
    private Vector<Box> boxes;
    
    public BoxList() {
    	this.boxes = new Vector<Box>();
    	this.addBoxes();
    }
    
    public void addBoxes() {
    	boxes.add(new Box(1,"ÒÂ¹ñ",0));
    	boxes.add(new Box(2,"¿ã×Ó",0));
    	boxes.add(new Box(3,"Ð¬¼Ü",0));
    	boxes.add(new Box(4,"Ê³Æ·",0));
    	boxes.add(new Box(5,"Ïä°ü",0));
    	boxes.add(new Box(6,"ÔÓÎï¹ñ",0));
    }
    
    public int getNumberOfBoxes() {
    	return boxes.size();
    }
    
    public Iterator getBoxesIterator() {
    	return this.boxes.iterator();
    }
    
    public Box getBox(int id) {
    	for(Iterator i = this.getBoxesIterator();i.hasNext();)
    	{
    		Box box = (Box)i.next();
    		if(box.getId() == id)
    			return box;
    	}
    	return null;
    }
    
    public Box getBox(String name) {
    	for(Iterator i = this.getBoxesIterator();i.hasNext();)
    	{
    		Box box = (Box)i.next();
    		if(box.getName().equals(name))
    			return box;
    	}
    	return null;
    }
    
    public Vector<String> getNames(){
    	Vector<String> names = new Vector<String>();
    	for(Iterator i =this.getBoxesIterator();i.hasNext();)
    	{
    		Box tempBox = (Box)i.next();
    		names.add(tempBox.getName());
    	}
    	return names;
    }
    
    public void addTrouserFile(Trouser trouser,String filename) throws IOException{
    	
    	PrintWriter fileWriter = new PrintWriter(new FileWriter(filename,true));
    	fileWriter.println(trouser.getCode()+ "_" + trouser.getTime()+ "_"+
    					   trouser.getName()+ "_" + trouser.getValue()+"_"+
    					   trouser.getStituation()+ "_" + trouser.getHighTemperature()+"_"+
    					   trouser.getLowTemperature()+ "_"+ trouser.getWeather()+"_"+
    					   trouser.getColor()+"_" +trouser.getFabric());
    	fileWriter.close();
    }
    
    public void addJacketFile(Jacket jacket,String filename) throws IOException{
    	
    	PrintWriter fileWriter = new PrintWriter(new FileWriter(filename,true));
    	fileWriter.println(jacket.getCode()+ "_" + jacket.getTime()+ "_"+
    			jacket.getName()+ "_" + jacket.getValue()+"_"+
    			jacket.getStituation()+ "_" + jacket.getHighTemperature()+"_"+
    			jacket.getLowTemperature()+ "_"+ jacket.getWeather()+"_"+
    			jacket.getColor()+"_" +jacket.getFabric());
    	fileWriter.close();
    }
    
    public void addShoeFile(Shoe shoe,String filename) throws IOException{
    	
    	PrintWriter fileWriter = new PrintWriter(new FileWriter(filename,true));
    	fileWriter.println(shoe.getCode()+ "_" + shoe.getTime()+ "_"+
    			shoe.getName()+ "_" + shoe.getValue()+"_"+
    			shoe.getStituation()+ "_" + shoe.getHighTemperature()+"_"+
    			shoe.getLowTemperature()+ "_"+ shoe.getWeather()+"_"+
    			shoe.getColor()+"_" +shoe.getSize());
    	fileWriter.close();
    }
    
    public void addBagFile(Bag bag,String filename) throws IOException{
    	
    	PrintWriter fileWriter = new PrintWriter(new FileWriter(filename,true));
    	fileWriter.println(bag.getCode()+ "_" +bag.getTime()+ "_"+
    			bag.getName()+ "_" + bag.getValue()+"_"+
    			bag.getStituation()+ "_" +
    			bag.getSize()+"_" +bag.getColor());
    	fileWriter.close();
    }
    
    public void addFoodFile(Food food,String filename) throws IOException{
    	
    	PrintWriter fileWriter = new PrintWriter(new FileWriter(filename,true));
    	fileWriter.println(food.getCode()+ "_" +food.getTime()+ "_"+
    			food.getName()+ "_" + food.getValue()+"_"+
    			food.getStituation()+ "_" +
    			food.getExpirationDate()+"_" +food.getProductionDate());
    	fileWriter.close();
    }
    
    public void addOtherFile(Other other,String filename) throws IOException{
    	
    	PrintWriter fileWriter = new PrintWriter(new FileWriter(filename,true));
    	fileWriter.println(other.getCode()+ "_" +other.getTime()+ "_"+
    			other.getName()+ "_" + other.getValue()+"_"+
    			other.getStituation()+ "_" +
    			other.getAttribute());
    	fileWriter.close();
    }
}
