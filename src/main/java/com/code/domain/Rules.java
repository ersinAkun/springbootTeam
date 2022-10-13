package com.code.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Rules {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@JsonProperty("ruleName")  //sadece json da gecerli
	private String name;
	
	
	@JsonIgnore   //stack over flow u onlemek
	@ManyToOne
	@JoinColumn(name="worker_id")
	private Worker worker;


	public void setId(Long id) {
		Id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	
	
	
	
	
	
	
}
