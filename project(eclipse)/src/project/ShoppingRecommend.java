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
				stdOut.print("��ѡ����Ҫ�������Ʒ���ͣ�\n"
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
					stdOut.println("������������Ҫ�������Ʒ��Ϣ��");
					
					stdOut.println("���ƣ�");
					stdOut.flush();
					name = stdIn.readLine();
					
					stdOut.println("���ó��ϣ�");
					stdOut.flush();
					situation = stdIn.readLine();
					
					break;
				} else {
					stdErr.println("�������룺  " + input);
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
    
	    	stdOut.println("�ɴ�����·�������¶ȣ�");
			stdOut.flush();
			highTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println("�ɴ�����·�������¶ȣ�");
			stdOut.flush();
			lowTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println("�ɴ�����·���������");
			stdOut.flush();
			weather = stdIn.readLine();
			
			stdOut.println("����·��Ĳ��ʣ�");
			stdOut.flush();
			fabric = stdIn.readLine();
			
			this.getSimilarTrouser();
    	}catch(IOException e) {
    		stdErr.println(e);
        }
    }
    
    public void getInformationOfJacket() throws IOException{
    	try {
	    	stdOut.println("�ɴ��������ӵ�����¶ȣ�");
			stdOut.flush();
			highTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println("�ɴ��������ӵ�����¶ȣ�");
			stdOut.flush();
			lowTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println("�ɴ��������ӵ�������");
			stdOut.flush();
			weather = stdIn.readLine();
			
			stdOut.println("�������ӵĲ��ʣ�");
			stdOut.flush();
			fabric = stdIn.readLine();
			
			stdOut.println("�������ӵ���ɫ��");
			stdOut.flush();
			color = stdIn.readLine();
			
			this.getSimilarJacket();
    	}catch(IOException e) {
    		stdErr.println(e);
        }
    }
    
    public void getInformationOfShoe() throws IOException{
    	try {
	    	stdOut.println("�ɴ���˫Ь�ӵ�����¶ȣ�");
			stdOut.flush();
			highTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println("�ɴ���˫Ь�ӵ�����¶ȣ�");
			stdOut.flush();
			lowTemperature = Integer.parseInt(stdIn.readLine());
			
			stdOut.println("�ɴ���˫Ь�ӵ�������");
			stdOut.flush();
			weather = stdIn.readLine();
			
			stdOut.println("��˫Ь�ӵ���ɫ��");
			stdOut.flush();
			color = stdIn.readLine();
			
			stdOut.println("��˫Ь�ӵĳ��룺");
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
			stdOut.print("������Ĵ�С��");
			stdOut.flush();
			sizeOfBag = stdIn.readLine();
			
			stdOut.println();
			stdOut.print("���������ɫ��");
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
        		
        		
        		//�жϿ����ó����Ƿ���ͬ
        		int numberOfSituation = 0;
        		StringTokenizer tokenizerOfNowSituation = new StringTokenizer(nowSituation,"��");
        		StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"��");
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
        		
        		//�жϿ����������Ƿ���ͬ
            	int numberOfWeather = 0;
            	StringTokenizer tokenizerOfNowWeather = new StringTokenizer(nowWeather,"��");
        		StringTokenizer tokenizerOfWeather = new StringTokenizer(weather,"��");
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
        		
        		//�ж�ʹ���¶��Ƿ���ͬ
        		if(nowHighTemperatrue <= highTemperature || nowLowTemperatrue >= lowTemperature) {
        			noTemperature = true;
        		}
        		
        		//�ж���ɫ�Ƿ���ͬ
        		if(!nowColor.equals(color)) {
        			noColor = true;
        		}
        		
        		//�жϲ����Ƿ���ͬ
        		if(!nowFabric.equals(fabric)) {
        			noFabric = true;
        		}
        		
        		/*
        		 * �����ж��Ƿ������Ƶ��·�
        		 */
        		
        		stdOut.println();
        		stdOut.println(tempTrouser.toString());
        		stdOut.println("������·���һ���ģ�");
        		stdOut.flush();
        		if(!noSituation)
        			stdOut.println("���ó���");
        		if(!noWeather)
        			stdOut.println("��������");
        		if(!noTemperature)
        			stdOut.println("�����¶�");
        		if(!noColor)
        			stdOut.println("��ɫ");
        		if(!noFabric)
        			stdOut.println("����");
        		
        		stdOut.flush();
        		numberOfSimilarTrouser ++;
        	}
        	
        }
        if(numberOfSimilarTrouser == 0) {
        	stdOut.println("û�����Ƶ��·������Է��Ĺ���");
        }else {
        	stdOut.println("������������"+ numberOfSimilarTrouser + "�����Ƶ��·���");
        	stdOut.println("�����ٿ���һ�°�");
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
        		
        		
        		//�жϿ����ó����Ƿ���ͬ
        		int numberOfSituation = 0;
        		StringTokenizer tokenizerOfNowSituation = new StringTokenizer(nowSituation,"��");
        		StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"��");
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
        		
        		//�жϿ����������Ƿ���ͬ
            	int numberOfWeather = 0;
            	StringTokenizer tokenizerOfNowWeather = new StringTokenizer(nowWeather,"��");
        		StringTokenizer tokenizerOfWeather = new StringTokenizer(weather,"��");
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
        		
        		//�ж�ʹ���¶��Ƿ���ͬ
        		if(nowHighTemperatrue <= highTemperature || nowLowTemperatrue >= lowTemperature) {
        			noTemperature = true;
        		}
        		
        		//�ж���ɫ�Ƿ���ͬ
        		if(!nowColor.equals(color)) {
        			noColor = true;
        		}
        		
        		//�жϲ����Ƿ���ͬ
        		if(!nowFabric.equals(fabric)) {
        			noFabric = true;
        		}
        		
        		/*
        		 * �����ж��Ƿ������ƵĿ���
        		 */
        		
        		stdOut.println();
        		stdOut.println(tempJacket.toString());
        		stdOut.println("�����������һ���ģ�");
        		stdOut.flush();
        		if(!noSituation)
        			stdOut.println("���ó���");
        		if(!noWeather)
        			stdOut.println("��������");
        		if(!noTemperature)
        			stdOut.println("�����¶�");
        		if(!noColor)
        			stdOut.println("��ɫ");
        		if(!noFabric)
        			stdOut.println("����");
        		
        		stdOut.flush();
        		numberOfSimilarJacket ++;
        	}	
        }
        
        if(numberOfSimilarJacket == 0) {
        	stdOut.println("û�����ƵĿ��ӣ����Է��Ĺ���");
        }else {
        	stdOut.println("������������"+ numberOfSimilarJacket + "�����ƵĿ��ӣ�");
        	stdOut.println("�����ٿ���һ�°�");
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
        		
        		
        		//�жϿ����ó����Ƿ���ͬ
        		int numberOfSituation = 0;
        		StringTokenizer tokenizerOfNowSituation = new StringTokenizer(nowSituation,"��");
        		StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"��");
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
        		
        		//�жϿ����������Ƿ���ͬ
            	int numberOfWeather = 0;
            	StringTokenizer tokenizerOfNowWeather = new StringTokenizer(nowWeather,"��");
        		StringTokenizer tokenizerOfWeather = new StringTokenizer(weather,"��");
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
        		
        		//�ж�ʹ���¶��Ƿ���ͬ
        		if(nowHighTemperatrue <= highTemperature || nowLowTemperatrue >= lowTemperature) {
        			noTemperature = true;
        		}
        		
        		//�ж���ɫ�Ƿ���ͬ
        		if(!nowColor.equals(color)) {
        			noColor = true;
        		}
        		
        		//�жϲ����Ƿ���ͬ
        		if(nowSize != sizeOfShoe) {
        			noSizeOfShoe = true;
        		}
        		
        		/*
        		 * �����ж��Ƿ������Ƶ�Ь��
        		 */
        		
        		stdOut.println();
        		stdOut.println(tempShoe.toString());
        		stdOut.println("�����Ь����һ���ģ�");
        		stdOut.flush();
        		if(!noSituation)
        			stdOut.println("���ó���");
        		if(!noWeather)
        			stdOut.println("��������");
        		if(!noTemperature)
        			stdOut.println("�����¶�");
        		if(!noColor)
        			stdOut.println("��ɫ");
        		if(!noSizeOfShoe)
        			stdOut.println("����");
        		
        		stdOut.flush();
        		numberOfSimilarShoe++;
        	}
        		
        }
        if(numberOfSimilarShoe == 0) {
        	stdOut.println("û�����Ƶ�Ь�ӣ����Է��Ĺ���");
        }else {
        	stdOut.println("������������"+ numberOfSimilarShoe + "˫���Ƶ�Ь�ӣ�");
        	stdOut.println("�����ٿ���һ�°�");
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
        		
        		
        		//�жϿ����ó����Ƿ���ͬ
        		int numberOfSituation = 0;
        		StringTokenizer tokenizerOfNowSituation = new StringTokenizer(nowSituation,"��");
        		StringTokenizer tokenizerOfSituation = new StringTokenizer(situation,"��");
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
        		
        		//�ж���ɫ�Ƿ���ͬ
        		if(!nowColor.equals(color)) {
        			noColor = true;
        		}
        		
        		//�жϴ�С�Ƿ���ͬ
        		if(nowSizeOfBag != sizeOfBag) {
        			noSizeOfBag = true;
        		}
        		
        		/*
        		 * �����ж��Ƿ������Ƶ�Ь��
        		 */
        		
        		stdOut.println();
        		stdOut.println(tempBag.toString());
        		stdOut.println("����������һ���ģ�");
        		stdOut.flush();
        		if(!noSituation)
        			stdOut.println("���ó���");
        		if(!noColor)
        			stdOut.println("��ɫ");
        		if(!noSizeOfBag)
        			stdOut.println("����");
        		
        		stdOut.flush();
        		numberOfSimilarBag++;
        	}
        }
        
        if(numberOfSimilarBag == 0) {
        	stdOut.println("û�����Ƶ���������Է��Ĺ���");
        }else {
        	stdOut.println("������������"+ numberOfSimilarBag + "�����Ƶ������");
        	stdOut.println("�����ٿ���һ�°�");
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
        	stdOut.println("û�����Ƶ�ʳƷ�����Է��Ĺ���");
        else {
        	stdOut.println("������������"+ numberOfSimilarFood + "�����Ƶ�ʳ�");
        	stdOut.println("�����ٿ���һ�°�");
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
        	stdOut.println("û�����Ƶ���Ʒ�����Է��Ĺ���");
        }else {
        	stdOut.println("������������"+ numberOfSimilarOther + "�����Ƶ���Ʒ��");
        	stdOut.println("�����ٿ���һ�°�");
        }
        	
    }

}
