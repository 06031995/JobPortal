package com.jobportal.Model;

import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity(name="capital")//person
public class Capital {
	
	
	@Id  
	 @GeneratedValue(strategy=GenerationType.AUTO)  
	    @Column(name="capital_id")  
	    private int capital;  
	
	 private Country country;
	
		public int getCapital() {
		return capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}
	@Access(AccessType.PROPERTY)
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="pDetail_FK")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCapital_Name() {
		return Capital_Name;
	}

	public void setCapital_Name(String capital_Name) {
		Capital_Name = capital_Name;
	}

	public String getCapital_Population() {
		return Capital_Population;
	}

	public void setCapital_Population(String capital_Population) {
		Capital_Population = capital_Population;
	}

		@Column(name="Capital_Name")
		public String Capital_Name;
		
		@Column(name="Capital_Population")
		public String Capital_Population;

		
		

}
