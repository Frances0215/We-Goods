package com.example.finalapp1;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;


public class Box {
    private int id;
    private String name;
    private int capacity;
    private Vector<Good> goods;
    private static PrintWriter stdOut = new PrintWriter(System.out,true);
    
    public Box(int initialId, String initialName, int initialCapacity){
    	this.id = initialId;
    	this.name = initialName;
    	this.capacity = initialCapacity;
    	this.goods = new Vector<Good>();
    }
    
    public void addGood(Good good)
    {
    	this.goods.add(good);
    }
    
    public Iterator getGoodsIterator(){
    	return this.goods.iterator();
    }
    
    public Good getGood(String code) {
    	for(Good good:this.goods) {
    		if(good.getCode().equals(code)) {
    			return good;
    		}
    	}
    	return null;
    }
    
    public int getNumberOfGoods() {
    	return this.goods.size();
    }
    
    public int getId(){
        return id;
    }

    public String getName(){
    	return name;
    }

    public int getCapacity(){
        return capacity;
    }

    public String toString(){
    	String boxString = this.getId() + "_" + this.getName() + "_" + this.getCapacity();
        return boxString;
    }

    public void setID(int newID){
    	id = newID;
    }

    

    public void setName(String newName){
    	name = newName;
    }

    public void setCapacity(int newCapacity){
    	capacity = newCapacity;
    }

    public void addCapacity() {
    	capacity++;
    }
    
    
    public void displayGoods(){
    	
    	int number = this.getNumberOfGoods();
    	
    	if(number == 0)
    		stdOut.println(this.getName() + "Ϊ�գ��������Ʒ�ɣ�");
    	else {
    		for(Iterator i = this.getGoodsIterator();i.hasNext(); ) {
    			Good good = (Good)i.next();
    			stdOut.println(good.toString());
    		}
    	}
    	
    }

}
