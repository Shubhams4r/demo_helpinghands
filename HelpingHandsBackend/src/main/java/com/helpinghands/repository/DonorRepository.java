package com.helpinghands.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpinghands.pojo.Donor;

public interface DonorRepository extends JpaRepository<Donor,Integer> {
	
     Donor findByEmail(String email);
}
