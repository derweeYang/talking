package com.analysis.think;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import com.analysis.entity.Person;

public class MasterThinking {

	
	private static SessionEnv env;
	private Integer person;

	static{
		if(env == null)
		{
			env = new SessionEnv();
			env.init();
		}	
			
	}
	
	public HashMap findPerson(String text)
	{
		HashMap hashs = new HashMap();
		Hashtable ht = env.getPers();
	    for(Iterator iter = ht.keySet().iterator();iter.hasNext();)
	    {
	        	Integer key = (Integer)iter.next();
	        	Person per = (Person) ht.get(key);
	        	if(per.getName().equals(text))
	        	{
	        		hashs.put(key, per);
	        		
	        	}
	     }
		
		
		return hashs;
	}
	
	public Integer findPersonKey(String text)
	{
        Integer id = 0;
		Hashtable ht = env.getPers();
	    for(Iterator iter = ht.keySet().iterator();iter.hasNext();)
	    {
	        	Integer key = (Integer)iter.next();
	        	Person per = (Person) ht.get(key);
	        	if(per.getName().equals(text))
	        	{
	        		id = key;
	        		
	        	}
	     }
		
		
		return id;
	}
	
	
/*	actor �ǵ�ǰ��Ϊʵʩ�ߣ����Ӧÿ���¼���ʵʩ�ߡ�
	ÿ���¼�����ʱ��Ҫ��Ӧ����actor��
	˭����ʲô
	˭����ʲô
	˭�ڿ�ʲô
	˭����ʲô
	*/
	public boolean updCurrActor(String text)
	{
		boolean flag = false;
		Integer id = findPersonKey(text);
		if(id > 0)
		{
			env.setCurActor(id);
	    	//System.out.println("update current actor:key="+id + " value="+per.getName());
	    	System.out.println("updCurrActor exists person:"+env.getCurActor());
		}
		else
		{
			Person per = new Person();
			per.setName(text);
			env.getPers().put(per.hashCode(), per);
			env.setCurActor(per.hashCode());
			//System.out.println("updCurrActor new person:"+env.getCurActor());
		}

		
		
		return flag;
	}
//update actor attribute value.	
	public boolean updActor(String res)
	{
		boolean flag = false;
		Person per = (Person)env.getPers().get(env.getCurActor());
		per.setNationality(res);
        flag = true;
        //System.out.println("updActor:"+per);
		return flag;
	}
	
	public String thinking(String str)
	{
		String result = "";
		new Subject().isPerson("��", env);
		updCurrActor("A");// "��" link to "A"
		
		//handle verb
		//String res = new Verb().verPredicate("��");
		
		//
		String res = new ObjectSent().objPredicate("�й���");
		if("nationality".equals(res))
		{
			updActor("China");
		}
		
		//America
		new Subject().isPerson("��", env);
		System.out.println(env.getPers());
		updCurrActor("B");// "��" link to "B"

		String res1 = new ObjectSent().objPredicate("������");
		if("nationality".equals(res1))
		{
			updActor("USA");
		}
		System.out.println(env.getPers());
		
		return result;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MasterThinking thk = new MasterThinking();
		
		//A ˵ �����й���
		String str = "�����й��ˡ�";
		//B ˵ ����������
		String str1 ="���������ˡ�";
		thk.thinking(str);
		thk.thinking(str1);
		

	}

}
