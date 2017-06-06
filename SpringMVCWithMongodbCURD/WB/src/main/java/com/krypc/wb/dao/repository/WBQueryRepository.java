package com.krypc.wb.dao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.krypc.wb.dao.entity.MessageStructure;
import com.krypc.wb.dao.entity.Participant;
import com.krypc.wb.dao.entity.Party;
import com.krypc.wb.dao.entity.Program;
import com.krypc.wb.dao.entity.User;

@Repository
public class WBQueryRepository {

	@Autowired
	MongoOperations mongoOperations;
	
	public boolean isProgramExist(String programName){
		return mongoOperations.exists(new Query().addCriteria(Criteria.where("programName").is(programName)), Program.class);
	}
	
	public boolean isParticipantExist(String participantName){
		return mongoOperations.exists(new Query().addCriteria(Criteria.where("participantName").is(participantName)), Participant.class);
	}
	
	public boolean isProgramAndParticipantExist(String programName, String participantName){
		return mongoOperations.exists(new Query().addCriteria(Criteria.where("participantName").is(participantName).and("programName").is(programName)), Participant.class);
	}
	
	public boolean isPartyExist(String partyName){
		return mongoOperations.exists(new Query().addCriteria(Criteria.where("partyName").is(partyName)), Party.class);
	}
	
	public boolean isProgramAndParticipantAndPartyNameExist(String programName, String participantName,String partyName){
		return mongoOperations.exists(new Query().addCriteria(Criteria.where("participantName").is(participantName).and("programName").is(programName).and("partyName").is(partyName)), Party.class);
	}
	
	public boolean isStructureExist(String programme,String processID){
		return mongoOperations.exists(new Query().addCriteria(Criteria.where("programe").is(programme).and("processID").is(processID)), MessageStructure.class);
	}
	
	public List<Program> getProgramListByUserID(String userID){
		List<Program> programList =mongoOperations.find(new Query().addCriteria(Criteria.where("owner").is(userID)), Program.class);
		return programList;
	}
	
	public MessageStructure getStructureByProgramAndProcessID(String programme,String processID){
		return mongoOperations.findOne(new Query().addCriteria(Criteria.where("programe").is(programme).and("processID").is(processID)), MessageStructure.class);
	}
	// for user
	public boolean isUserExist(String programme,String userEmailId){
		return mongoOperations.exists(new Query().addCriteria(Criteria.where("programe").is(programme).and("userEmailId").is(userEmailId)), User.class);
	}
	public User getUserDetailsByProgramAndUserEmail(String programme,String userEmailId){
		return mongoOperations.findOne(new Query().addCriteria(Criteria.where("programe").is(programme).and("userEmailId").is(userEmailId)), User.class);
	}
	
	/*//update
	public User updateUser(String userOldDetails,String userEmailId){
		
		
		
		return mongoOperations.findOne(new Query().addCriteria(Criteria.where("programe").is(programme).and("userEmailId").is(userEmailId)), User.class);
	}*/
	
	
	
	
}
