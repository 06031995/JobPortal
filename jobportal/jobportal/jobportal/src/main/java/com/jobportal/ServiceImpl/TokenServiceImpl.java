package com.jobportal.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jobportal.Dao.TokenDao;
import com.jobportal.Service.TokenService;

public class TokenServiceImpl implements TokenService{

	@Autowired
	private TokenDao tokenDao;
	
	@Transactional
	public long getTokenDetail(String email) {
		return tokenDao.getTokenDetail(email);
	}

	@Transactional
	public Boolean updateToken(String email, String token, String string) {
		return tokenDao.updateToken(email, token, string);
		
	}

	@Transactional
	public void saveUserEmail(String email, int status) {
		tokenDao.saveUserEmail(email, status);
		
	}

}
