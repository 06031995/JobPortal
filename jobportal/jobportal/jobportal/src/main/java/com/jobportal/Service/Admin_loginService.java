package com.jobportal.Service;

import java.util.List;

import com.jobportal.Model.Admin_login;
import com.jobportal.Model.AppliedJob;
import com.jobportal.Model.Create_vacancy;
import com.jobportal.Model.Student;

public interface Admin_loginService {

	int adminLogin(String email, String password);

	int adminSendOtp(Admin_login admin_login);

	int adminNewPass(Admin_login admin_login);
	
	int create_vacancy(Create_vacancy create_Vacancy);

	List<Create_vacancy> mng_vacancy();

	int delete_vacancy(int delete_id);

	int update_vacancy(Create_vacancy create_Vacancy);

	long count_of_register();

	long count_of_current_vacancy();

	long count_of_appliedForJob();

	long count_of_currentappliedForJob();

	List<Create_vacancy> getCompanyList();

	List<Student> getComWiseStudentData(String company_name);


}
