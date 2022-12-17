package com.nightcrew.petesalgos.services;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.nightcrew.petesalgos.models.LoginUser;
import com.nightcrew.petesalgos.models.User;
import com.nightcrew.petesalgos.repositories.UserRepository;


@Service
public class UserService {

    @Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		// TO-DO - Reject values: 
        // Reject if email is taken (present in database)
        // 1. Find user in the DB by email    
	   Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
	   
        // 2. if the email is present , reject
	   if(optionalUser.isPresent()) {
		   result.rejectValue("email", "unique", "This email is already registered!");
	   }
        // Reject if password doesn't match confirmation
	   if(!newUser.getPassword().equals(newUser.getConfirm())) {
		   result.rejectValue("password", "matches", "This confirm password does not match!");
	   }
	   
        // if result has errors, return 
	   if(result.hasErrors()) {
		   return null;
	   }
	   
        // Hash and set password, save user to database 
	   String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	   newUser.setPassword(hashed);
	   return userRepo.save(newUser);
	   
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
		// 2. if the email is present , reject
		 if(!optionalUser.isPresent()) {
			 result.rejectValue("email", "unique", "This email is already registered!");
			 return null;
	}
		 // 3.1 grab the user from potential user   
			User user = optionalUser.get();
			
	        // 3.2 if BCrypt password match fails
			if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			    result.rejectValue("password", "Matches", "Invalid Password!");
			}

	        // 4 if result has errors,return
			if(result.hasErrors()) {
				   return null;
			   }
			// Otherwise, return the user object
	    	return user;
		
        }

public User oneUser(Long id){
	Optional<User> optionalUser = userRepo.findById(id);
	if(optionalUser.isPresent()){
		return optionalUser.get();
	}
	else{
		return null;
	}
}

public Object getFavorites() {
	return null;
}




}
