package com.analysis.think;

public class ObjectSent {
	
	//vshi ���ʡ��ǡ�
	public String objPredicate(String text)
	{
		String res = "";
		if("�й���".equals(text))
		{
			res = "nationality";
		}
		
		if("������".equals(text))
		{
			res = "nationality";
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
