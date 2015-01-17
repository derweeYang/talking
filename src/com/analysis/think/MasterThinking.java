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
	
	
/*	actor 是当前行为实施者，或对应每个事件的实施者。
	每个事件发生时都要相应更新actor。
	谁在做什么
	谁在想什么
	谁在看什么
	谁在听什么
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
		new Subject().isPerson("我", env);
		updCurrActor("A");// "我" link to "A"
		
		//handle verb
		//String res = new Verb().verPredicate("是");
		
		//
		String res = new ObjectSent().objPredicate("中国人");
		if("nationality".equals(res))
		{
			updActor("China");
		}
		
		//America
		new Subject().isPerson("我", env);
		System.out.println(env.getPers());
		updCurrActor("B");// "我" link to "B"

		String res1 = new ObjectSent().objPredicate("美国人");
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
		
		//A 说 我是中国人
		String str = "我是中国人。";
		//B 说 我是美国人
		String str1 ="我是美国人。";
		thk.thinking(str);
		thk.thinking(str1);
		

	}

}
