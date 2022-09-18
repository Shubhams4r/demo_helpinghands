package com.helpinghands.services;

import java.util.List;

import com.helpinghands.pojo.Donor;

public interface DonorService {
	void registerDonor(Donor donor);
	List<Donor> allDonor();
	Donor findById(int id);
	Donor validate(String email,String pwd);
	void deleteDonor(int id);

}
