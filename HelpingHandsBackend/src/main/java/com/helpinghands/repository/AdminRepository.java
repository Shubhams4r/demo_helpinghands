package com.helpinghands.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpinghands.pojo.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {

	
	
}
