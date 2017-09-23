package com.repositories;

import org.springframework.stereotype.Repository;
import com.entities.UserRegistered;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRegisteredRepository extends CrudRepository<UserRegistered,Long>{
	UserRegistered findOneByUsername(String username);
	UserRegistered findByEmail(String email);
}

