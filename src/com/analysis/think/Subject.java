package com.analysis.think;

public class Subject {
	
	//if it is a person, then judge if it is new or exists person
	public boolean isPerson(String text,SessionEnv sess)
	{
		boolean flag = false;
		if("Œ“".equals(text))
		{
			//simply treat actor as a person
			flag = true;
			System.out.println("Yes, It is a person");
			
		}
		
		return flag;
	}
	
	
	
	public boolean isNewPerson(String text)
	{
		boolean flag = false;
/*		if(true == isPerson(text))
		{
			
			
		}*/
		
		return flag;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

}
