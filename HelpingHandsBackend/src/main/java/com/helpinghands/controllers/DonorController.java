package com.helpinghands.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpinghands.DTO.LoginDTO;
import com.helpinghands.pojo.Donor;
import com.helpinghands.response.LoginResponse;
import com.helpinghands.services.DonorService;

@CrossOrigin
@RestController
@RequestMapping("/api/donor")
public class DonorController 
{
	@Autowired
	private DonorService donorService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Donor donor) {		
		try{
			donorService.registerDonor(donor);
		
		return LoginResponse.success(donor);
		}
		catch(Exception e) {
			return LoginResponse.error(donor);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> findAllCustomers() {
		List<Donor> result = donorService.allDonor();
		return LoginResponse.success(result);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findDonorProfile(@PathVariable("id") int id) {
		Donor result = donorService.findById(id);
		return LoginResponse.success(result);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteDonor(@PathVariable("id") int id) {
		donorService.deleteDonor(id);
		return LoginResponse.status(HttpStatus.OK);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Donor user=donorService.validate(dto.getEmail(),dto.getPwd());
		if(user!=null)
			return LoginResponse.success(user);
		else
			return LoginResponse.status(HttpStatus.NOT_FOUND);

	
	}
	
}
