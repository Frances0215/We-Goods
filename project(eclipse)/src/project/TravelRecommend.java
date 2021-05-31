package project;

import java.io.*;
import java.util.*;

public class TravelRecommend {
    private Bag bag;
    private Vector<Other> others;
    private String situation;
    private BoxList boxList;
    private int noGood;
    private boolean noBag;
    private boolean noOther;
    
    private static BufferedReader  stdIn =
    		new  BufferedReader(new  InputStreamReader(System.in));
    private static PrintWriter  stdOut =
    		new  PrintWriter(System.out, true);
    private static PrintWriter  stdErr =
    		new  PrintWriter(System.err, true);
    
    public TravelRecommend(BoxList newBoxList) throws IOException{
    	situation = this.getSituation();
    	boxList = newBoxList;
    	noGood = 0;
    	noBag = false;
    	noOther = false;
    }

    public String getSituation() throws IOException{
    	stdOut.println("请输入今日的出行情况：");
    	stdOut.flush();
    	String situation = stdIn.readLine();
        return situation;
    }
    
    public Bag getBagRecommend(String todaySituation){
    	Vector<Bag> bags = new Vector<Bag>();
    	Box bagBox = boxList.getBox(5);
    	
    	/*
    	 * 找出所有符合今日情况的箱包，组成一个集合
    	 */
    	for(Iterator i = bagBox.getGoodsIterator();i.hasNext();)
    	{
    		Bag bagTemp = (Bag)i.next();
    		
    			String situation = bagTemp.getStituation();
    			StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"，");
    			
    			for(int n = 0;n <= tokenizerOfSituation.countTokens();n++)
    			{
    				if(tokenizerOfSituation.nextToken().equals(todaySituation)) 
    				{
    					bags.add(bagTemp);
    				}
    			}
    	}
    	
    	int number = bags.size();
    	if(number == 0) {
    		noBag = true;
    		noGood++;
    		stdErr.println("抱歉，您没有符合今日天气及出行要求的箱包");
    		stdErr.flush();
    	}
    	else if(number > 1){
    		Random ra = new Random();
    		int i = ra.nextInt(number-1);
    		return bags.get(i);
    	}else
    		return bags.get(0);
    	
        return null;
    }

    public Vector<Other> getOtherRecommend(String todaySituation){
    	Vector<Other> others = new Vector<Other>();
    	Box otherBox = boxList.getBox(6);
    	
    	/*
    	 * 找出所有符合今日情况的箱包，组成一个集合
    	 */
    	for(Iterator i = otherBox.getGoodsIterator();i.hasNext();)
    	{
    		Other otherTemp = (Other)i.next();
    		
    			String situation = otherTemp.getStituation();
    			StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"，");
    			
    			for(int n = 0;n <= tokenizerOfSituation.countTokens();n++)
    			{
    				if(tokenizerOfSituation.nextToken().equals(todaySituation)) 
    				{
    					others.add(otherTemp);
    				}
    			}
    	}
    	
    	int number = others.size();
    	if(number == 0) {
    		noOther = true;
    		noGood++;
    		stdErr.println("抱歉，您没有符合今日天气及出行要求的其他物品了");
    		stdErr.flush();
    	}
    	else
    		return others;
    	
        return null;
    }
    
    public void displayTravelRecommend(){
    	bag = getBagRecommend(situation);
    	others = getOtherRecommend(situation);
    	
    	
    	stdOut.println();
    	if(noGood != 2) {
    		stdOut.println("今日给您的出行推荐是：");
    	
    		if(!noBag)
    			stdOut.println("箱包：" + bag.toString());
    		stdOut.flush();
    		if(!noOther)
    		{
    			stdOut.println("其他物品：");
    			for(Iterator i = others.iterator();i.hasNext();) {
    				Other tempOther = (Other)i.next();
    				stdOut.println(tempOther.toString());
    				stdOut.flush();
    			}
    			stdOut.flush();
    		}
    	}
    }

}
