package project;

import java.io.*;
import java.util.*;
import java.text.*;

public class ClothRecommend {
    private String weather;
    private String situation;
    private int highTemperature;
    private int lowTemperature;
    private Jacket jacket;
    private Trouser trouser;
    private Shoe shoe;
    private BoxList boxList;
    private int noGood;
    private boolean noJacket;
    private boolean noTrouser;
    private boolean noShoe;

    private static BufferedReader  stdIn =
    		new  BufferedReader(new  InputStreamReader(System.in));
    private static PrintWriter  stdOut =
    		new  PrintWriter(System.out, true);
    private static PrintWriter  stdErr =
    		new  PrintWriter(System.err, true);
    	
    public ClothRecommend(BoxList newBoxList) throws IOException{
    	highTemperature = getHighTempareture();
    	lowTemperature = getLowTempareture();
    	weather = getWeather();
    	situation = getSituation();
    	boxList = newBoxList;
    	noGood = 0;
    	noJacket = false;
    	noTrouser = false;
    	noShoe = false;
    }

    public int getHighTempareture() throws IOException{
    	stdOut.println("请输入今日的最高温度：");
    	stdOut.flush();
    	int highTemperature = Integer.parseInt(stdIn.readLine());
        return highTemperature;
    }

    public int getLowTempareture() throws IOException{
    	stdOut.println("请输入今日的最低温度：");
    	stdOut.flush();
    	int lowTemperature = Integer.parseInt(stdIn.readLine());
        return lowTemperature;
    }

    public String getSituation() throws IOException{
    	stdOut.println("请输入今日的出行情况：");
    	stdOut.flush();
    	String situation = stdIn.readLine();
        return situation;
    }

    public String getWeather() throws IOException{
    	stdOut.println("请输入今日的天气：");
    	stdOut.flush();
    	String weather = stdIn.readLine();
        return weather;
    }
    
    public Jacket getJacketRecommend(String todayWeather, String todaySituation,int todayHighTemperature,int todayLowTemperature){
    	
    	Vector<Jacket> jackets = new Vector<Jacket>();
    	Box jacketBox = boxList.getBox(2);
    	
    	/*
    	 * 找出所有符合今日情况的裤子，组成一个集合
    	 */
    	for(Iterator i = jacketBox.getGoodsIterator();i.hasNext();)
    	{
    		Jacket jacketTemp = (Jacket)i.next();
    		if(jacketTemp.getHighTemperature() <= todayHighTemperature && 
    		   jacketTemp.getLowTemperature() >= todayLowTemperature)
    		{
    			String situation = jacketTemp.getStituation();
    			StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"，");
    			
    			for(int n = 1;n <= tokenizerOfSituation.countTokens();n++)
    			{
    				if(tokenizerOfSituation.nextToken().equals(todaySituation) ) 
    				{
    					String weather = jacketTemp.getWeather();
    	    			StringTokenizer tokenizerOfWeather = new StringTokenizer(weather,"，");
    	    			
    	    			for(int m = 1;m <= tokenizerOfWeather.countTokens();m++)
    	    			{
    	    				if(tokenizerOfWeather.nextToken().equals(todayWeather))
    	    				{
    	    					jackets.add(jacketTemp);
    	    				}
    	    			}
    				}
    			}
    		}
    	}
    	
    	int number = jackets.size();
    	if(number == 0) {
    		noJacket = true;
    		noGood++;
    		stdErr.println("抱歉，您没有符合今日天气及出行要求的裤子");
    		stdErr.flush();
    	}
    	else if(number > 1){
    		Random ra = new Random();
    		int i = ra.nextInt(number-1);
    		return jackets.get(i);
    	}else
    		return jackets.get(0);
    	
