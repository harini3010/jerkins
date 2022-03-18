package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BloodDonar;
import com.example.demo.repos.BloodDonarRepository;

import net.bytebuddy.asm.Advice.Local;

@Service
public class BloodDonarService {
	
	private BloodDonarRepository repo;

	
	@Autowired
	public BloodDonarService(BloodDonarRepository repo) {
		super();
		this.repo = repo;
	}

	public BloodDonar add(BloodDonar donar) {
		
		return this.repo.save(donar);
	}
	
	public List<BloodDonar> findAll(){
		
		return this.repo.findAll();
	}
	
	public void delete(long id) {
		
		this.repo.deleteById(id);
	}
	
	public BloodDonar update(BloodDonar donar) {
		
		return this.repo.save(donar);
	}
	
	public List<BloodDonar> findByBloodGroup(String srchGroup){
		
		return this.repo.findByBloodGroup(srchGroup);
	}
	
	public List<BloodDonar>findByFirstName(String srchName){
		return this.repo.findByFirstName(srchName);
		
	}
	public List<BloodDonar>FindByGroupAndLastDonatedDated(String group, LocalDate date){
		return this.repo.srchByGroupAndDate(group, date);
		
	}
	public int updateLastDonated(LocalDate date, long MobileNumber) {
		return this.repo.updateLastDonated(date, MobileNumber);
	}
	
}
