package com.service_Impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.UserAdmin;
import com.repositories.UserAdminRepository;
import com.services.UserAdmin_Service;

@Service
public class UserAdmin_ServiceImpl implements UserAdmin_Service{

	UserAdminRepository userAdminRepository;
	
	@Autowired
	public UserAdmin_ServiceImpl(UserAdminRepository userAdminRepository){
		this.userAdminRepository = userAdminRepository;
	}

	@Override
	public UserAdmin findOneByUsername(String username) {
		return userAdminRepository.findOneByUsername(username);
	}

	@Override
	public String messageFromAdminService() {
		return "admin message";
	}

	@Override
	public Iterable<UserAdmin> findAllUserAdmin() {
		return userAdminRepository.findAll();
	}

	@Override
	public UserAdmin findOneUserAdmin(long id) {
		return userAdminRepository.findOne(id);
	}

	@Override
	public void deleteOneUserAdmin(long id) {
		userAdminRepository.delete(id);
	}

	@Override
	public void updateOneUserAdmin(long id, UserAdmin userAdmin) {
		userAdminRepository.findOne(id).setUsername(userAdmin.getUsername());
		userAdminRepository.findOne(id).setPassword(userAdmin.getPassword());
		userAdminRepository.findOne(id).setRoles(userAdmin.getRoles());
		
		userAdminRepository.save(userAdminRepository.findOne(id));
	}

	@Override
	public void saveUserAdmin(UserAdmin userAdmin) {
		userAdminRepository.save(userAdmin);
	}



}
