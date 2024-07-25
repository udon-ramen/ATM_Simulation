package com.example.demo.Login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Login.entity.MyUser;
import com.example.demo.Login.repository.UserDaoImpl;

@Service
public class AccountUserDetailsService implements UserDetailsService {

	@Autowired
    private UserDaoImpl userDaoImpl;
	
    public UserDetails loadUserByUsername(String userName)
    	throws UsernameNotFoundException{
 
//    	System.out.println(parameter.getUserId());
    	System.out.println(userName);
    	
    	if(userName == null || "".equals(userName)) {
    		System.out.println("空");
    		throw new UsernameNotFoundException(userName + "is not found");
    	}
    	
    	try {
    		MyUser myUser = userDaoImpl.findUserByUserName(userName);
    		System.out.println(myUser);
    		System.out.println(userName);
    		
            if (myUser != null) {
                return new AccountUserDetails(myUser); // --- (2) UserDetailsの実装クラスを生成

            } else {
            	System.out.println("空");
                throw new UsernameNotFoundException(userName + "is not found");
            }
    	} catch(EmptyResultDataAccessException e) {
    		System.out.println(userName);
    		throw new UsernameNotFoundException(userName + "is not found");
    	}
        
    }
}
