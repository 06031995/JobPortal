package com.jobportal.Dao;

import java.util.List;

import com.jobportal.Model.Principle;

public interface PrincipleDao {

	int savePrinciple(Principle principle);
	
	long totalPrinciple();
	
	List<Principle> getprinciple_list();

}
