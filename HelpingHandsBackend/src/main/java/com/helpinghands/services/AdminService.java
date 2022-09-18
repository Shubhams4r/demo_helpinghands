package com.helpinghands.services;

import com.helpinghands.pojo.Admin;

public interface AdminService {

	Admin validate(String email,String pwd);
	void updateAdmin(Admin admin);
	long countAdmin();
}
