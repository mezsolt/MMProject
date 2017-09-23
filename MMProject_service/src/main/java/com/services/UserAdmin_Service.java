package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.entities.UserAdmin;

@Service
public interface UserAdmin_Service{
	UserAdmin findOneByUsername(String username);
	String messageFromAdminService();
	Iterable<UserAdmin> findAllUserAdmin();
	UserAdmin findOneUserAdmin(long id);
	void deleteOneUserAdmin(long id);
	void updateOneUserAdmin(long id,UserAdmin userAdmin);
	void saveUserAdmin(UserAdmin userAdmin);

	
}
