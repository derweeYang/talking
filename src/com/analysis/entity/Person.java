package com.analysis.entity;

public class Person {
	private String personid;
	private String name;
	private String heigh;
	private String age;
	private String nationality;
	public String getPersonid() {
		return personid;
	}
	public void setPersonid(String personid) {
		this.personid = personid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeigh() {
		return heigh;
	}
	public void setHeigh(String heigh) {
		this.heigh = heigh;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((personid == null) ? 0 : personid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (personid == null) {
			if (other.personid != null)
				return false;
		} else if (!personid.equals(other.personid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [personid=" + personid + ", name=" + name + ", heigh="
				+ heigh + ", age=" + age + ", nationality=" + nationality + "]";
	}
	
	

}
