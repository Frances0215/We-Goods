package project;

import java.io.*;
import java.util.*;



public class Catalog {

	private static BufferedReader stdIn = 
			new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out,true);
	private static PrintWriter stdErr = new PrintWriter(System.err,true);
	private BoxList boxList;
	private String fileNameOfBoxList;
	
	public Catalog(User user) throws Exception{
		fileNameOfBoxList = "C:/project/" + user.getName() + "'s goods.txt";
		
		boxList = (new FileBoxListLoader()).loadBoxList(fileNameOfBoxList);
		
	}
	
	public BoxList getBoxList()
	{
		return boxList;
	}
	
	//打印菜单 
	public void displayBoxes() throws Exception{
		int  input;
		do {
			try  {
				stdOut.println();
				for(Iterator i = boxList.getBoxesIterator();i.hasNext();)
				{
					Box box = (Box)i.next();
					stdOut.println(box.toString());
				}
				stdOut.flush();
				
				stdOut.print("[0]  退出\n"
			             + "[1]  打开我的箱子\n"
			             + "[2]  添加物品\n"
			             + "我的选择> ");
				stdOut.flush();
				
				input = Integer.parseInt(stdIn.readLine());
				
				stdOut.println();
				
				
				if (0 <= input && 2 >= input)  {
					this.run(input);
					break;
				} else {
					stdErr.println("错误选择:  " + input);
				}
				
			} catch (NumberFormatException  nfe)  {
				stdErr.println(nfe);
			}
			
		}while(true);
			
		
    }

    public void run(int choice) throws Exception
    {
    		
    		if(choice == 1)
    		{
    			int boxId = getBoxId();
    			boxList.getBox(boxId).displayGoods();
    		}
    		else if(choice == 2)
    		{
    			
    			int boxId = getGoodChoice()+1;
    			Good newGood = getNewGood(boxId);
    			boxList.getBox(boxId).addGood(newGood);
    			boxList.getBox(boxId).addCapacity();
    			stdOut.println();
    			stdOut.println("添加成功");
    			stdOut.flush();
    		}
    			
    	
    }
    
    /*public Box getNewBox(){
    	
    	String name;
    	Vector<Good> goods = new Vector<Good>;
    	stdErr.println();
    	stdErr.println("请输入箱子的名称：");
    	stdErr.flush();
    		
    	name = stdIn.readLine();
    	stdErr.println();
    		
    	Box newBox = new Box(boxList.getNumberOfBoxes + 1,name,0,goods);
    	
    }*/
    
    

    public int getGoodChoice() throws Exception{
    	
    	int input;
    	do {
	    	try {
	    		stdOut.println();
				stdOut.print("请选择新添加的物品类型：\n"
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
					break;
				} else {
					stdErr.println("错误输入：  " + input);
				}
	
	    	}catch(NumberFormatException  nfe)  {
				stdErr.println(nfe);
			}
    	}while(true);
    	
    	return input;
    }
    
    public int getBoxId() throws IOException{
    	
    	int id;
    	
    	do {
	    	try  {
				stdOut.println();
				stdOut.print(
						  "请输入想要打开的箱子的序号：\n"
						  + "从1到6\n"
						  + "我的选择：> ");
				stdOut.flush();
				
				id = Integer.parseInt(stdIn.readLine());
	
				stdOut.println();
	
				if (id>=1 && id<=6)  {
					break;
				} else {
					stdErr.println("错误输入:  " + id);
				}
			} catch (NumberFormatException  nfe)  {
				stdErr.println(nfe);
			}
    	}while(true);
        return id;
    }
    
    public Good getNewGood(int choice1) throws Exception{
    	
    	Good good ;
        String time;
        String name;
        double value;
        String situation;
        int choice = choice1 -1;
       
        try  {
			stdOut.println();
			stdOut.print("请输入物品名称：");
			stdOut.flush();
			name = stdIn.readLine();
					
			stdOut.println();
			stdOut.print("请输入物品的价格：");
			stdOut.flush();
			value = Double.valueOf(stdIn.readLine());
					
			do {
				stdOut.println();
				stdOut.print("请输入物品的购买日期：");
				stdOut.flush();
				time = stdIn.readLine();
				
				StringTokenizer tokenizerOfTime = new StringTokenizer(time,".");
		    	if(tokenizerOfTime.countTokens() == 3) {
					break;
				}else {
					stdErr.println("您的日期输入有误:  " + time);
					stdErr.print("请重新输入：");
				}
			}while(true);
			
			
			stdOut.println();
			stdOut.print("请输入物品适用场合：(若可适用于多种场合请用“，”分开)");
			stdOut.flush();
			situation = stdIn.readLine();
			
			 if(choice == 0)
		        {
		        	good = this.getNewTrouser(time,name,value,situation);
		        }
		        else if(choice == 1)
		        {
		        	good = this.getNewJacket(time,name,value,situation);
		        }
		        else if(choice == 2)
		        {
		        	good = this.getNewShoe(time, name,value,situation);
		        }
		        else if(choice == 3)
		        {
		        	good = this.getNewFood(time, name,value,situation);
		        }
		        else if(choice == 4)
		        {
		        	good = this.getNewBag(time, name,value,situation);
		        }
		        else
		        {
		        	good = this.getNewOther(time, name,value,situation);
		        }
			 	
			 return good;
    	}catch(IOException e) {
    		stdErr.println(e);
    		
        }
        return null;
    }

    public Trouser getNewTrouser(String time, String name,
    		double value, String situation) 
    {
    	 String code;
    	 int highTemperature;
         int lowTemperature;
         String weather;
         String color;
         String fabric;
         
    	try {
    		
    		do {
    			stdOut.println();
        		stdOut.print("请为这件衣服编号（请以T开头后接三位正整数）：");
        		stdOut.flush();
    			code = stdIn.readLine();
    			
		    	if(code.startsWith("T")) {
					break;
				}else {
					stdErr.println("您的编号输入有误:  " + code);
					stdErr.print("请重新输入：");
				}
			}while(true);
    		
			
			stdOut.println();
			stdOut.print("请输入可穿这件衣服的最高温度：");
			stdOut.flush();
			highTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("请输入可穿这件衣服的最低温度：");
			stdOut.flush();
			lowTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("请输入可穿这件衣服的天气：(若可穿天气不为1，请用“，”分开每种天气)");
			stdOut.flush();
			weather = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("请输入这件衣服的颜色：");
			stdOut.flush();
			color = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("请输入这件衣服的材质：");
			stdOut.flush();
			fabric = stdIn.readLine();
			
			Trouser newTrouser = new Trouser(code,time,name,
	        		value, situation, highTemperature, 
	        		lowTemperature,weather, color, fabric);
			
			boxList.addTrouserFile(newTrouser,fileNameOfBoxList);
	    	
	    	return newTrouser;
    	}catch(IOException e) {
    		stdErr.println(e);
        }
    	
    	return null;
    }
    
    public Jacket getNewJacket(String time, String name,
    		double value, String situation) 
    {
    	 String code;
    	 int highTemperature;
         int lowTemperature;
         String weather;
         String color;
         String fabric;
         
    	try {
    		do {
    			stdOut.println();
        		stdOut.print("请为这条裤子编号（请以J开头后接三位正整数）：");
        		stdOut.flush();
    			code = stdIn.readLine();
    			
		    	if(code.startsWith("J")) {
					break;
				}else {
					stdErr.println("您的编号输入有误:  " + code);
					stdErr.print("请重新输入：");
				}
			}while(true);
			
			stdOut.println();
			stdOut.print("请输入可穿这条裤子的最高温度：");
			stdOut.flush();
			highTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("请输入可穿这条裤子的最低温度：");
			stdOut.flush();
			lowTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("请输入可穿这条裤子的天气：");
			stdOut.flush();
			weather = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("请输入这条裤子的颜色：");
			stdOut.flush();
			color = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("请输入这条裤子的材质：");
			stdOut.flush();
			fabric = stdIn.readLine();
			
			Jacket newJacket = new Jacket(code,time,name,
	        		value, situation, highTemperature, 
	        		lowTemperature,weather, color, fabric);
			
			boxList.addJacketFile(newJacket,fileNameOfBoxList);
	    	return newJacket;
    	}catch(IOException e) {
    		stdErr.println(e);
        }
    	
    	return null;
    }
    
    public Shoe getNewShoe(String time, String name,
    		double value, String situation) 
    {
    	 String code;
    	 int highTemperature;
         int lowTemperature;
         String weather;
         String color;
         double size;
         
    	try {
    		do {
    			stdOut.println();
        		stdOut.print("请为这双鞋子编号（请以S开头后接三位正整数）：");
        		stdOut.flush();
    			code = stdIn.readLine();
    			
		    	if(code.startsWith("S")) {
					break;
				}else {
					stdErr.println("您的编号输入有误:  " + code);
					stdErr.print("请重新输入：");
				}
			}while(true);
			
			stdOut.println();
			stdOut.print("请输入可穿这双鞋子的最高温度：");
			stdOut.flush();
			highTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("请输入可穿这双鞋子的最低温度：");
			stdOut.flush();
			lowTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("请输入可穿这双鞋子的天气：");
			stdOut.flush();
			weather = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("请输入这双鞋子的颜色：");
			stdOut.flush();
			color = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("请输入这双鞋子的码数：");
			stdOut.flush();
			size = Double.valueOf(stdIn.readLine());
			
			Shoe newShoe = new Shoe(code,time,name,
	        		value, situation,highTemperature, 
	        		lowTemperature, weather,color,size);
	    	
			boxList.addShoeFile(newShoe,fileNameOfBoxList);
	    	return newShoe;
    	}catch(IOException e) {
    		stdErr.println(e);
        }
    	
    	return null;
    }
    
    public Food getNewFood(String time, String name,
    		double value, String situation) 
    {
    	 String code;
    	 int expirationDate;
    	 String productionDate;
         
    	try {
    		do {
    			stdOut.println();
        		stdOut.print("请为这个食品编号（请以F开头后接三位正整数）：");
        		stdOut.flush();
    			code = stdIn.readLine();
    			
		    	if(code.startsWith("F")) {
					break;
				}else {
					stdErr.println("您的编号输入有误:  " + code);
					stdErr.print("请重新输入：");
				}
			}while(true);
			
			stdOut.println();
			stdOut.print("请输入该食品的保质期：(请以天为单位输入正整数)");
			stdOut.flush();
			expirationDate = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("请输入该食品的生产日期：");
			stdOut.flush();
			productionDate = stdIn.readLine();
			
			Food newFood = new Food(code, time, name,
	        		value, situation,expirationDate,productionDate);
	    	
			boxList.addFoodFile(newFood,fileNameOfBoxList);
	    	return newFood;
			
    	}catch(IOException e) {
    		stdErr.println(e);
        }
    	
    	return null;
    }

    public Bag getNewBag(String time, String name,
    		double value, String situation) 
    {
    	 String code;
    	 String size;
    	 String color;
         
    	try {
    		do {
    			stdOut.println();
        		stdOut.print("请为这个箱包编号（请以B开头后接三位正整数）：");
        		stdOut.flush();
    			code = stdIn.readLine();
    			
		    	if(code.startsWith("B")) {
					break;
				}else {
					stdErr.println("您的编号输入有误:  " + code);
					stdErr.print("请重新输入：");
				}
			}while(true);
			
			stdOut.println();
			stdOut.print("请输入该箱包的大小：");
			stdOut.flush();
			size = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("请输入该箱包的颜色：");
			stdOut.flush();
			color = stdIn.readLine();
			
			Bag newBag = new Bag(code, time, name,
	        		value, situation,size,color);
	    	
			boxList.addBagFile(newBag,fileNameOfBoxList);
	    	return newBag;
	    	
    	}catch(IOException e) {
    		stdErr.println(e);
        }
    	
    	return null;
    }
    
    public Other getNewOther(String time, String name,
    		double value, String situation) 
    {
    	 String code;
    	 String attribute;
         
    	try {
    		do {
    			stdOut.println();
        		stdOut.print("请为这件物品编号（请以O开头后接三位正整数）：");
        		stdOut.flush();
    			code = stdIn.readLine();
    			
		    	if(code.startsWith("O")) {
					break;
				}else {
					stdErr.println("您的编号输入有误:  " + code);
					stdErr.print("请重新输入：");
				}
			}while(true);
			
			stdOut.println();
			stdOut.print("请输入对该物品的描述：");
			stdOut.flush();
			attribute = stdIn.readLine();
			
			Other newOther = new Other(code, time, name,
	        		value, situation,attribute);
	    	
			boxList.addOtherFile(newOther,fileNameOfBoxList);
	    	return newOther;
	    	
    	}catch(IOException e) {
    		stdErr.println(e);
        }
    	
    	return null;
    }

}
