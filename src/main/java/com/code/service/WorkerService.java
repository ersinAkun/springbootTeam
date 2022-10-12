package com.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.domain.Worker;
import com.code.exception.ConflictException;
import com.code.exception.ResourceNotFoundException;
import com.code.repository.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository workerRepository;
	
	
	
	
	public void createWorker(Worker worker) {
	if(workerRepository.existsByEmail(worker.getEmail())) {
		throw new ConflictException("Email is already exist");
	}
		workerRepository.save(worker);
	}


	public List<Worker> getAll() {
		return workerRepository.findAll();
		
	}


	public Worker findWorker(Long id) {
		return workerRepository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Worker not found with id :"+id));
		
	}


	public void deleteWorker(Long id) {
		Worker worker = findWorker(id);
		workerRepository.delete(worker);
		
	}

	
	
	
}
