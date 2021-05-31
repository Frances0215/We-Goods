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
			stdErr.print("�����������û�����");
			stdErr.flush();
			name = stdIn.readLine();
			
			stdErr.println();
			stdErr.print("�������������룺");
			stdErr.flush();
			code = stdIn.readLine();
			
			stdErr.println();
			stdErr.print("�������������䣺");
			stdErr.flush();
			age = Integer.parseInt(stdIn.readLine());
			
			stdErr.println();
			stdErr.print("�����������Ա�");
			stdErr.flush();
			sex = stdIn.readLine();
			
			stdErr.println();
			stdErr.print("������������ߣ�");
			stdErr.flush();
			height = Float.parseFloat(stdIn.readLine());
			
			stdErr.println();
			stdErr.print("�������������أ�");
			stdErr.flush();
			weight = Float.parseFloat(stdIn.readLine());
			
			String fileName = "C:/project/"+ name + "'s information.txt";
			String fileNameOfBoxList = "C:/project/" + name + "'s goods.txt";
			
			value = 0;
			
			PrintWriter fileOut =
		            new PrintWriter(new FileWriter(fileName));
			
			
		    fileOut.println("����" +"_" + name + "\n"
		    		+"����" + "_" + code + "\n"
		    		+"����" + "_" + age + "\n"
		    		+"�Ա�" + "_" + sex + "\n"
		    		+"���" + "_" + height + "\n"
		    		+"����" + "_" + weight + "\n"
		    		+"���" + "_" + value );

		    fileOut.close();
		    
		    stdErr.println("ע��ɹ�");
		    
		    
		    File fileOfBoxList = new File(fileNameOfBoxList);
		    if(!fileOfBoxList.exists())
		    		fileOfBoxList.createNewFile();
		    	
		}catch (IOException e){
			stdErr.println(e);
		}
	}

}
