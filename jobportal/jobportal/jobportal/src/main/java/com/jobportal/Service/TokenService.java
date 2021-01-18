package com.jobportal.Service;

public interface TokenService {

	long getTokenDetail(String email);

	Boolean updateToken(String email, String token, String string);

	void saveUserEmail(String email, int status);

	
}
