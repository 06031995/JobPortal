package com.jobportal.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.Dao.StudentDao;
import com.jobportal.Model.AppliedJob;
import com.jobportal.Model.Create_vacancy;
import com.jobportal.Model.Student;
import com.jobportal.Service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	 @Transactional
	public int save_student(Student student) {
		return studentDao.save_student(student);
	}

	 
	 @Transactional
	public int getUserByEmailId(String email_id) {
		return studentDao.getUserByEmailId(email_id);
		
	}

	 @Transactional
	public List<Student> get_student(int student_id) {
		 return studentDao.get_student(student_id);
	}

	 @Transactional
	public int save_update_student(Student student) {
		 return studentDao.save_update_student(student);
	}

//	 @Transactional
//	public List<Create_vacancy> getVacancy(Create_vacancy cv) {
//		 return studentDao.getVacancy(cv);
//	}

	 @Transactional
	public List<Create_vacancy> getVacancy(String post, String location) {
		return studentDao.getVacancy(post,location);
	}


	 @Transactional
	public int save_Applied(AppliedJob applied_job) {
		return studentDao.save_Applied(applied_job);
	}

	 @Transactional
	public int getStudentId(int user_id) {
		 return studentDao.getStudentId(user_id);
		
	}

	 @Transactional
	public  String getCompanyName(int cv_id) {
		 return studentDao.getCompanyName(cv_id);
	}

	 @Transactional
	public int checkRegisterId(int register_id) {
		 return studentDao.checkRegisterId(register_id);
	}
	 
	 @Transactional
		public List<Create_vacancy>  getStudentAppliedJob(int student_id) {
			return studentDao.getStudentAppliedJob(student_id);
		}

}
