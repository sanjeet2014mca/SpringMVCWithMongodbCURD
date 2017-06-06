package com.krypc.wb.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.krypc.wb.dao.entity.Participant;

public interface ParticipantRepository extends MongoRepository<Participant, Long>{

	@Query("{programName: ?0 ,participantName: ?1}")
	Participant findByProgramNameAndParticipantName(String programName, String participantName);

}

