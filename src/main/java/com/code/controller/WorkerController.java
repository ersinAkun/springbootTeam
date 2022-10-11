package com.code.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.domain.Worker;
import com.code.service.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerController {

	@Autowired
	private WorkerService workerService;
	
	//create new workers
	@PostMapping
	public ResponseEntity<Map<String,String>>createWorker(@Valid @RequestBody Worker worker){
		//@Valid : parametreler valid mi kontrol eder. bu ornekte worker
				//  objesi olusturmak icin gonderilen fieldler yani,
				//  name gibi ozellikler duzgun set edilmis mi ona bakar.
		workerService.createWorker(worker);
		Map<String,String>map = new HashMap<>();
		map.put("message", "Worker is created successfully");
		map.put("status", "true");
		return new ResponseEntity<>(map,HttpStatus.CREATED);
	
	} 
	
	
}
