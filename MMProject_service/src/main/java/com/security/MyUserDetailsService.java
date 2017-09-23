package com.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entities.User;
import com.entities.UserAdmin;
import com.entities.UserRegistered;
import com.repositories.UserAdminRepository;
import com.repositories.UserRegisteredRepository;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {
  
    @Autowired
    private UserRegisteredRepository userRegisteredRepository;
    
    @Autowired
    private UserAdminRepository userAdminRepository;
    // 
    public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    	 	
        User user = userAdminRepository.findOneByUsername(username);
        
        if(user == null) {
        	user = userRegisteredRepository.findOneByUsername(username);
        }
        
        if(user == null) {
        	throw new UsernameNotFoundException(
                    "No user found with username: "+ username);
        }
        
    	boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
        return  new org.springframework.security.core.userdetails.User
  	          (user.getUsername(), 
  	        		  user.getPassword().toLowerCase(), enabled, accountNonExpired, 
  	          credentialsNonExpired, accountNonLocked, 
  	          getAuthorities(user.getRoles()));
    }
     
    private static List<GrantedAuthority> getAuthorities (ArrayList<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
