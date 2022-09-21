package com.johncuevas.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johncuevas.beltexam.models.Baby;

@Repository
public interface BabyRepository extends CrudRepository<Baby, Long> {
	List <Baby> findAll();

}
