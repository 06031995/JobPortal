package com.jobportal.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="token")
public class Token {

	
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="token_id")  
    private int token_id;  
	
	@Column(name="u_id" ,unique=true)
	private int u_id;
	
	public int getToken_id() {
		return token_id;
	}

	public void setToken_id(int token_id) {
		this.token_id = token_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	@Column(name="authenticationToken")  
    private String authenticationToken;  
      
    @Column(name="secretKey")  
    private String secretKey;  
      
    @Column(name="email_id")  
    private String email_id;  
}
