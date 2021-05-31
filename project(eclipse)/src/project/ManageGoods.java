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
			 * 输入用户名
			 * 判断该用户是否存在
			 * 不存在则注册
			 * 存在则要求输入密码
			 * 输入正确进入菜单栏
			 * 输入错误重新输入
			 * 
			 * */
			stdOut.println();
			stdOut.print("请输入您的用户名：");
			stdOut.flush();
			
			String name = stdIn.readLine();
			String fileName = "C:/project/" + name + "'s information.txt";
			
			//验证密码是否正确
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			String rightCode = "";
			while (line != null) {

	            if(line.startsWith("密码"))
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
				stdOut.print("请输入您的密码：");
				stdOut.flush();
				String code = stdIn.readLine();
				if(!code.equals(rightCode))
				{
					stdErr.println("密码输入错误");
					p = false;
				}	
				else 
					p = true;
			}while(!p);
			reader.close();
			
			user = (new FileUserLoader()).loadUser(fileName);
			
			catalog = new Catalog(user);
			
		} catch (FileNotFoundException fnfe) {
			stdErr.println("该用户未注册");
			stdErr.println("开始注册您的账号");
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
    			stdOut.print("[0] 退出\n"
    					+ "[1] 展示我的柜子\n"
    					+ "[2] 今日穿搭推荐\n"
    					+ "[3] 今日出行推荐\n"
    					+ "[4] 食品提醒\n"
    					+ "[5] 购物提示\n"
    					+ "[6] 我的信息\n"
    					+ "[7] 用GUI打开系统\n"
    					+ "我的选择：");
    			stdOut.flush();
    			
    			input = Integer.parseInt(stdIn.readLine());
    			
    			stdOut.println();
    			stdOut.flush();
    			
    			if(input >= 0 && input <= 7)
    				break;
    			else {
    				stdErr.println("错误选择" + input);
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
    	stdOut.println("姓名：" + user.getName());
    	stdOut.println("年龄：" + user.getAge());
    	stdOut.println("性别：" + user.getSex());
    	stdOut.println("身高：" + user.getHeight());
    	stdOut.println("体重：" + user.getWeight());
    	stdOut.println("身价：" + user.getValue());
    	stdOut.flush();
    }
    
    public void manageGoodGUI() {
    	
    	ManageGoodsGUI manageGoodsGUI = new ManageGoodsGUI(catalog.getBoxList(),user);
    	manageGoodsGUI.displayGUI();
    }
}


