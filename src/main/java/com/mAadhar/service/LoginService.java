package com.mAadhar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mAadhar.bean.Login;
import com.mAadhar.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	public String signIn(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					Login ll = result.get();
					if(ll.getPassword().equals(login.getPassword())) {		
						
				if(login.getTypeOfUser().equals(ll.getTypeOfUser()) && login.getTypeOfUser().equals("admin")) {
							return "Admin sucessfully login";
				}else if(login.getTypeOfUser().equals(ll.getTypeOfUser()) && login.getTypeOfUser().equals("user")){
							return "User successfully login";
						}else {
							return "Invalid details";
						}					
					}else {
						return "InValid password";
					}
		}else {
			return "InValid emailId";
		}		
	}
	public String signUp(Login login) {

		Optional<Login> result = loginRepository.findById(login.getEmailid());
	    if (result.isPresent()) {
	        return "Email Id already exists";
	    } else {
	
	            //minimum password length is 6 characters.
	            if (login.getPassword().length() < 6) {
	                return "Password should be at least 6 characters long.";
	            }

	            loginRepository.save(login);
	            return "Account created successfully";
	       
	    }
	}
}
