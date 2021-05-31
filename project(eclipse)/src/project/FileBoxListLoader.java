package project;

import java.io.*;
import java.util.*;
public class FileBoxListLoader {

	
    public Trouser readTrouser(String line)throws DataFormatException{
    	StringTokenizer tokenizer = new StringTokenizer(line,"_");
    	
		if(tokenizer.countTokens() != 10) {
		
			throw new DataFormatException(line);
		}
			
		else{
			try{
				Trouser trouser = new Trouser(tokenizer.nextToken(),
								tokenizer.nextToken(),
								tokenizer.nextToken(),
						        Double.parseDouble(tokenizer.nextToken()),
								tokenizer.nextToken(),
								Integer.parseInt(tokenizer.nextToken()),
								Integer.parseInt(tokenizer.nextToken()),
								tokenizer.nextToken(),
								tokenizer.nextToken(),
								tokenizer.nextToken());
				
				return trouser;
			}catch(NumberFormatException nfe){
				
				throw new DataFormatException(line);
			}
		}
    }

    public Food readFood(String line)throws DataFormatException{
    	StringTokenizer tokenizer = new StringTokenizer(line,"_");
		
		if(tokenizer.countTokens() != 7)
			throw new DataFormatException(line);
		else{
			try{
				Food food = new Food(tokenizer.nextToken(),
								tokenizer.nextToken(),
								tokenizer.nextToken(),
						        Double.parseDouble(tokenizer.nextToken()),
								tokenizer.nextToken(),
								Integer.parseInt(tokenizer.nextToken()),
								tokenizer.nextToken());
				
				return food;
			}catch(NumberFormatException nfe){
				throw new DataFormatException(line);
			}
		}
    }

    public Jacket readJacket(String line)throws DataFormatException{
    	StringTokenizer tokenizer = new StringTokenizer(line,"_");
		
		if(tokenizer.countTokens() != 10)
			throw new DataFormatException(line);
		else{
			try{
				
				Jacket jacket = new Jacket(tokenizer.nextToken(),
								tokenizer.nextToken(),
								tokenizer.nextToken(),
						        Double.parseDouble(tokenizer.nextToken()),
								tokenizer.nextToken(),
								Integer.parseInt(tokenizer.nextToken()),
								Integer.parseInt(tokenizer.nextToken()),
								tokenizer.nextToken(),
								tokenizer.nextToken(),
								tokenizer.nextToken());
				
				return jacket;
			}catch(NumberFormatException nfe){
				throw new DataFormatException(line);
			}
		}
    }

    public Bag readBag(String line)throws DataFormatException{
    	StringTokenizer tokenizer = new StringTokenizer(line,"_");
		
		if(tokenizer.countTokens() != 7)
			throw new DataFormatException(line);
		else{
			try{
				
				Bag bag = new Bag(tokenizer.nextToken(),
								tokenizer.nextToken(),
								tokenizer.nextToken(),
						        Double.parseDouble(tokenizer.nextToken()),
								tokenizer.nextToken(),
								tokenizer.nextToken(),
								tokenizer.nextToken());
				
				return bag;
			}catch(NumberFormatException nfe){
				throw new DataFormatException(line);
			}
		}
    }

    public Shoe readShoe(String line)throws DataFormatException{
    	StringTokenizer tokenizer = new StringTokenizer(line,"_");
		
		if(tokenizer.countTokens() != 10)
			throw new DataFormatException(line);
		else{
			try{
				
				Shoe shoe = new Shoe(tokenizer.nextToken(),
								tokenizer.nextToken(),
								tokenizer.nextToken(),
						        Double.parseDouble(tokenizer.nextToken()),
								tokenizer.nextToken(),
								Integer.parseInt(tokenizer.nextToken()),
								Integer.parseInt(tokenizer.nextToken()),
								tokenizer.nextToken(),
								tokenizer.nextToken(),
								Double.parseDouble(tokenizer.nextToken()));
				
				return shoe;
			}catch(NumberFormatException nfe){
				throw new DataFormatException(line);
			}
		}
    }

    public Other readOther(String line)throws DataFormatException{
    	
    	StringTokenizer tokenizer = new StringTokenizer(line,"_");
    	
		if(tokenizer.countTokens() != 6) {
			
			throw new DataFormatException(line);
		}
			
		else{
			try{
				
				Other other = new Other(tokenizer.nextToken(),
								tokenizer.nextToken(),
								tokenizer.nextToken(),
						        Double.parseDouble(tokenizer.nextToken()),
								tokenizer.nextToken(),
								tokenizer.nextToken());
			
				return other;
			}catch(NumberFormatException nfe){
				throw new DataFormatException(line);
			}
		}
    }

    

    public BoxList loadBoxList(String filename) throws FileNotFoundException, 
	IOException,
	DataFormatException{
    	BoxList boxList = new BoxList();
    	
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		
		String line = reader.readLine();
		
		while(line != null)
		{
			Good good = null;
			
			if(line.startsWith("T"))
			{
				good = readTrouser(line);
				boxList.getBox(1).addGood(good);
				boxList.getBox(1).addCapacity();
			}
			else if(line.startsWith("J")) {
				good = readJacket(line);
				boxList.getBox(2).addGood(good);
				boxList.getBox(2).addCapacity();
			}
			else if(line.startsWith("S")) {
				good = readShoe(line);
				boxList.getBox(3).addGood(good);
				boxList.getBox(3).addCapacity();
			}
			else if(line.startsWith("F")) {
				good = readFood(line);
				boxList.getBox(4).addGood(good);
				boxList.getBox(4).addCapacity();
			}
			else if(line.startsWith("B")) {
				good = readBag(line);
				boxList.getBox(5).addGood(good);
				boxList.getBox(5).addCapacity();
			}
			else if(line.startsWith("O")) {
				
				good = readOther(line);
				boxList.getBox(6).addGood(good);
				boxList.getBox(6).addCapacity();
			}
				
			line = reader.readLine();
		}
		
		reader.close();
		return boxList;
       
    }

}
