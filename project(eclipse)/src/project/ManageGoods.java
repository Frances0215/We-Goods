package project;

import java.io.*;
import java.util.*;
import java.text.*;

public class ManageGoods {

	private static BufferedReader stdIn = 
			new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out,true);
	private static PrintWriter stdErr = new PrintWriter(System.err,true);
	
	private Catalog catalog;
	private ClothRecommend clothRecommend;
	private TravelRecommend travelRecommend;
	private FoodRemind foodRemind;
	private ShoppingRecommend shoppingRecommend;
	private User user;
	public static void main(String[] args) throws Exception{
		
		ManageGoods application = new ManageGoods();
		application.run();
	}
	
	private ManageGoods() throws Exception{
		user = this.getUser();
		//clothRecommend = new ClothRecommend(catalog.getBoxList());
		//travelRecommend = new TravelRecommend();
		//foodRemind = new FoodRemind();
		//shoppingRecommend = new ShoppingRecommend();
		
	}

	private User getUser() throws Exception{
		User user = null;
		try {
			/*
			 * �����û���
			 * �жϸ��û��Ƿ����
			 * ��������ע��
			 * ������Ҫ����������
			 * ������ȷ����˵���
			 * ���������������
			 * 
			 * */
			stdOut.println();
			stdOut.print("�����������û�����");
			stdOut.flush();
			
			String name = stdIn.readLine();
			String fileName = "C:/project/" + name + "'s information.txt";
			
			//��֤�����Ƿ���ȷ
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			String rightCode = "";
			while (line != null) {

	            if(line.startsWith("����"))
	            {
	            	StringTokenizer tokenizer = new StringTokenizer(line, "_");
	            	String prefix = tokenizer.nextToken();
	            	rightCode = tokenizer.nextToken();
	            }
	            line =  reader.readLine();
	        }
			boolean p = true;
			do {
				stdOut.println();
				stdOut.print("�������������룺");
				stdOut.flush();
				String code = stdIn.readLine();
				if(!code.equals(rightCode))
				{
					stdErr.println("�����������");
					p = false;
				}	
				else 
					p = true;
			}while(!p);
			reader.close();
			
			user = (new FileUserLoader()).loadUser(fileName);
			
			catalog = new Catalog(user);
			
		} catch (FileNotFoundException fnfe) {
			stdErr.println("���û�δע��");
			stdErr.println("��ʼע�������˺�");
			stdErr.flush();
			LoadNewUser newUser = new LoadNewUser();
			newUser.writeUserFile();
			 user = this.getUser();

		} catch (DataFormatException dfe) {
			stdErr.println("The file contains malformed data: "
			               + dfe.getMessage());

			System.exit(1);
		}
		
		return user;
		
	}
	
    public int getChoice() throws IOException{
    	
    	int input;
    	
    	do {
    		try {
    			stdOut.println();
    			stdOut.print("[0] �˳�\n"
    					+ "[1] չʾ�ҵĹ���\n"
    					+ "[2] ���մ����Ƽ�\n"
    					+ "[3] ���ճ����Ƽ�\n"
    					+ "[4] ʳƷ����\n"
    					+ "[5] ������ʾ\n"
    					+ "[6] �ҵ���Ϣ\n"
    					+ "[7] ��GUI��ϵͳ\n"
    					+ "�ҵ�ѡ��");
    			stdOut.flush();
    			
    			input = Integer.parseInt(stdIn.readLine());
    			
    			stdOut.println();
    			stdOut.flush();
    			
    			if(input >= 0 && input <= 7)
    				break;
    			else {
    				stdErr.println("����ѡ��" + input);
    			}
    		}catch(NumberFormatException nfe) {
    			stdErr.println(nfe);
    		}
    	} while(true);
    	
        return input;
    }

    public void run() throws Exception{
    	int choice = getChoice();
    	
    	while(choice != 0)
    	{
    		
    		if(choice == 1)
    			this.showBoxes();
    		else if(choice == 2) {
    			this.getClothRecommend();
    			
    		}
    		else if(choice == 3)
    			this.getTravelRecommend();
    		else if(choice == 4)
    			this.getFoodRemind();
    		else if(choice == 5)
    			this.getShoppingRecommend();
    		else if(choice == 6)
    			this.showMyInformation();
    		else
    			this.manageGoodGUI();
    		
    		choice = getChoice();
    		
    	}
    }

    
    public void showBoxes() throws Exception{
    	
    	catalog.displayBoxes();
    }
    
    public void getClothRecommend() throws IOException{
    	
    	clothRecommend = new ClothRecommend(catalog.getBoxList());
    	clothRecommend.displayRecommend();
    	
    }
    
    public void getTravelRecommend() throws IOException{
    	travelRecommend = new TravelRecommend(catalog.getBoxList());
    	travelRecommend.displayTravelRecommend();
    }
    
    public void getFoodRemind() throws IOException{
    	
    	foodRemind = new FoodRemind(catalog.getBoxList());
    	foodRemind.displayFoodRemind();
    	
    }
    
    public void getShoppingRecommend() throws IOException{
    	shoppingRecommend = new ShoppingRecommend(catalog.getBoxList());
    	shoppingRecommend.getInformationOfWantGood();
    }
    
    public void showMyInformation() {
    	
    	stdOut.println();
    	stdOut.println("������" + user.getName());
    	stdOut.println("���䣺" + user.getAge());
    	stdOut.println("�Ա�" + user.getSex());
    	stdOut.println("��ߣ�" + user.getHeight());
    	stdOut.println("���أ�" + user.getWeight());
    	stdOut.println("��ۣ�" + user.getValue());
    	stdOut.flush();
    }
    
    public void manageGoodGUI() {
    	
    	ManageGoodsGUI manageGoodsGUI = new ManageGoodsGUI(catalog.getBoxList(),user);
    	manageGoodsGUI.displayGUI();
    }
}


