package com.jobportal.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="principle_profile")
public class Principle {

	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="principle_id")  
    private int principle_id;  
	
	@Column(name="principle_name")
	public String principle_name;
	
	@Column(name="principle_ph")
	public String principle_ph;
	
	@Column(name="college_name")
	public String college_name;
	
	@Column(name="college_code")
	public String college_code;
	
	public int getPrinciple_id() {
		return principle_id;
	}

	public void setPrinciple_id(int principle_id) {
		this.principle_id = principle_id;
	}

	public String getPrinciple_name() {
		return principle_name;
	}

	public void setPrinciple_name(String principle_name) {
		this.principle_name = principle_name;
	}

	public String getPrinciple_ph() {
		return principle_ph;
	}

	public void setPrinciple_ph(String principle_ph) {
		this.principle_ph = principle_ph;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getCollege_code() {
		return college_code;
	}

	public void setCollege_code(String college_code) {
		this.college_code = college_code;
	}

	public String getCollege_ph() {
		return college_ph;
	}

	public void setCollege_ph(String college_ph) {
		this.college_ph = college_ph;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="college_ph")
	public String college_ph;
	
	@Column(name="email")
	public String email;
	
	@Column(name="address")
	public String address;
}
