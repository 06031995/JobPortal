package com.jobportal.Service;

import java.util.List;

import com.jobportal.Model.Principle;

public interface PrincipleService {

	int savePrinciple(Principle principle);

	long totalPrinciple();

	List<Principle> getprinciple_list();

}
