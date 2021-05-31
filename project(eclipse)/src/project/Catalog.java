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
	
	//��ӡ�˵� 
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
				
				stdOut.print("[0]  �˳�\n"
			             + "[1]  ���ҵ�����\n"
			             + "[2]  �����Ʒ\n"
			             + "�ҵ�ѡ��> ");
				stdOut.flush();
				
				input = Integer.parseInt(stdIn.readLine());
				
				stdOut.println();
				
				
				if (0 <= input && 2 >= input)  {
					this.run(input);
					break;
				} else {
					stdErr.println("����ѡ��:  " + input);
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
    			stdOut.println("��ӳɹ�");
    			stdOut.flush();
    		}
    			
    	
    }
    
    /*public Box getNewBox(){
    	
    	String name;
    	Vector<Good> goods = new Vector<Good>;
    	stdErr.println();
    	stdErr.println("���������ӵ����ƣ�");
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
				stdOut.print("��ѡ������ӵ���Ʒ���ͣ�\n"
					+ "[0] �·�\n"
					+ "[1] ����\n"
					+ "[2] Ь��\n"
					+ "[3] ʳ��\n"
					+ "[4] ���\n"
					+ "[5] ����\n"
					+ "���ѡ��> ");
				stdOut.flush();
	
				input = Integer.parseInt(stdIn.readLine());
	
				stdOut.println();
				
				if (0 <= input && 5 >= input)  {
					break;
				} else {
					stdErr.println("�������룺  " + input);
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
						  "��������Ҫ�򿪵����ӵ���ţ�\n"
						  + "��1��6\n"
						  + "�ҵ�ѡ��> ");
				stdOut.flush();
				
				id = Integer.parseInt(stdIn.readLine());
	
				stdOut.println();
	
				if (id>=1 && id<=6)  {
					break;
				} else {
					stdErr.println("��������:  " + id);
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
			stdOut.print("��������Ʒ���ƣ�");
			stdOut.flush();
			name = stdIn.readLine();
					
			stdOut.println();
			stdOut.print("��������Ʒ�ļ۸�");
			stdOut.flush();
			value = Double.valueOf(stdIn.readLine());
					
			do {
				stdOut.println();
				stdOut.print("��������Ʒ�Ĺ������ڣ�");
				stdOut.flush();
				time = stdIn.readLine();
				
				StringTokenizer tokenizerOfTime = new StringTokenizer(time,".");
		    	if(tokenizerOfTime.countTokens() == 3) {
					break;
				}else {
					stdErr.println("����������������:  " + time);
					stdErr.print("���������룺");
				}
			}while(true);
			
			
			stdOut.println();
			stdOut.print("��������Ʒ���ó��ϣ�(���������ڶ��ֳ������á������ֿ�)");
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
        		stdOut.print("��Ϊ����·���ţ�����T��ͷ�����λ����������");
        		stdOut.flush();
    			code = stdIn.readLine();
    			
		    	if(code.startsWith("T")) {
					break;
				}else {
					stdErr.println("���ı����������:  " + code);
					stdErr.print("���������룺");
				}
			}while(true);
    		
			
			stdOut.println();
			stdOut.print("������ɴ�����·�������¶ȣ�");
			stdOut.flush();
			highTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("������ɴ�����·�������¶ȣ�");
			stdOut.flush();
			lowTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("������ɴ�����·���������(���ɴ�������Ϊ1�����á������ֿ�ÿ������)");
			stdOut.flush();
			weather = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("����������·�����ɫ��");
			stdOut.flush();
			color = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("����������·��Ĳ��ʣ�");
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
        		stdOut.print("��Ϊ�������ӱ�ţ�����J��ͷ�����λ����������");
        		stdOut.flush();
    			code = stdIn.readLine();
    			
		    	if(code.startsWith("J")) {
					break;
				}else {
					stdErr.println("���ı����������:  " + code);
					stdErr.print("���������룺");
				}
			}while(true);
			
			stdOut.println();
			stdOut.print("������ɴ��������ӵ�����¶ȣ�");
			stdOut.flush();
			highTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("������ɴ��������ӵ�����¶ȣ�");
			stdOut.flush();
			lowTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("������ɴ��������ӵ�������");
			stdOut.flush();
			weather = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("�������������ӵ���ɫ��");
			stdOut.flush();
			color = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("�������������ӵĲ��ʣ�");
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
        		stdOut.print("��Ϊ��˫Ь�ӱ�ţ�����S��ͷ�����λ����������");
        		stdOut.flush();
    			code = stdIn.readLine();
    			
		    	if(code.startsWith("S")) {
					break;
				}else {
					stdErr.println("���ı����������:  " + code);
					stdErr.print("���������룺");
				}
			}while(true);
			
			stdOut.println();
			stdOut.print("������ɴ���˫Ь�ӵ�����¶ȣ�");
			stdOut.flush();
			highTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("������ɴ���˫Ь�ӵ�����¶ȣ�");
			stdOut.flush();
			lowTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("������ɴ���˫Ь�ӵ�������");
			stdOut.flush();
			weather = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("��������˫Ь�ӵ���ɫ��");
			stdOut.flush();
			color = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("��������˫Ь�ӵ�������");
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
        		stdOut.print("��Ϊ���ʳƷ��ţ�����F��ͷ�����λ����������");
        		stdOut.flush();
    			code = stdIn.readLine();
    			
		    	if(code.startsWith("F")) {
					break;
				}else {
					stdErr.println("���ı����������:  " + code);
					stdErr.print("���������룺");
				}
			}while(true);
			
			stdOut.println();
			stdOut.print("�������ʳƷ�ı����ڣ�(������Ϊ��λ����������)");
			stdOut.flush();
			expirationDate = Integer.parseInt(stdIn.readLine());
			
			stdOut.println();
			stdOut.print("�������ʳƷ���������ڣ�");
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
        		stdOut.print("��Ϊ��������ţ�����B��ͷ�����λ����������");
        		stdOut.flush();
    			code = stdIn.readLine();
    			
		    	if(code.startsWith("B")) {
					break;
				}else {
					stdErr.println("���ı����������:  " + code);
					stdErr.print("���������룺");
				}
			}while(true);
			
			stdOut.println();
			stdOut.print("�����������Ĵ�С��");
			stdOut.flush();
			size = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("��������������ɫ��");
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
        		stdOut.print("��Ϊ�����Ʒ��ţ�����O��ͷ�����λ����������");
        		stdOut.flush();
    			code = stdIn.readLine();
    			
		    	if(code.startsWith("O")) {
					break;
				}else {
					stdErr.println("���ı����������:  " + code);
					stdErr.print("���������룺");
				}
			}while(true);
			
			stdOut.println();
			stdOut.print("������Ը���Ʒ��������");
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
