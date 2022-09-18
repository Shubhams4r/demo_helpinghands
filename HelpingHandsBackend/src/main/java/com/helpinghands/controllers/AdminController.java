package com.helpinghands.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpinghands.DTO.LoginDTO;
import com.helpinghands.response.LoginResponse;
import com.helpinghands.pojo.Admin;
import com.helpinghands.services.AdminService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired 
	private AdminService adminService;
	
	
	@PostMapping("/validate")
	@ApiOperation(value = "Validate the admin user")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Admin admin=adminService.validate(dto.getEmail(),dto.getPwd());
		if(admin!=null)
			return LoginResponse.success(admin);
		else
			return LoginResponse.status(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	@ApiOperation(value="Update the admin profile such as name and password")
	public ResponseEntity<?> updateProfile(@RequestBody Admin admin) {
		adminService.updateAdmin(admin);
		return LoginResponse.status(HttpStatus.OK);
	}
}
