package com.pradeep.rest.webservices.epasswebservices.pass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passenger {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String aadhar;
	private int age;
	
	public Passenger(String name, String aadhar, int age) {
		super();
		this.name = name;
		this.aadhar = aadhar;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

	

}
