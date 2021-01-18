package com.jobportal.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="applied_job")
public class AppliedJob {

	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="applied_job_id")  
    private int applied_job_id;  
	
	@Column(name="student_id")
	public int student_id;
	
	@Column(name="cv_id")
	public int cv_id;
	
	@Column(name="date")
	public String date;
	
	@Column(name="applied_active")
	public int applied_active;
	
	@Column(name="company_name")
	public String company_name;
	
	

	public int getApplied_job_id() {
		return applied_job_id;
	}

	public int getApplied_active() {
		return applied_active;
	}

	public void setApplied_active(int applied_active) {
		this.applied_active = applied_active;
	}

	public void setApplied_job_id(int applied_job_id) {
		this.applied_job_id = applied_job_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getCv_id() {
		return cv_id;
	}

	public void setCv_id(int cv_id) {
		this.cv_id = cv_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	
	
	
}
