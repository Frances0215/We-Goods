package project;

import java.io.*;
import java.util.*;

public class ShoppingRecommend {
    
    private BoxList boxList;
    private String name;
    private String situation;
    private String color;
    private int highTemperature;
    private int lowTemperature;
    private String weather;
    private String fabric;
    private double sizeOfShoe;
    private String sizeOfBag;
    private boolean noSituation;
    private boolean noTemperature;
    private boolean noWeather;
    private boolean noFabric;
    private boolean noSizeOfBag;
    private boolean noSizeOfShoe;
    private boolean noColor;
    
    private static BufferedReader  stdIn =
    		new  BufferedReader(new  InputStreamReader(System.in));
    private static PrintWriter  stdOut =
    		new  PrintWriter(System.out, true);
    private static PrintWriter  stdErr =
    		new  PrintWriter(System.err, true);
    
    public ShoppingRecommend(BoxList newBoxList) {
    	boxList = newBoxList;
    	noSituation = false;
        noTemperature = false;
        noWeather = false;
        noFabric = false;
        noSizeOfBag = false;
        noSizeOfShoe = false;
        noColor = false;
    	
    }
    
    public void getInformationOfWantGood() throws IOException{
    	
    	int input;
    	do {
	    	try {
	    		stdOut.println();
				stdOut.print("请选择想要购买的物品类型：\n"
					+ "[0] 衣服\n"
					+ "[1] 裤子\n"
					+ "[2] 鞋子\n"
					+ "[3] 食物\n"
					+ "[4] 箱包\n"
					+ "[5] 其他\n"
					+ "你的选择> ");
				stdOut.flush();
	
				input = Integer.parseInt(stdIn.readLine());
	
				stdOut.println();
				
				if (0 <= input && 5 >= input)  {
					stdOut.println("下面请输入想要购买的物品信息：");
					
					stdOut.println("名称：");
					stdOut.flush();
					name = stdIn.readLine();
					
					stdOut.println("适用场合：");
					stdOut.flush();
					situation = stdIn.readLine();
					
					break;
				} else {
					stdErr.println("错误输入：  " + input);
				}
	
	    	}catch(NumberFormatException  nfe)  {
				stdErr.println(nfe);
			}
    	}while(true);

    	
    	if(input == 0) {
    		this.getInformationOfTrouser();
    	}else if(input == 1) {
    		this.getInformationOfJacket();
    	}else if(input == 2) {
    		this.getInformationOfShoe();
    	}else if(input == 4) {
    		this.getInformationOfBag();
    	}else if(input == 3) {
    		this.getSimilarFood();
    	}else if(input == 5) {
    		this.getSimilarOther();
    	}
        
    }

   

    public void getInformationOfTrouser() throws IOException{
    	try {
    
	    	stdOut.println("可穿这件衣服的最高温度：");
			stdOut.flush();
			highTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println("可穿这件衣服的最低温度：");
			stdOut.flush();
			lowTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println("可穿这件衣服的天气：");
			stdOut.flush();
			weather = stdIn.readLine();
			
			stdOut.println("这件衣服的材质：");
			stdOut.flush();
			fabric = stdIn.readLine();
			
			this.getSimilarTrouser();
    	}catch(IOException e) {
    		stdErr.println(e);
        }
    }
    
    public void getInformationOfJacket() throws IOException{
    	try {
	    	stdOut.println("可穿这条裤子的最高温度：");
			stdOut.flush();
			highTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println("可穿这条裤子的最低温度：");
			stdOut.flush();
			lowTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println("可穿这条裤子的天气：");
			stdOut.flush();
			weather = stdIn.readLine();
			
			stdOut.println("这条裤子的材质：");
			stdOut.flush();
			fabric = stdIn.readLine();
			
			stdOut.println("这条裤子的颜色：");
			stdOut.flush();
			color = stdIn.readLine();
			
			this.getSimilarJacket();
    	}catch(IOException e) {
    		stdErr.println(e);
        }
    }
    
