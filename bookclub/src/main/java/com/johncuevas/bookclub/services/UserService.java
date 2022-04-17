package com.johncuevas.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.johncuevas.bookclub.models.LoginUser;
import com.johncuevas.bookclub.models.User;
import com.johncuevas.bookclub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User register(User newUser, BindingResult result) {
//		Reject values or register if no errors
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());

//		1. Check if email is present in database
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "unique", "The email already exists.");
		}
//		2. Check if the password matches
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "matches", "The passwords do not match.");
		}
//		3. If result has errors, leave method without saving
		if (result.hasErrors()) {
			return null;
		}
//		4. Hash and set password, save user to the database
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}

	public User login(LoginUser newLogin, BindingResult result) {
//		1. Find user in database by email
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());

//		2. If email is not present, reject
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "unique", "Unknown email.");
			return null;
		}
//		3. Get user from database
		User user = potentialUser.get();

//		4. If Bcrypt password match fails, reject
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "matches", "The passwords do not match.");
		}

//		5. Return null if result has errors
		if (result.hasErrors()) {
			return null;
		}
		return user;
	}

}
