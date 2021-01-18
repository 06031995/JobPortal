package com.jobportal.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.Dao.UserDao;
import com.jobportal.Model.PrincipleRegister;
import com.jobportal.Model.UserRegister;
import com.jobportal.Service.UserService;

@Service("userService")  
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
    @Transactional  
	public int saveUserDetail(UserRegister userRegister) {
		// TODO Auto-generated method stub
		return userDao.saveUserDetail(userRegister);
	}

    @Transactional
	public int saveLogin(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.saveLogin(email,password);
	}
    @Transactional  
	public int findUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}
    @Transactional  
	public int updateUserDetail(String token, int id) {
		return userDao.updateUserDetail(token,id);

	}
    @Transactional
	public int newPass(UserRegister userRegister) {
		
		return  userDao.newPass(userRegister);
	}

    @Transactional
	public int prinipleRegister(PrincipleRegister principleRegister) {
		return  userDao.prinipleRegister(principleRegister);
	}

    @Transactional
	public int savePrincipleLogin(String email, String password) {
		return  userDao.savePrincipleLogin(email,password);
	}

    @Transactional
	public int newPrinciplePass(PrincipleRegister principleRegister) {
		return  userDao.newPrinciplePass(principleRegister);
	}

    @Transactional
	public int checkeuser(String email) {
    	return  userDao.checkeuser(email);
	}

	



	
}
