package com.jobportal.Service;

import com.jobportal.Model.PrincipleRegister;
import com.jobportal.Model.UserRegister;

public interface UserService {

	int saveUserDetail(UserRegister userRegister);

	int saveLogin(String email, String password);

	int findUserByEmail(String email);

	int updateUserDetail(String token, int id);

	int newPass(UserRegister userRegister);

	int prinipleRegister(PrincipleRegister principleRegister);

	int savePrincipleLogin(String email, String password);

	int newPrinciplePass(PrincipleRegister principleRegister);

	int checkeuser(String email);

	


}
