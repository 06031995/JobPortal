package com.jobportal.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="create_vacancy")
public class Create_vacancy {
	
	public Create_vacancy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Create_vacancy(int cv_id, String post, String company_name, String year_of_exp, String vacancy,
			String location, String salary, String required_skill, String job_desc, String industry_type,
			String function_area, String role, String employment_type, String education, String website, String address,
			String created_date, String updated_date, String created_by, String cv_active) {
		super();
		this.cv_id = cv_id;
		this.post = post;
		this.company_name = company_name;
		this.year_of_exp = year_of_exp;
		this.vacancy = vacancy;
		this.location = location;
		this.salary = salary;
		this.required_skill = required_skill;
		this.job_desc = job_desc;
		this.industry_type = industry_type;
		this.function_area = function_area;
		this.role = role;
		this.employment_type = employment_type;
		this.education = education;
		this.website = website;
		this.address = address;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.created_by = created_by;
		this.cv_active = cv_active;
	}
	
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="cv_id")  
    private int cv_id;  
	
	@Column(name="post")
	public String post ;
	
	
	
	@Column(name="company_name")
	public String company_name;
	
	
	@Column(name="year_of_exp")
	public String year_of_exp ;
	
	@Column(name="vacancy")
	public String vacancy ;
	
	@Column(name="location")
	public String location;
	
	@Column(name="salary")
	public String salary;
	
	@Column(name="required_skill")
	public String required_skill;
	
	@Column(name="job_desc")
	public String job_desc;
	
	@Column(name="industry_type")
	public String industry_type;
	
	@Column(name="function_area")
	public String function_area;
	
	@Column(name="role")
	public String role;
	
	@Column(name="employment_type")
	public String employment_type;
	
	@Column(name="education")
	public String education;
	
	@Column(name="website")
	public String website;
	
	@Column(name="address")
	public String address;
	
	@Column(name="created_date")
	public String created_date;
	
	@Column(name="updated_date")
	public String updated_date;
	
	@Column(name="created_by")
	public String created_by;
	
	@Column(name="cv_active")
	public String cv_active;

	public int getCv_id() {
		return cv_id;
	}

	public void setCv_id(int cv_id) {
		this.cv_id = cv_id;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getYear_of_exp() {
		return year_of_exp;
	}

	public void setYear_of_exp(String year_of_exp) {
		this.year_of_exp = year_of_exp;
	}

	public String getVacancy() {
		return vacancy;
	}

	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getRequired_skill() {
		return required_skill;
	}

	public void setRequired_skill(String required_skill) {
		this.required_skill = required_skill;
	}

	public String getJob_desc() {
		return job_desc;
	}

	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}

	public String getIndustry_type() {
		return industry_type;
	}

	public void setIndustry_type(String industry_type) {
		this.industry_type = industry_type;
	}

	public String getFunction_area() {
		return function_area;
	}

	public void setFunction_area(String function_area) {
		this.function_area = function_area;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmployment_type() {
		return employment_type;
	}

	public void setEmployment_type(String employment_type) {
		this.employment_type = employment_type;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

//	public Date getCreated_date() {
//		return created_date;
//	}
//
//	public void setCreated_date(Date created_date) {
//		this.created_date = created_date;
//	}

//	public Date getUpdated_date() {
//		return updated_date;
//	}
//
//	public void setUpdated_date(Date updated_date) {
//		this.updated_date = updated_date;
//	}

	
	public String getCreated_by() {
		return created_by;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCv_active() {
		return cv_active;
	}

	public void setCv_active(String cv_active) {
		this.cv_active = cv_active;
	}
	
	
	
	
}
