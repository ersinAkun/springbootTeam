package com.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.domain.Worker;
import com.code.exception.ConflictException;
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

	
	
	
}
