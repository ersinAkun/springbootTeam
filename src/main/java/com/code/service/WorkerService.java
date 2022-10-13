package com.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.domain.Worker;
import com.code.dto.WorkerDTO;
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

  //UPDATE Worker, DTO 
	public void updateWorker(Long id, WorkerDTO workerDTO) {
		// DTO dan gelen email bnm repo mda var mi?
		
		boolean emailExist = workerRepository.existsByEmail(workerDTO.getEmail());  //boolean deger gelir => login olan kullanicinin forma girmis oldugu
														//yeni email adresini acaba DB ' mde var mi yokmu, yani daha once baskasi almis mi? 			
		
		Worker worker = findWorker(id);  //bnm sistemime giris yapan ve guncelleme yapmak isteyen kullanicinin 
		                                 //DB ' deki gercek bilgileri gelecek (worker objesinde db deki gercek bilgi geliyo)
		
		
		//email exist mi? ve anlik olarak gelen kullaniciy mi ait bunu kontrol ediyorum 
		if(emailExist && !workerDTO.getEmail().equals(worker.getEmail())) {  //unlem vardi kaldirdik !!!!!!
		//yeni e mail datada var mi && yeni diye girdigi email eski mi .. yeni diye eski mi girmeye calisiyo??	 
			throw new ConflictException("Email is already exist");
		}
		
		worker.setName(workerDTO.getFirstName());
		worker.setLastName(workerDTO.getLastName());
		worker.setDepartment(workerDTO.getDepartment());
		worker.setPhoneNumber(workerDTO.getPhoneNumber());
		worker.setEmail(workerDTO.getEmail());
		worker.setSalary(workerDTO.getSalary());
		
		workerRepository.save(worker);
	}

	
	
	
}
