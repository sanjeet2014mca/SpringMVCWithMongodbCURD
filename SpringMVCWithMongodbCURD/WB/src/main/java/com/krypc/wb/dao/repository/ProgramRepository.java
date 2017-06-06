package com.krypc.wb.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.krypc.wb.dao.entity.Program;

public interface ProgramRepository extends MongoRepository<Program, Long>{

	 @Query("{programName : ?0}")
	 Program findByProgramName(String programName);

}