    public void getInformationOfShoe() throws IOException{
    	try {
	    	stdOut.println("可穿这双鞋子的最高温度：");
			stdOut.flush();
			highTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println("可穿这双鞋子的最低温度：");
			stdOut.flush();
			lowTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println("可穿这双鞋子的天气：");
			stdOut.flush();
			weather = stdIn.readLine();
			
			stdOut.println("这双鞋子的颜色：");
			stdOut.flush();
			color = stdIn.readLine();
			
			stdOut.println("这双鞋子的尺码：");
			stdOut.flush();
			sizeOfShoe = Double.valueOf(stdIn.readLine());
			
			this.getSimilarShoe();
    	}catch(IOException e) {
    		stdErr.println(e);
        }
    }
    
    public void getInformationOfBag() throws IOException{
    	try {
    		
			stdOut.println();
			stdOut.print("该箱包的大小：");
			stdOut.flush();
			sizeOfBag = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("该箱包的颜色：");
			stdOut.flush();
			color = stdIn.readLine();
			
	    	this.getSimilarBag();
    	}catch(IOException e) {
    		stdErr.println(e);
        }
    	
    }
   
    public void getSimilarTrouser() throws IOException{
        Box trouserBox = boxList.getBox(1);
        int numberOfSimilarTrouser = 0;
        
        for(Iterator i = trouserBox.getGoodsIterator();i.hasNext();) {
        	
        	boolean noSituation = false;
        	boolean noWeather = false;
        	boolean noTemperature = false;
        	boolean noColor = false;
        	boolean noFabric = false;
        	
        	
        	Trouser tempTrouser = (Trouser)i.next();
        	if(tempTrouser.getName().equals(name)){
        		String nowSituation = tempTrouser.getStituation();
        		String nowColor = tempTrouser.getColor();
        		int nowHighTemperatrue = tempTrouser.getHighTemperature();
        		int nowLowTemperatrue = tempTrouser.getLowTemperature();
        		
        		String nowWeather = tempTrouser.getWeather();
        		String nowFabric = tempTrouser.getFabric();
        		
        		
        		//判断可适用场合是否相同
        		int numberOfSituation = 0;
        		StringTokenizer tokenizerOfNowSituation = new StringTokenizer(nowSituation,"，");
        		StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"，");
        		if(tokenizerOfNowSituation.countTokens() == tokenizerOfSituation.countTokens()) {
        			while(tokenizerOfSituation.hasMoreTokens()){
        				
        				String tempSituaion = tokenizerOfSituation.nextToken();
        				while(tokenizerOfNowSituation.hasMoreTokens()) {
        					String tempNowSituaion = tokenizerOfNowSituation.nextToken();
        					if(tempSituaion.equals(tempNowSituaion)) {
        						numberOfSituation ++;
        					}
        						
        				}
        			}
        			if(numberOfSituation == tokenizerOfSituation.countTokens())
        				noSituation = true;
        		}
        		
        		//判断可适用天气是否相同
            	int numberOfWeather = 0;
            	StringTokenizer tokenizerOfNowWeather = new StringTokenizer(nowWeather,"，");
        		StringTokenizer tokenizerOfWeather = new StringTokenizer(weather,"，");
        		if(tokenizerOfNowWeather.countTokens() == tokenizerOfWeather.countTokens()) {
        			while(tokenizerOfWeather.hasMoreTokens()){
        				
        				String tempWeather = tokenizerOfWeather.nextToken();
        				while(tokenizerOfNowWeather.hasMoreTokens()) {
        					String tempNowWeather = tokenizerOfNowWeather.nextToken();
        					if(tempWeather.equals(tempNowWeather)) {
        						numberOfWeather ++;
        					}
        						
        				}
        			}
        			if(numberOfWeather == tokenizerOfWeather.countTokens())
        				noWeather = true;
        		}
        		
        		//判断使用温度是否相同
        		if(nowHighTemperatrue <= highTemperature || nowLowTemperatrue >= lowTemperature) {
        			noTemperature = true;
        		}
        		
        		//判断颜色是否相同
        		if(!nowColor.equals(color)) {
        			noColor = true;
        		}
        		
        		//判断材质是否相同
        		if(!nowFabric.equals(fabric)) {
        			noFabric = true;
        		}
        		
        		/*
        		 * 给出判断是否有相似的衣服
        		 */
        		
        		stdOut.println();
        		stdOut.println(tempTrouser.toString());
        		stdOut.println("与这件衣服有一样的：");
        		stdOut.flush();
        		if(!noSituation)
        			stdOut.println("适用场合");
        		if(!noWeather)
        			stdOut.println("适用天气");
        		if(!noTemperature)
        			stdOut.println("适用温度");
        		if(!noColor)
        			stdOut.println("颜色");
        		if(!noFabric)
        			stdOut.println("材质");
        		
        		stdOut.flush();
        		numberOfSimilarTrouser ++;
        	}
        	
        }
        if(numberOfSimilarTrouser == 0) {
        	stdOut.println("没有相似的衣服，可以放心购买");
        }else {
        	stdOut.println("搜索到有以上"+ numberOfSimilarTrouser + "件类似的衣服：");
        	stdOut.println("所以再考虑一下吧");
        }
        
    }
    
    public void getSimilarJacket() throws IOException{
        Box jacketBox = boxList.getBox(2);
        int numberOfSimilarJacket = 0;
        
        for(Iterator i = jacketBox.getGoodsIterator();i.hasNext();) {
        	
        	boolean noSituation = false;
        	boolean noWeather = false;
        	boolean noTemperature = false;
        	boolean noColor = false;
        	boolean noFabric = false;
        	
        	
        	Jacket tempJacket = (Jacket)i.next();
        	if(tempJacket.getName().equals(name)){
        		String nowSituation = tempJacket.getStituation();
        		String nowColor = tempJacket.getColor();
        		int nowHighTemperatrue = tempJacket.getHighTemperature();
        		int nowLowTemperatrue = tempJacket.getLowTemperature();
        		
        		String nowWeather = tempJacket.getWeather();
        		String nowFabric = tempJacket.getFabric();
        		
        		
        		//判断可适用场合是否相同
        		int numberOfSituation = 0;
        		StringTokenizer tokenizerOfNowSituation = new StringTokenizer(nowSituation,"，");
        		StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"，");
        		if(tokenizerOfNowSituation.countTokens() == tokenizerOfSituation.countTokens()) {
        			while(tokenizerOfSituation.hasMoreTokens()){
        				
        				String tempSituaion = tokenizerOfSituation.nextToken();
        				while(tokenizerOfNowSituation.hasMoreTokens()) {
        					String tempNowSituaion = tokenizerOfNowSituation.nextToken();
        					if(tempSituaion.equals(tempNowSituaion)) {
        						numberOfSituation ++;
        					}
        						
        				}
        			}
        			if(numberOfSituation == tokenizerOfSituation.countTokens())
        				noSituation = true;
        		}
        		
        		//判断可适用天气是否相同
            	int numberOfWeather = 0;
            	StringTokenizer tokenizerOfNowWeather = new StringTokenizer(nowWeather,"，");
        		StringTokenizer tokenizerOfWeather = new StringTokenizer(weather,"，");
        		if(tokenizerOfNowWeather.countTokens() == tokenizerOfWeather.countTokens()) {
        			while(tokenizerOfWeather.hasMoreTokens()){
        				
        				String tempWeather = tokenizerOfWeather.nextToken();
        				while(tokenizerOfNowWeather.hasMoreTokens()) {
        					String tempNowWeather = tokenizerOfNowWeather.nextToken();
        					if(tempWeather.equals(tempNowWeather)) {
        						numberOfWeather ++;
        					}
        						
        				}
        			}
        			if(numberOfWeather == tokenizerOfWeather.countTokens())
        				noWeather = true;
        		}
        		
        		//判断使用温度是否相同
        		if(nowHighTemperatrue <= highTemperature || nowLowTemperatrue >= lowTemperature) {
        			noTemperature = true;
        		}
        		
        		//判断颜色是否相同
        		if(!nowColor.equals(color)) {
        			noColor = true;
        		}
        		
        		//判断材质是否相同
        		if(!nowFabric.equals(fabric)) {
        			noFabric = true;
        		}
        		
        		/*
        		 * 给出判断是否有相似的裤子
        		 */
        		
        		stdOut.println();
        		stdOut.println(tempJacket.toString());
        		stdOut.println("与这件裤子有一样的：");
        		stdOut.flush();
        		if(!noSituation)
        			stdOut.println("适用场合");
        		if(!noWeather)
        			stdOut.println("适用天气");
        		if(!noTemperature)
        			stdOut.println("适用温度");
        		if(!noColor)
        			stdOut.println("颜色");
        		if(!noFabric)
        			stdOut.println("材质");
        		
        		stdOut.flush();
        		numberOfSimilarJacket ++;
        	}	
        }
        
        if(numberOfSimilarJacket == 0) {
        	stdOut.println("没有相似的裤子，可以放心购买");
        }else {
        	stdOut.println("搜索到有以上"+ numberOfSimilarJacket + "条类似的裤子：");
        	stdOut.println("所以再考虑一下吧");
        }
    }
    
    public void getSimilarShoe() throws IOException{
        Box shoeBox = boxList.getBox(3);
        int numberOfSimilarShoe = 0;
        
        for(Iterator i = shoeBox.getGoodsIterator();i.hasNext();) {
        	
        	boolean noSituation = false;
        	boolean noWeather = false;
        	boolean noTemperature = false;
        	boolean noColor = false;
        	boolean noSizeOfShoe = false;
        	
        	Shoe tempShoe = (Shoe)i.next();
        	if(tempShoe.getName().equals(name)){
        		String nowSituation = tempShoe.getStituation();
        		String nowColor = tempShoe.getColor();
        		int nowHighTemperatrue = tempShoe.getHighTemperature();
        		int nowLowTemperatrue = tempShoe.getLowTemperature();
        		
        		String nowWeather = tempShoe.getWeather();
        		double nowSize = tempShoe.getSize();
        		
        		
        		//判断可适用场合是否相同
        		int numberOfSituation = 0;
        		StringTokenizer tokenizerOfNowSituation = new StringTokenizer(nowSituation,"，");
        		StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"，");
        		if(tokenizerOfNowSituation.countTokens() == tokenizerOfSituation.countTokens()) {
        			while(tokenizerOfSituation.hasMoreTokens()){
        				
        				String tempSituaion = tokenizerOfSituation.nextToken();
        				while(tokenizerOfNowSituation.hasMoreTokens()) {
        					String tempNowSituaion = tokenizerOfNowSituation.nextToken();
        					if(tempSituaion.equals(tempNowSituaion)) {
        						numberOfSituation ++;
        					}
        						
        				}
        			}
        			if(numberOfSituation == tokenizerOfSituation.countTokens())
        				noSituation = true;
        		}
        		
        		//判断可适用天气是否相同
            	int numberOfWeather = 0;
            	StringTokenizer tokenizerOfNowWeather = new StringTokenizer(nowWeather,"，");
        		StringTokenizer tokenizerOfWeather = new StringTokenizer(weather,"，");
        		if(tokenizerOfNowWeather.countTokens() == tokenizerOfWeather.countTokens()) {
        			while(tokenizerOfWeather.hasMoreTokens()){
        				
        				String tempWeather = tokenizerOfWeather.nextToken();
        				while(tokenizerOfNowWeather.hasMoreTokens()) {
        					String tempNowWeather = tokenizerOfNowWeather.nextToken();
        					if(tempWeather.equals(tempNowWeather)) {
        						numberOfWeather ++;
        					}
        						
        				}
        			}
        			if(numberOfWeather == tokenizerOfWeather.countTokens())
        				noWeather = true;
        		}
        		
        		//判断使用温度是否相同
        		if(nowHighTemperatrue <= highTemperature || nowLowTemperatrue >= lowTemperature) {
        			noTemperature = true;
        		}
        		
        		//判断颜色是否相同
        		if(!nowColor.equals(color)) {
        			noColor = true;
        		}
        		
        		//判断材质是否相同
        		if(nowSize != sizeOfShoe) {
        			noSizeOfShoe = true;
        		}
        		
        		/*
        		 * 给出判断是否有相似的鞋子
        		 */
        		
        		stdOut.println();
        		stdOut.println(tempShoe.toString());
        		stdOut.println("与这件鞋子有一样的：");
        		stdOut.flush();
        		if(!noSituation)
        			stdOut.println("适用场合");
        		if(!noWeather)
        			stdOut.println("适用天气");
        		if(!noTemperature)
        			stdOut.println("适用温度");
        		if(!noColor)
        			stdOut.println("颜色");
        		if(!noSizeOfShoe)
        			stdOut.println("尺码");
        		
        		stdOut.flush();
        		numberOfSimilarShoe++;
        	}
        		
        }
        if(numberOfSimilarShoe == 0) {
        	stdOut.println("没有相似的鞋子，可以放心购买");
        }else {
        	stdOut.println("搜索到有以上"+ numberOfSimilarShoe + "双类似的鞋子：");
        	stdOut.println("所以再考虑一下吧");
        }
    }
    
    public void getSimilarBag() throws IOException{
        Box bagBox = boxList.getBox(5);
        int numberOfSimilarBag = 0;
        
        for(Iterator i = bagBox.getGoodsIterator();i.hasNext();) {
        	
        	boolean noSituation = false;
        	boolean noColor = false;
        	boolean noSizeOfBag = false;
        	
        	Bag tempBag = (Bag)i.next();
        	if(tempBag.getName().equals(name)){
        		String nowSituation = tempBag.getStituation();
        		String nowColor = tempBag.getColor();
        		String nowSizeOfBag = tempBag.getSize();
        		
        		
        		//判断可适用场合是否相同
        		int numberOfSituation = 0;
        		StringTokenizer tokenizerOfNowSituation = new StringTokenizer(nowSituation,"，");
        		StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"，");
        		if(tokenizerOfNowSituation.countTokens() == tokenizerOfSituation.countTokens()) {
        			while(tokenizerOfSituation.hasMoreTokens()){
        				
        				String tempSituaion = tokenizerOfSituation.nextToken();
        				while(tokenizerOfNowSituation.hasMoreTokens()) {
        					String tempNowSituaion = tokenizerOfNowSituation.nextToken();
        					if(tempSituaion.equals(tempNowSituaion)) {
        						numberOfSituation ++;
        					}
        						
        				}
        			}
        			if(numberOfSituation == tokenizerOfSituation.countTokens())
        				noSituation = true;
        		}
        		
        		//判断颜色是否相同
        		if(!nowColor.equals(color)) {
        			noColor = true;
        		}
        		
        		//判断大小是否相同
        		if(nowSizeOfBag != sizeOfBag) {
        			noSizeOfBag = true;
        		}
        		
        		/*
        		 * 给出判断是否有相似的鞋子
        		 */
        		
        		stdOut.println();
        		stdOut.println(tempBag.toString());
        		stdOut.println("与这个箱包有一样的：");
        		stdOut.flush();
        		if(!noSituation)
        			stdOut.println("适用场合");
        		if(!noColor)
        			stdOut.println("颜色");
        		if(!noSizeOfBag)
        			stdOut.println("尺码");
        		
        		stdOut.flush();
        		numberOfSimilarBag++;
        	}
        }
        
        if(numberOfSimilarBag == 0) {
        	stdOut.println("没有相似的箱包，可以放心购买");
        }else {
        	stdOut.println("搜索到有以上"+ numberOfSimilarBag + "个类似的箱包：");
        	stdOut.println("所以再考虑一下吧");
        }
    }
    
    public void getSimilarFood() throws IOException{
    	
    	Box foodBox = boxList.getBox(4);
    	int numberOfSimilarFood = 0;
    	
        for(Iterator i = foodBox.getGoodsIterator();i.hasNext();) {
        	
        	
        	Food tempFood = (Food)i.next();
        	if(tempFood.getName().equals(name)){
        		stdOut.println();
        		stdOut.println(tempFood.toString());
        		stdOut.flush();
        		numberOfSimilarFood++;
        	}
        }
        
        if(numberOfSimilarFood == 0) 
        	stdOut.println("没有相似的食品，可以放心购买");
        else {
        	stdOut.println("搜索到有以上"+ numberOfSimilarFood + "个类似的食物：");
        	stdOut.println("所以再考虑一下吧");
        }
        	
        
        	
    }
    
    public void getSimilarOther() throws IOException{
    	
    	Box otherBox = boxList.getBox(6);
    	int numberOfSimilarOther = 0;
    	
        for(Iterator i = otherBox.getGoodsIterator();i.hasNext();) {
        	
        	Other tempOther = (Other)i.next();
        	if(tempOther.getName().equals(name)){
        		stdOut.println();
        		stdOut.println(tempOther.toString());
        		stdOut.flush();
        		numberOfSimilarOther++;
        	}
        	
        }
        if(numberOfSimilarOther == 0) {
        	stdOut.println("没有相似的物品，可以放心购买");
        }else {
        	stdOut.println("搜索到有以上"+ numberOfSimilarOther + "个类似的物品：");
        	stdOut.println("所以再考虑一下吧");
        }
        	
    }

}
