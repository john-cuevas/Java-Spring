package com.johncuevas.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johncuevas.dojosandninjas.models.Dojo;
import com.johncuevas.dojosandninjas.models.Ninja;
import com.johncuevas.dojosandninjas.repositories.DojoRepository;
import com.johncuevas.dojosandninjas.repositories.NinjaRepository;

@Service
public class MainService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
	@Autowired
	private DojoRepository dojoRepo;
	
//	CREATE DOJO
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
//	CREATE NINJA
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
//	FIND ALL
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();		
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();		
	}
	
//	FIND ONE
	public Dojo findOneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	
	public Ninja findOneNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
	

}
