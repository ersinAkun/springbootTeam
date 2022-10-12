package com.code.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.code.domain.Worker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDTO {

	
	private Long id;
	
	@NotNull(message="first name can not be null")
	@NotBlank(message="last name can not be white space")
	@Size(min=2, max=25, message="First name '${validatedValue' must be between {min} and {max} long")
	private String firstName;
	
	private String lastName;
	
	private String department;
	
	private String phoneNumber;
	
	
	@Email(message="Provide valid email")//email in formatini kontrol ediyor xxx@yy.com
	private String email;
	
	private Integer salary;
	
	
	
	public WorkerDTO(Worker worker) {  //db den controller class ina geleceksem pojo geliyor bunu dto ya ceviriyoruz
		this.id = worker.getId();           //db. den controller a gidiyor
		this.firstName = worker.getName();
		this.lastName = worker.getLastName();
		this.department = worker.getDepartment();
		this.phoneNumber = worker.getPhoneNumber();
		this.email = worker.getEmail();
		this.salary = worker.getSalary();
		
	//db den response donuyor Repo dan pojo olarak service ye geliyor ve dto ya cevirmis oluyoruz
		
	}
	
	
	
}
