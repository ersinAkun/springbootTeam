package com.code.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.domain.Worker;
import com.code.dto.WorkerDTO;
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
	
	//Get all worker
	@GetMapping
	public ResponseEntity<List<Worker>>getAll(){
		List<Worker>workers = workerService.getAll();
		return ResponseEntity.ok(workers);
	}
	
	//find worker by id\
	@GetMapping("/getById")
	public ResponseEntity<Worker>getWorker(@RequestParam("id")Long id)  {
		Worker worker = workerService.findWorker(id);
		return ResponseEntity.ok(worker);
	}
	
	//Delete Worker
	@DeleteMapping("/delete")
	public ResponseEntity<Map<String,String>> deleteWorker(@RequestParam("id")Long id){
		workerService.deleteWorker(id);
		Map<String,String> map = new HashMap<>();
		map.put("message", "Worker is deleted successfully");
		map.put("status", "true");
		return new ResponseEntity<>(map,HttpStatus.OK);
	}

	//Update Worker ,  DTO kullanilacak      
	@PutMapping("/{id}")      //..localhost:8080/workers/1   =>    //tek parametreli gelecegi icin pathvariable kullanabiliriz
	public ResponseEntity<Map<String,String>>updateWorker(@PathVariable("id") Long id, @RequestBody WorkerDTO workerDTO ){   //json olarak gelen requesti neye maplayecegiz
		workerService.updateWorker(id,workerDTO);															             // StudentDTO ya			
		
		Map<String,String> map = new HashMap<>();
		map.put("message", "Worker is updated successfully");
		map.put("status", "true");
		return new ResponseEntity<>(map,HttpStatus.OK);
		                                  
	}
	
	
	
	
	
	
	
	
}
