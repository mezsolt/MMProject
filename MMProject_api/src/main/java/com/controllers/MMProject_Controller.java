package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.UserAdmin;
import com.entities.UserRegistered;
import com.service_Impls.UserAdmin_ServiceImpl;
import com.service_Impls.UserRegistered_ServiceImpl;
import com.services.UserAdmin_Service;
import com.services.UserRegistered_Service;

@RestController
public class MMProject_Controller {
	
	private UserRegistered_Service userRegisteredServiceImpl;
	private UserAdmin_Service userAdminServiceImpl;
	
	@Autowired
	public MMProject_Controller(UserRegistered_ServiceImpl userRegisteredServiceImpl,UserAdmin_ServiceImpl userAdminServiceImpl) {
		this.userRegisteredServiceImpl = userRegisteredServiceImpl;
		this.userAdminServiceImpl = userAdminServiceImpl;
	}
	
	@RequestMapping("/registered")
	String messageRegistered() {
		return userRegisteredServiceImpl.messageFromRegisteredService();
	}
	
	@RequestMapping("/admin")
	String messageAdmin() {
		return userAdminServiceImpl.messageFromAdminService();
	}
	
	
	//UserRegistered
	@GetMapping(path="/registered/list/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	UserRegistered getOneUserRegistered(@PathVariable long id) {
		return userRegisteredServiceImpl.findOneUserRegistered(id);	
	}
	
	@GetMapping(path="/registered/listall",produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<UserRegistered> listAllUserRegistered() {
		return userRegisteredServiceImpl.findAllUserRegistered();	
	}
		
	@PostMapping(path="/registered/new",consumes=MediaType.APPLICATION_JSON_VALUE)
	void newUserRegistered(@RequestBody UserRegistered newUserRegistered) {
		userRegisteredServiceImpl.saveUserRegistered(newUserRegistered);
	}
		
	@PutMapping(path="/registered//update/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	void updateExistingUserRegistered(@PathVariable long id,@RequestBody UserRegistered userRegistered) {
		userRegisteredServiceImpl.updateOneUserRegistered(id, userRegistered);
	}
		
	@DeleteMapping(path="/registered/delete/{id}")
	void deleteUserRegistered(@PathVariable long id) {
		userRegisteredServiceImpl.deleteOneUserRegistered(id);
	}
	
	/////////////////
	
	//UserAdmin
	@GetMapping(path="/admin/list/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	UserAdmin getOneUserAdmin(@PathVariable long id) {
		return userAdminServiceImpl.findOneUserAdmin(id);	
	}
		
	@GetMapping(path="/admin/listall",produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<UserAdmin> listAllUserAdmin() {
		return userAdminServiceImpl.findAllUserAdmin();	
	}
			
	@PostMapping(path="/admin/new",consumes=MediaType.APPLICATION_JSON_VALUE)
	void newUserAdmin(@RequestBody UserAdmin newUserAdmin) {
		userAdminServiceImpl.saveUserAdmin(newUserAdmin);
	}
			
	@PutMapping(path="/admin//update/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	void updateExistingUserAdmin(@PathVariable long id,@RequestBody UserAdmin userAdmin) {
		userAdminServiceImpl.updateOneUserAdmin(id, userAdmin);
	}
			
	@DeleteMapping(path="/admin/delete/{id}")
	void deleteUserAdmin(@PathVariable long id) {
		userAdminServiceImpl.deleteOneUserAdmin(id);
	}
}
