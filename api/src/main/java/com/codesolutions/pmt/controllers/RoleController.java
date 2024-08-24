package com.codesolutions.pmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.codesolutions.pmt.models.Role;
import com.codesolutions.pmt.services.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("roles")
	public List<Role> findAll() {
		return roleService.findAll();
	}
	
}
