package com.example.demo.repos;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.BloodDonar;

@Repository
public interface BloodDonarRepository extends JpaRepository<BloodDonar, Long> {
	
	public List<BloodDonar> findByBloodGroup(String srchGroup);
	
	public List<BloodDonar> findByFirstName(String srchName);
	
	//here vh_blood_donar refers the table not java class
	// bloodgroup and datelastdonated  refers to the column not the fields in java
	
	@Query(value = "select * from vh_blood_donar where  bloodgroup = :group and datelastdonated=:date ", nativeQuery = true)
	
	public List<BloodDonar> srchByGroupAndDate(@Param ("group") String bloodGroup,@Param("date") LocalDate date);

	
	//using JPQL
	@Query(value = "update BloodDonar set dateLastDonated=:date where mobileNumber=:phoneNumber",nativeQuery=false)
	@Modifying
	@Transactional
	public int  updateLastDonated(@Param("date") LocalDate date, @Param("phoneNumber") long phoneNumber);
	
	
}
