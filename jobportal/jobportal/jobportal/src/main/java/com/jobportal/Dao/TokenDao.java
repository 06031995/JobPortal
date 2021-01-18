package com.jobportal.Dao;

public interface TokenDao {

	long getTokenDetail(String email);
	Boolean updateToken(String email, String token, String string);

	void saveUserEmail(String email, int status);


}
