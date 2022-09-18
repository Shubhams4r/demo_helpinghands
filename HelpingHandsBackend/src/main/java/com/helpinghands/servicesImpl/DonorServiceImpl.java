package com.helpinghands.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.helpinghands.pojo.Donor;
import com.helpinghands.repository.DonorRepository;
import com.helpinghands.services.DonorService;

@Component
public class DonorServiceImpl implements DonorService {

	@Autowired private DonorRepository dao;
	
	@Override
	public void registerDonor(Donor donor) {
		// TODO Auto-generated method stub
	    dao.save(donor);
	    
	}

	@Override
	public List<Donor> allDonor() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Donor findById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public Donor validate(String email, String pwd) {
		// TODO Auto-generated method stub
		Donor donor=dao.findByEmail(email);
		if(donor!=null && donor.getPwd().equals(pwd))
		{
			return donor;
		}
		return null;
	}

	@Override
	public void deleteDonor(int id) {
		// TODO Auto-generated method stub
		Donor donor=dao.getById(id);
		dao.delete(donor);
	}

}
