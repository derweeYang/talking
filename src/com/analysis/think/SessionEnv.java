package com.analysis.think;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

import com.analysis.entity.Person;

public class SessionEnv {
	private Hashtable pers;
	private Integer curActor;//person identity
	private Integer receiver;
	private String time;
	private String place; 
	private int personCNT;
	
	
	public Integer getCurActor() {
		return curActor;
	}
	public void setCurActor(Integer curActor) {
		this.curActor = curActor;
	}

	public Integer getReceiver() {
		return receiver;
	}
	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}
	public Hashtable getPers() {
		return pers;
	}
	public void setPers(Hashtable pers) {
		this.pers = pers;
	}
	public int getPersonCNT() {
		return personCNT;
	}



	public void setPersonCNT(int personCNT) {
		this.personCNT = personCNT;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getPlace() {
		return place;
	}



	public void setPlace(String place) {
		this.place = place;
	}



	private Hashtable events;
	
	public void init()
	{
		if(pers == null)
		{
			pers = new Hashtable();
		}
		//how to init session env?
		Person per = new Person();
		per.setName("A");
		pers.put(per.hashCode(), per);
		//System.out.println("hashcode ="+per.hashCode());
		setPersonCNT(pers.size());
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		setTime(sdf.format(new Date()));
		setPlace("");
		
		
		System.out.println("Pls hold on. Init env......");
		
	}
	
	

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SessionEnv env = new SessionEnv();
        env.init();

        Hashtable ht = env.getPers();
        System.out.println(ht.toString());
        for(Iterator iter = ht.keySet().iterator();iter.hasNext();)
        {
        	Integer key = (Integer)iter.next();
        	Person per = (Person) ht.get(key);
        	System.out.println("key="+key + " value="+per.getName());
        }
        
	}

}
