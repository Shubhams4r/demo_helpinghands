package com.helpinghands.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpinghands.pojo.Admin;
import com.helpinghands.repository.AdminRepository;
import com.helpinghands.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService 
{
	@Autowired AdminRepository dao;

	@Override
	public Admin validate(String email, String pwd) {
		// TODO Auto-generated method stub
		Optional<Admin> admin=dao.findById(email);
		if(admin.isPresent() && admin.get().getPwd().equals(pwd)) {
			return admin.get();
		}
		return null;
	}

	@Override
	public void updateAdmin(Admin admin) {
		if(admin.getPwd().equals("") || admin.getPwd()==null) {
			admin.setPwd(dao.getById(admin.getEmail()).getPwd());
		}
		dao.save(admin);		
	}

	@Override
	public long countAdmin() {
		// TODO Auto-generated method stub
		return dao.count();
	}
}
