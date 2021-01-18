package com.jobportal.Model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="student")
public class Student {
	
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Student(int student_id, String f_name, String m_name, String l_name, String contact_no, String dob,
			String gender, String email_id, String address, String clg_name_10, String passing_yr_10, String percent_10,
			String clg_name_12, String passing_yr_12, String percent_12, String degree, String passing_yr_degree,
			String percent_degree, String last_org, String exp_years, String last_ctc, String notice_period,
			String key_skills, String projects, String certifications, String student_active, int user_id) {
		super();
		this.student_id = student_id;
		this.f_name = f_name;
		this.m_name = m_name;
		this.l_name = l_name;
		this.contact_no = contact_no;
		this.dob = dob;
		this.gender = gender;
		this.email_id = email_id;
		this.address = address;
		this.clg_name_10 = clg_name_10;
		this.passing_yr_10 = passing_yr_10;
		this.percent_10 = percent_10;
		this.clg_name_12 = clg_name_12;
		this.passing_yr_12 = passing_yr_12;
		this.percent_12 = percent_12;
		this.degree = degree;
		this.passing_yr_degree = passing_yr_degree;
		this.percent_degree = percent_degree;
		this.last_org = last_org;
		this.exp_years = exp_years;
		this.last_ctc = last_ctc;
		this.notice_period = notice_period;
		this.key_skills = key_skills;
		this.projects = projects;
		this.certifications = certifications;
		this.student_active = student_active;
		this.user_id = user_id;
	}


	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="student_id")  
    private int student_id;  
	
//	private UserRegister userRegister;
	
//	@Access(AccessType.PROPERTY)
//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name="user_id")
//	public UserRegister getUserRegister() {
//		return userRegister;
//	}

//	public void setUserRegister(UserRegister userRegister) {
//		this.userRegister = userRegister;
//	}

	@Column(name="f_name")
	public String f_name;
	
	@Column(name="m_name")
	public String m_name;
	
	@Column(name="l_name")
	public String l_name;
	
	@Column(name="contact_no")
	public String contact_no;
	
	@Column(name="dob")
	public String dob;
	
	@Column(name="gender")
	public String gender;
	
	@Column(name="email_id")
	public String email_id;
	
	@Column(name="address")
	public String address;
	
	@Column(name="clg_name_10")
	public String clg_name_10;
	
	@Column(name="passing_yr_10")
	public String passing_yr_10;
	

	@Column(name="percent_10")
	public String percent_10;
	
	@Column(name="clg_name_12")
	public String clg_name_12;
	
	@Column(name="passing_yr_12")
	public String passing_yr_12;
	
	@Column(name="percent_12")
	public String percent_12;
	
	@Column(name="degree")
	public String degree;
	
	@Column(name="passing_yr_degree")
	public String passing_yr_degree;
	
	@Column(name="percent_degree")
	public String percent_degree;
	
	@Column(name="last_org")
	public String last_org;

	@Column(name="exp_years")
	public String exp_years;
	
	@Column(name="last_ctc")
	public String last_ctc;
	
	@Column(name="notice_period")
	public String notice_period;
	
	@Column(name="key_skills")
	public String key_skills;
	
	@Column(name="projects")
	public String projects;
	
	@Column(name="certifications")
	public String certifications;
	
	
	@Column(name="student_active")
	public String student_active;
	
	@Column(name="user_id")
	public int user_id;
	
	

	

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getStudent_active() {
		return student_active;
	}

	public void setStudent_active(String student_active) {
		this.student_active = student_active;
	}

	//@Column(name="user_id")
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getClg_name_10() {
		return clg_name_10;
	}

	public void setClg_name_10(String clg_name_10) {
		this.clg_name_10 = clg_name_10;
	}


	public String getPassing_yr_10() {
		return passing_yr_10;
	}

	public void setPassing_yr_10(String passing_yr_10) {
		this.passing_yr_10 = passing_yr_10;
	}

	public String getPercent_10() {
		return percent_10;
	}

	public void setPercent_10(String percent_10) {
		this.percent_10 = percent_10;
	}

	public String getClg_name_12() {
		return clg_name_12;
	}

	public void setClg_name_12(String clg_name_12) {
		this.clg_name_12 = clg_name_12;
	}

	public String getPassing_yr_12() {
		return passing_yr_12;
	}

	public void setPassing_yr_12(String passing_yr_12) {
		this.passing_yr_12 = passing_yr_12;
	}

	public String getPercent_12() {
		return percent_12;
	}

	public void setPercent_12(String percent_12) {
		this.percent_12 = percent_12;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getPassing_yr_degree() {
		return passing_yr_degree;
	}

	public void setPassing_yr_degree(String passing_yr_degree) {
		this.passing_yr_degree = passing_yr_degree;
	}

	public String getPercent_degree() {
		return percent_degree;
	}

	public void setPercent_degree(String percent_degree) {
		this.percent_degree = percent_degree;
	}

	public String getLast_org() {
		return last_org;
	}

	public void setLast_org(String last_org) {
		this.last_org = last_org;
	}

	public String getExp_years() {
		return exp_years;
	}

	public void setExp_years(String exp_years) {
		this.exp_years = exp_years;
	}

	public String getLast_ctc() {
		return last_ctc;
	}

	public void setLast_ctc(String last_ctc) {
		this.last_ctc = last_ctc;
	}

	public String getNotice_period() {
		return notice_period;
	}

	public void setNotice_period(String notice_period) {
		this.notice_period = notice_period;
	}

	public String getKey_skills() {
		return key_skills;
	}

	public void setKey_skills(String key_skills) {
		this.key_skills = key_skills;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}

	public String getCertifications() {
		return certifications;
	}

	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
