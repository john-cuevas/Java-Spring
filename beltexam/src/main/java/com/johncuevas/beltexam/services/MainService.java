package com.johncuevas.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johncuevas.beltexam.models.Baby;
import com.johncuevas.beltexam.models.User;
import com.johncuevas.beltexam.repositories.BabyRepository;

@Service
public class MainService {
	
//	LINK BABY REPO
	@Autowired
	private BabyRepository babyRepo;
	
//	LINK USER SERVICE
	@Autowired
	private UserService userService;
	
//	FIND ALL BABY 
	public List<Baby> allBaby(){
		return babyRepo.findAll();
	}
	
//	FIND ONE BABY USING ID
	public Baby findOneBaby(Long id) {
		Optional <Baby> optionalBaby = babyRepo.findById(id);
		if(optionalBaby.isPresent()) {
			return optionalBaby.get();
		}
		else {
			return null;
		}
	}
	
//	CREATE BABY
	public Baby createBaby(Baby baby) {
		return babyRepo.save(baby);
	}
	
//	UPDATE BABY 
	public Baby updateBaby(Baby baby) {
		return babyRepo.save(baby);
	}
	
//	DELETE BABY USING ID
	public void deleteBaby(Long id) {
		babyRepo.deleteById(id);
	}
	
//	LIKE BABY
	public void likeBaby(Long babyId, Long userId) {
		
//		1. GET USER
		User user = userService.findOneUser(userId);
		
//		2. GET BABY
		Baby baby = this.findOneBaby(babyId);
		
//		3. ADD USER TO BABY
		baby.getLikedUsers().add(user);
		
//		4. SAVE
		babyRepo.save(baby);
		
	}
	
//	UNLIKE BABY
	public void unlikeBaby(Long babyId, Long userId) {
		
//		1. GET USER
		User user = userService.findOneUser(userId);
		
//		2. GET BABY
		Baby baby = this.findOneBaby(babyId);
		
//		3. REMOVE USER FROM BABY
		baby.getLikedUsers().remove(user);
		
//		4. SAVE
		babyRepo.save(baby);
		
	}
}
