package project;

import java.io.*;
import java.util.*;

public class LoadNewUser {
	private static BufferedReader  stdIn =
	      new  BufferedReader(new  InputStreamReader(System.in));
	private static PrintWriter  stdOut =
	      new  PrintWriter(System.out, true);
	private static PrintWriter  stdErr =
	      new  PrintWriter(System.err, true);
	
	private String name;
	private String code;
    private int age;
    private String sex;
    private float height;
    private float weight;
    private float value;
    
	public void writeUserFile() throws IOException{
		
		try {
			stdErr.println();
			stdErr.print("请输入您的用户名：");
			stdErr.flush();
			name = stdIn.readLine();
			
			stdErr.println();
			stdErr.print("请输入您的密码：");
			stdErr.flush();
			code = stdIn.readLine();
			
			stdErr.println();
			stdErr.print("请输入您的年龄：");
			stdErr.flush();
			age = Integer.parseInt(stdIn.readLine());
			
			stdErr.println();
			stdErr.print("请输入您的性别：");
			stdErr.flush();
			sex = stdIn.readLine();
			
			stdErr.println();
			stdErr.print("请输入您的身高：");
			stdErr.flush();
			height = Float.parseFloat(stdIn.readLine());
			
			stdErr.println();
			stdErr.print("请输入您的体重：");
			stdErr.flush();
			weight = Float.parseFloat(stdIn.readLine());
			
			String fileName = "C:/project/"+ name + "'s information.txt";
			String fileNameOfBoxList = "C:/project/" + name + "'s goods.txt";
			
			value = 0;
			
			PrintWriter fileOut =
		            new PrintWriter(new FileWriter(fileName));
			
			
		    fileOut.println("姓名" +"_" + name + "\n"
		    		+"密码" + "_" + code + "\n"
		    		+"年龄" + "_" + age + "\n"
		    		+"性别" + "_" + sex + "\n"
		    		+"身高" + "_" + height + "\n"
		    		+"体重" + "_" + weight + "\n"
		    		+"身价" + "_" + value );

		    fileOut.close();
		    
		    stdErr.println("注册成功");
		    
		    
		    File fileOfBoxList = new File(fileNameOfBoxList);
		    if(!fileOfBoxList.exists())
		    		fileOfBoxList.createNewFile();
		    	
		}catch (IOException e){
			stdErr.println(e);
		}
	}

}
