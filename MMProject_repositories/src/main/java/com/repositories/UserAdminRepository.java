package com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entities.UserAdmin;

@Repository
public interface UserAdminRepository extends CrudRepository<UserAdmin,Long>{
	UserAdmin findOneByUsername(String username);
	
}
