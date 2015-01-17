package com.analysis.think;

public class ObjectSent {
	
	//vshi 动词“是”
	public String objPredicate(String text)
	{
		String res = "";
		if("中国人".equals(text))
		{
			res = "nationality";
		}
		
		if("美国人".equals(text))
		{
			res = "nationality";
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
