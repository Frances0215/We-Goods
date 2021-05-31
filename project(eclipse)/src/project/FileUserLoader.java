package project;

import java.io.*;
import java.util.*;

public class FileUserLoader {
	
	private User user;
	String name;
	String code;
	int age;
    String sex;
    float height;
    float weight;
    float value;
    
	public User loadUser(String fileName) throws FileNotFoundException, 
	IOException,
	DataFormatException{
		
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		
		String line = reader.readLine();
		
		while(line != null)
		{
			if(line.startsWith("姓名"))
				readName(line);
			else if(line.startsWith("年龄"))
				readAge(line);
			else if(line.startsWith("性别"))
				readSex(line);
			else if(line.startsWith("身高"))
				readHeight(line);
			else if(line.startsWith("体重"))
				readWeight(line);
			else if(line.startsWith("身价"))
				readValue(line);
			else if(line.startsWith("密码"))
				readCode(line);
			else
			{
				
				throw new DataFormatException(line);
			}
				
				
			line = reader.readLine();
		}
		
		reader.close();
		
		user = User.getSingletonInstance(name, code,age, sex, height, weight,value);
		return user;
	}
	
	public String readName(String line)throws DataFormatException
	{
		StringTokenizer tokenizer = new StringTokenizer(line,"_");
		
		if(tokenizer.countTokens() != 2)
			throw new DataFormatException(line);
		else{
			try{
				String prefix = tokenizer.nextToken();
				
				name = tokenizer.nextToken();
				
				return name;
			}catch(NumberFormatException nfe){
				throw new DataFormatException(line);
			}
		}
	}
	
	public int readAge(String line)throws DataFormatException
	{
		StringTokenizer tokenizer = new StringTokenizer(line,"_");
		
		if(tokenizer.countTokens() != 2)
			throw new DataFormatException(line);
		else{
			try{
				String prefix = tokenizer.nextToken();
				
				age = Integer.parseInt(tokenizer.nextToken());
				
				return age;
			}catch(NumberFormatException nfe){
				throw new DataFormatException(line);
			}
		}
	}
	
	public String readSex(String line)throws DataFormatException
	{
		StringTokenizer tokenizer = new StringTokenizer(line,"_");
		
		if(tokenizer.countTokens() != 2)
			throw new DataFormatException(line);
		else{
			try{
				String prefix = tokenizer.nextToken();
				
				sex = tokenizer.nextToken();
				
				return sex;
			}catch(NumberFormatException nfe){
				throw new DataFormatException(line);
			}
		}
	}
	
	public Float readHeight(String line)throws DataFormatException
	{
		StringTokenizer tokenizer = new StringTokenizer(line,"_");
		
		if(tokenizer.countTokens() != 2)
			throw new DataFormatException(line);
		else{
			try{
				String prefix = tokenizer.nextToken();
				
				height = Float.parseFloat(tokenizer.nextToken());
				
				return height;
			}catch(NumberFormatException nfe){
				throw new DataFormatException(line);
			}
		}
	}
	
	public Float readWeight(String line)throws DataFormatException
	{
		StringTokenizer tokenizer = new StringTokenizer(line,"_");
		
		if(tokenizer.countTokens() != 2)
			throw new DataFormatException(line);
		else{
			try{
				String prefix = tokenizer.nextToken();
				
				weight = Float.parseFloat(tokenizer.nextToken());
				
				return weight;
			}catch(NumberFormatException nfe){
				throw new DataFormatException(line);
			}
		}
	}
	
	public Float readValue(String line)throws DataFormatException
	{
		StringTokenizer tokenizer = new StringTokenizer(line,"_");
		
		if(tokenizer.countTokens() != 2)
			throw new DataFormatException(line);
		else{
			try{
				String prefix = tokenizer.nextToken();
				
				value = Float.parseFloat(tokenizer.nextToken());
				
				return value;
			}catch(NumberFormatException nfe){
				throw new DataFormatException(line);
			}
		}
	}
	
	public String readCode(String line)throws DataFormatException
	{
		StringTokenizer tokenizer = new StringTokenizer(line,"_");
		
		if(tokenizer.countTokens() != 2)
			throw new DataFormatException(line);
		else{
			try{
				String prefix = tokenizer.nextToken();
				
			code = tokenizer.nextToken();
				
				return code;
			}catch(NumberFormatException nfe){
				throw new DataFormatException(line);
			}
		}
	}
}
