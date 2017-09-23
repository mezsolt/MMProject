package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@DiscriminatorValue("UserRegistered")
public class UserRegistered extends User{	

	private String email;

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public void setUsername(String username) {
		super.setUsername(username);
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		super.setPassword(password);
	}

	@Override
	public ArrayList<String> getRoles() {
		return super.getRoles();
	}

	@Override
	public void setRoles(ArrayList<String> roles) {
		super.setRoles(roles);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public long getId() {
		return super.getId();
	}

	@Override
	public void setId(long id) {
		super.setId(id);
	}


}
