package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entities.UserRegistered;

@Service
public interface UserRegistered_Service {
	UserRegistered findByEmail(String email);
	UserRegistered findOneByUsername(String username);
	String messageFromRegisteredService();
	Iterable<UserRegistered> findAllUserRegistered();
	UserRegistered findOneUserRegistered(long id);
	void deleteOneUserRegistered(long id);
	void updateOneUserRegistered(long id,UserRegistered userRegistered);
	void saveUserRegistered(UserRegistered userRegistered);
}
