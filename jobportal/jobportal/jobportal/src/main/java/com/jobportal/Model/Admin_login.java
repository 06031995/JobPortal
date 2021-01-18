package com.jobportal.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="admin_login")
public class Admin_login {

	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="login_id")  
    private int login_id;  
	
	@Column(name="email")
	public String email;
	
	@Column(name="password")
	public String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
