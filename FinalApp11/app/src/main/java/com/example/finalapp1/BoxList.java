package com.example.finalapp1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

public class BoxList {
    private Vector<Box> boxes;

    public BoxList() {
        this.boxes = new Vector<Box>();
        this.addBoxes();
    }

    public void addBoxes() {
        boxes.add(new Box(1,"衣柜",0));
        boxes.add(new Box(2,"裤子",0));
        boxes.add(new Box(3,"鞋架",0));
        boxes.add(new Box(4,"食品",0));
        boxes.add(new Box(5,"箱包",0));
        boxes.add(new Box(6,"杂物柜",0));
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

    public void addTrouserFile(Trouser trouser,String filename) throws IOException{

        PrintWriter fileWriter = new PrintWriter(new FileWriter(filename,true));
        fileWriter.println(trouser.getCode()+ "_" + trouser.getTime()+ "_"+
                trouser.getName()+ "_" + trouser.getValue()+"_"+
                trouser.getStituation()+ "_" + trouser.getHigtTemperature()+"_"+
                trouser.getLowTemperature()+ "_"+ trouser.getWeather()+"_"+
                trouser.getColor()+"_" +trouser.getFabric());
        fileWriter.close();
    }

    public void addJacketFile(Jacket jacket,String filename) throws IOException{

        PrintWriter fileWriter = new PrintWriter(new FileWriter(filename,true));
        fileWriter.println(jacket.getCode()+ "_" + jacket.getTime()+ "_"+
                jacket.getName()+ "_" + jacket.getValue()+"_"+
                jacket.getStituation()+ "_" + jacket.getHigtTemperature()+"_"+
                jacket.getLowTemperature()+ "_"+ jacket.getWeather()+"_"+
                jacket.getColor()+"_" +jacket.getFabric());
        fileWriter.close();
    }

    public void addShoeFile(Shoe shoe,String filename) throws IOException{

        PrintWriter fileWriter = new PrintWriter(new FileWriter(filename,true));
        fileWriter.println(shoe.getCode()+ "_" + shoe.getTime()+ "_"+
                shoe.getName()+ "_" + shoe.getValue()+"_"+
                shoe.getStituation()+ "_" + shoe.getHigtTemperature()+"_"+
                shoe.getLowTemperature()+ "_"+ shoe.getWeather()+"_"+
                shoe.getColor()+"_" +shoe.getSize());
        fileWriter.close();
    }

    public void addBagFile(Bag bag, String filename) throws IOException{

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