        return null;
    }

    public Trouser getTrouserRecommend(String todayWeather, String todaySituation,int todayHighTemperature,int todayLowTemperature){
    	Vector<Trouser> trousers = new Vector<Trouser>();
    	Box trouserBox = boxList.getBox(1);
    	
    	/*
    	 * 找出所有符合今日情况的衣服，组成一个集合
    	 */
    	for(Iterator i = trouserBox.getGoodsIterator();i.hasNext();)
    	{
    		Trouser trouserTemp = (Trouser)i.next();
    		if(trouserTemp.getHighTemperature() <= todayHighTemperature && 
    				trouserTemp.getLowTemperature() >= todayLowTemperature)
    		{
    			String situation = trouserTemp.getStituation();
    			StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"，");
    			
    			for(int n = 0;n <= tokenizerOfSituation.countTokens();n++)
    			{
    				if(tokenizerOfSituation.nextToken().equals(todaySituation)) 
    				{
    					String weather = trouserTemp.getWeather();
    	    			StringTokenizer tokenizerOfWeather = new StringTokenizer(weather,"，");
    	    			
    	    			for(int m = 0;m <= tokenizerOfWeather.countTokens();m++)
    	    			{
    	    				if(tokenizerOfWeather.nextToken().equals(todayWeather))
    	    				{
    	    					trousers.add(trouserTemp);
    	    				}
    	    			}
    				}
    			}
    		}
    	}
    	
    	int number = trousers.size();
    	if(number == 0) {
    		noTrouser = true;
    		noGood++;
    		stdErr.println("抱歉，您没有符合今日天气及出行要求的衣服");
    		stdErr.flush();
    	}
    	else if(number > 1){
    		Random ra = new Random();
    		int i = ra.nextInt(number-1);
    		return trousers.get(i);
    	}else
    		return trousers.get(0);
    	
        return null;
    	
    }

    public Shoe getShoeRecommend(String todayWeather, String todaySituation,int todayHighTemperature,int todayLowTemperature){
    	Vector<Shoe> shoes = new Vector<Shoe>();
    	Box shoeBox = boxList.getBox(3);
    	
    	/*
    	 * 找出所有符合今日情况的鞋子，组成一个集合
    	 */
    	for(Iterator i = shoeBox.getGoodsIterator();i.hasNext();)
    	{
    		Shoe shoeTemp = (Shoe)i.next();
    		if(shoeTemp.getHighTemperature() <= todayHighTemperature && 
    				shoeTemp.getLowTemperature() >= todayLowTemperature)
    		{
    			String situation = shoeTemp.getStituation();
    			StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"，");
    			
    			for(int n = 0;n <= tokenizerOfSituation.countTokens();n++)
    			{
    				if(tokenizerOfSituation.nextToken().equals(todaySituation)) 
    				{
    					String weather = shoeTemp.getWeather();
    	    			StringTokenizer tokenizerOfWeather = new StringTokenizer(weather,"，");
    	    			
    	    			for(int m = 0;m <= tokenizerOfWeather.countTokens();m++)
    	    			{
    	    				if(tokenizerOfWeather.nextToken().equals(todayWeather))
    	    				{
    	    					shoes.add(shoeTemp);
    	    				}
    	    			}
    				}
    			}
    		}
    	}
    	
    	int number = shoes.size();
    	if(number == 0) {
    		noShoe = true;
    		noGood++;
    		stdErr.println("抱歉，您没有符合今日天气及出行要求的鞋子");
    		stdErr.flush();
    	}
    	else if(number > 1){
    		Random ra = new Random();
    		int i = ra.nextInt(number-1);
    		return shoes.get(i);
    	}else
    		return shoes.get(0);
    	
        return null;
    	
    }

    

    public void displayRecommend(){
    	
    	jacket = getJacketRecommend(weather,situation,highTemperature,lowTemperature);
    	trouser = getTrouserRecommend(weather,situation,highTemperature,lowTemperature);
    	shoe = getShoeRecommend(weather,situation,highTemperature,lowTemperature);
    	
    	stdOut.println();
    	if(noGood != 3) {
    		stdOut.println("今日给您的穿搭推荐是：");
    	
    	if(!noTrouser)
    		stdOut.println("衣服：" + trouser.toString());
    	stdOut.flush();
    	if(!noJacket)
    		stdOut.println( "裤子：" + jacket.toString());
    	stdOut.flush();
    	if(!noShoe)
    		stdOut.println("鞋子：" + shoe.toString());
    	stdOut.flush();
    	}
    	
    }

}
