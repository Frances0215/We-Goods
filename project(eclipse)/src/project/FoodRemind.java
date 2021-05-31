package project;

import java.io.*;
import java.util.*;

public class FoodRemind {
    private Vector<Food> foods;
    private String time;
    private BoxList boxList;
    private static BufferedReader  stdIn =
    		new  BufferedReader(new  InputStreamReader(System.in));
    private static PrintWriter  stdOut =
    		new  PrintWriter(System.out, true);
    private static PrintWriter  stdErr =
    		new  PrintWriter(System.err, true);

    public FoodRemind(BoxList newBoxList)throws IOException{
    	boxList = newBoxList;
    	time = this.getTime();
    }

    public String getTime() throws IOException{
    	stdOut.println("请输入今日的日期：(格式：2020.5.2)");
    	stdOut.flush();
    	String time = stdIn.readLine();
        return time;
    }
    
    public void getFood(String todayTime) throws IOException{
    	Box foodBox = boxList.getBox(4);
    	StringTokenizer tokenizerOfTime = new StringTokenizer(todayTime,".");
    	if(tokenizerOfTime.countTokens() != 3) {
    		stdErr.println();
    		stdErr.println("您的日期输入有误，请重新输入:");
    		stdErr.flush();
    		todayTime = this.getTime();
    	}
    	else {
    		int year = Integer.parseInt(tokenizerOfTime.nextToken());
    		int month = Integer.parseInt(tokenizerOfTime.nextToken());
    		int day = Integer.parseInt(tokenizerOfTime.nextToken());
    		
    		for(Iterator i = foodBox.getGoodsIterator();i.hasNext();) {
    			Food tempFood = (Food)i.next();
    			String productionDate = tempFood.getProductionDate();
    			int expirationDate = tempFood.getExpirationDate();
    			
    			StringTokenizer tokenizerOfProduct = new StringTokenizer(productionDate,".");
    			int yearOfProduct = Integer.parseInt(tokenizerOfProduct.nextToken());
        		int monthOfProduct = Integer.parseInt(tokenizerOfProduct.nextToken());
        		int dayOfProduct = Integer.parseInt(tokenizerOfProduct.nextToken());
        		
        		int dayOver = (year - yearOfProduct)*365 + (month - monthOfProduct)*30 +(day - dayOfProduct);
        		
        		int dayOff = expirationDate - dayOver;
        		if(dayOff < 0)
        		{
        			stdOut.println(tempFood.getCode() + "号食品" + tempFood.getName()
        							+ "已过期，赶快处理掉吧");
        		}else if(dayOff == 0){
        			stdOut.println(tempFood.getCode() + "号食品" + tempFood.getName()
					+ "将于今天过期啦！！！赶快吃点吧");
        		}else {
        			stdOut.println(tempFood.getCode() + "号食品" + tempFood.getName()
					+ "将于" + dayOff + "天后过期");
        		}
        				
    		}
    	}
       
    }

    public void displayFoodRemind() throws IOException{
    	
    	this.getFood(time);
    }

}
