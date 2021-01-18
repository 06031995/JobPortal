package com.jobportal.Service;

import java.util.List;

import com.jobportal.Model.AppliedJob;
import com.jobportal.Model.Create_vacancy;
import com.jobportal.Model.Student;

public interface StudentService {

	int save_student(Student student);

	int getUserByEmailId(String email_id);

	List<Student> get_student(int student_id);

	int save_update_student(Student student);

	//List<Create_vacancy> getVacancy(Create_vacancy cv);

	List<Create_vacancy> getVacancy(String post, String location);

	int save_Applied(AppliedJob applied_job);

	int getStudentId(int user_id);

	String getCompanyName(int cv_id);

	int checkRegisterId(int register_id);

	List<Create_vacancy>  getStudentAppliedJob(int student_id);
	

}
