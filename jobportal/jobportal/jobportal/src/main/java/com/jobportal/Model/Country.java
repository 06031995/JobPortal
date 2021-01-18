package com.jobportal.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="country")
public class Country {
	
	
	@Id  
	 @GeneratedValue(strategy=GenerationType.AUTO)  
	    @Column(name="country_id")  
	    private int country_id;  
	
		@Column(name="country_name")
		public String country_name;
		
		@Column(name="countryPopulation")
		public String countryPopulation;

		@Column(name="detailId_PK")
		public int getCountry_id() {
			return country_id;
		}

		public void setCountry_id(int country_id) {
			this.country_id = country_id;
		}

		public String getCountry_name() {
			return country_name;
		}

		public void setCountry_name(String country_name) {
			this.country_name = country_name;
		}

		public String getCountryPopulation() {
			return countryPopulation;
		}

		public void setCountryPopulation(String countryPopulation) {
			this.countryPopulation = countryPopulation;
		}

		
		
		

}
