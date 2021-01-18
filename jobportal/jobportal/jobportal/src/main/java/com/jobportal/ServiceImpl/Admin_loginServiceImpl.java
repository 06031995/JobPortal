package com.jobportal.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.Dao.Admin_loginDao;
import com.jobportal.Dao.UserDao;
import com.jobportal.Model.Admin_login;
import com.jobportal.Model.AppliedJob;
import com.jobportal.Model.Create_vacancy;
import com.jobportal.Model.Student;
import com.jobportal.Service.Admin_loginService;

@Service("admin_loginservice")  
public class Admin_loginServiceImpl implements Admin_loginService{

	@Autowired
	private Admin_loginDao admin_loginDao;
	
	 @Transactional
	public int adminLogin(String email, String password) {
		return admin_loginDao.adminLogin(email,password);
	}

	 @Transactional
	public int adminSendOtp(Admin_login admin_login) {
		return admin_loginDao.adminSendOtp(admin_login);
	}

	 @Transactional
	public int adminNewPass(Admin_login admin_login) {
		return admin_loginDao.adminNewPass(admin_login);
	}

	 @Transactional
	public int create_vacancy(Create_vacancy create_Vacancy) {
		 return admin_loginDao.create_vacancy(create_Vacancy);
	}

	 
	 @Transactional
	public List<Create_vacancy> mng_vacancy() {
		return admin_loginDao.mng_vacancy();
	}
	
	 @Transactional
	public int delete_vacancy(int delete_id) {
		return admin_loginDao.delete_vacancy(delete_id);
	}

	 @Transactional
	public int update_vacancy(Create_vacancy create_Vacancy) {
		 return admin_loginDao.update_vacancy(create_Vacancy);
	}

	 @Transactional
	public long count_of_register() {
		 return admin_loginDao.count_of_register();
	}

	 @Transactional
	public long count_of_current_vacancy() {
		return admin_loginDao.count_of_current_vacancy();
	}

	 @Transactional
	public long count_of_appliedForJob() {
		return admin_loginDao.count_of_appliedForJob();
	}

	 @Transactional
	public long count_of_currentappliedForJob() {
		return admin_loginDao.count_of_currentappliedForJob();
	}

	 @Transactional
	public List<Create_vacancy> getCompanyList() {
		return admin_loginDao.getCompanyList();
	}
	 @Transactional
	public List<Student> getComWiseStudentData(String company_name) {
		return admin_loginDao.getComWiseStudentData(company_name);
		
	}

	

}
