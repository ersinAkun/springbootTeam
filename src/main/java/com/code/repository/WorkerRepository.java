package com.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.domain.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{
	boolean existsByEmail(String email);
	
}
