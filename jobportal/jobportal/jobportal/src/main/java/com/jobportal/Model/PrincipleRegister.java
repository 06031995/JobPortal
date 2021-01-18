package com.jobportal.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="principle_register")
public class PrincipleRegister {

	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="principle_id")  
    private int principle_id;  
	


	public String getName() {
		return name;
	}

	public int getPrinciple_id() {
		return principle_id;
	}

	public void setPrinciple_id(int principle_id) {
		this.principle_id = principle_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	@Column(name="name")
	public String name;
	
	@Column(name="email")
	public String email;
	
	@Column(name="password")
	public String password;
	
	@Column(name="resetToken")
	public String resetToken;
}
