package com.service_Impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.UserRegistered;
import com.repositories.UserRegisteredRepository;
import com.services.UserRegistered_Service;


@Service
public class UserRegistered_ServiceImpl implements UserRegistered_Service {	
	
	UserRegisteredRepository userRegisteredRepository;
	
	@Autowired
	public UserRegistered_ServiceImpl(UserRegisteredRepository userRegisteredRepository){
		this.userRegisteredRepository = userRegisteredRepository;
	}
	
	@Override
	public UserRegistered findByEmail(String email) {
		return userRegisteredRepository.findByEmail(email);
	}

	@Override
	public UserRegistered findOneByUsername(String username) {
		return userRegisteredRepository.findOneByUsername(username);
	}

	@Override
	public String messageFromRegisteredService() {
		return "registered message";
	}

	@Override
	public Iterable<UserRegistered> findAllUserRegistered() {
		return userRegisteredRepository.findAll();
	}

	@Override
	public UserRegistered findOneUserRegistered(long id) {
		return userRegisteredRepository.findOne(id);
	}

	@Override
	public void deleteOneUserRegistered(long id) {
		userRegisteredRepository.delete(id);
	}

	@Override
	public void updateOneUserRegistered(long id,UserRegistered userRegistered) {
		userRegisteredRepository.findOne(id).setUsername(userRegistered.getUsername());
		userRegisteredRepository.findOne(id).setPassword(userRegistered.getPassword());
		userRegisteredRepository.findOne(id).setRoles(userRegistered.getRoles());
		userRegisteredRepository.findOne(id).setEmail(userRegistered.getEmail());
		
		userRegisteredRepository.save(userRegisteredRepository.findOne(id));
	}

	@Override
	public void saveUserRegistered(UserRegistered userRegistered) {
		userRegisteredRepository.save(userRegistered);	
	}

	

}
