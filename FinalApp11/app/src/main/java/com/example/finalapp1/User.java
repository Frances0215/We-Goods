package com.example.finalapp1;

public class User {
    private String name;
    private String code;
    private int age;
    private String sex;
    private float height;
    private float weight;
    private float value;
   
    private static User singletonInstance;

    static public User getSingletonInstance(String initialName, String initialCode, int initialAge,
                                            String initialSex, float initialHeight,
                                            float initialWeight, float initialValue) {
    	if(singletonInstance == null)
    	{
    		singletonInstance = new User(initialName,initialCode,initialAge,
    				initialSex,initialHeight,
    				initialWeight,initialValue);
    	}
    	return singletonInstance;
    }
    
    private User(String initialName,String initialCode,int initialAge,
    		String initialSex,float initialHeight,
    		float initialWeight,float initialValue){
    	name = initialName;
    	height = initialHeight;
    	weight = initialWeight;
    	age = initialAge;
    	sex = initialSex;
    	value = initialValue;
    }
    public String getName() {
    	return name;
    }
    public void setName(String newName){
    	name = newName;
    }

    public float getHeight(){
        return height;
    }

    public void setHeight(float newHeight){
        height = newHeight;
    }

    public float getWeight(){
        return weight;
    }

    public void setWeight(float newWeight){
        weight = newWeight;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int newAge){
        age = newAge;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String newSex){
        sex = newSex;
    }

    public float getValue() {
    	return value;
    }
    
    public void setValue(float newValue)
    {
    	value += newValue;
    }

}
