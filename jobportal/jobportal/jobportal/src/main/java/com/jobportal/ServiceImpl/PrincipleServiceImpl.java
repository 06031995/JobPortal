package com.jobportal.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.Dao.Admin_loginDao;
import com.jobportal.Dao.PrincipleDao;
import com.jobportal.Model.Principle;
import com.jobportal.Service.PrincipleService;

@Service("principleService") 
public class PrincipleServiceImpl implements PrincipleService{

	@Autowired
	private PrincipleDao principleDao;

	 @Transactional
	public int savePrinciple(Principle principle) {
		
		return principleDao.savePrinciple(principle);
	}
	 @Transactional
	public long totalPrinciple() {
		return principleDao.totalPrinciple();
	}
	 
	 @Transactional
	public List<Principle> getprinciple_list() {
		return principleDao.getprinciple_list();
	}
	
}
