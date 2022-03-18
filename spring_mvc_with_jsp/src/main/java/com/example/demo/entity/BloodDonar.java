package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "vh_blood_donar")
@Component
public class BloodDonar {

	@Id // for primary key

	@Column(name = "mobilenumber") // for column name

	long mobileNumber;

	@Column(name = "firstname")
	@Length(min = 3, max = 8, message = "first name should be 3 to 8 character")
	String firstName;

	@Column(name = "bloodgroup")

	String bloodGroup;

	@Column(name = "datelastdonated")
	@PastOrPresent(message = "Donatation date should be earlier or todays date")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate dateLastDonated;

}
