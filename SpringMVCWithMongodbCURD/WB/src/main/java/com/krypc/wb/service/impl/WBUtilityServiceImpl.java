package com.krypc.wb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.krypc.wb.dao.entity.MessageStructure;
import com.krypc.wb.dao.entity.Participant;
import com.krypc.wb.dao.entity.Party;
import com.krypc.wb.dao.entity.Program;
import com.krypc.wb.dao.entity.User;
import com.krypc.wb.dao.entity.UserTest;
import com.krypc.wb.dao.repository.WBRepository;
import com.krypc.wb.service.WBUtilityService;
import com.krypc.wb.utils.ResponseWrapper;

@Service("wbUtility")
public class WBUtilityServiceImpl implements WBUtilityService {

	/*@Autowired
	ProgramRepository programRepository;

	@Autowired
	ParticipantRepository participantRepository;

	@Autowired
	PartyRepository partyRepository;

	@Autowired
	WBValidationService wbValidation;*/

	@Autowired
	MongoOperations mongoOperations;

	@Autowired
	WBRepository wbRepository;

	public ResponseWrapper createProgram(String jsonData){
		ResponseWrapper wrapper = null;
		Program program = new Program();
		program = new Gson().fromJson(jsonData, Program.class);
		wrapper = wbRepository.upsertProgram(program);
		/*try {
			wrapper = new ResponseWrapper();

			Program result = programRepository.insert(program);
			wrapper.errorCode= result != null ? 0: 100;

		} catch (Exception e) {
			wrapper = new ResponseWrapper();
			wrapper.setErrorCode(100);
			wrapper.setErrorMessage(program.getProgramName()+": Duplicate Entry not Allowed");
			e.printStackTrace();
		}*/
		return wrapper;
	}


	@Override
	public ResponseWrapper createParticipant(String jsonString) {
		ResponseWrapper wrapper = null;
		Participant participant = new Participant();
		participant = new Gson().fromJson(jsonString, Participant.class);
		wrapper = wbRepository.upsertParticipant(participant);
		/*try {
			wrapper = new ResponseWrapper();
			if(wbValidation.isProgramExist(participant.getProgramName())){
				wrapper.errorCode = participantRepository.insert(participant) != null ? 0:101;
			}else{
				wrapper.errorCode = 101;
				wrapper.errorMessage = participant.getProgramName() + ": is not available";
			}

		} catch (Exception e) {
			wrapper = new ResponseWrapper();
			wrapper.errorCode = 102;
			wrapper.errorMessage = participant.getParticipantName() + ": Duplicate Entry not Allowed";
		}*/
		return wrapper;
	}

	@Override
	public ResponseWrapper createParty(String jsonString) {
		ResponseWrapper wrapper = null;
		Party party = new Party();
		party = new Gson().fromJson(jsonString, Party.class);
		wrapper = wbRepository.upsertParty(party);
		/*try {
			wrapper = new ResponseWrapper();
			if(wbValidation.isProgramExist(party.getProgram())){
				if(wbValidation.isProgramAndPartipantExist(party.getProgram(), party.getParticipantName())){
					wrapper.errorCode = partyRepository.insert(party) != null ? 0:104;
				}else{
					wrapper.errorCode = 104;
					wrapper.errorMessage = party.getProgram()+" and "+party.getParticipantName() + ": is not available";
				}
			}else{
				wrapper.errorCode = 103;
				wrapper.errorMessage = party.getProgram() + ": is not available";
			}


		} catch (Exception e) {
			wrapper = new ResponseWrapper();
			wrapper.errorCode = 105;
			wrapper.errorMessage = party.getPartyName() + ": Duplicate Entry not Allowed";
		}*/
		return wrapper;
	}

	@Override
	public ResponseWrapper createStructure(String jsonString) {
		ResponseWrapper wrapper = new ResponseWrapper();
		MessageStructure msgStructure = new MessageStructure();
		msgStructure = new Gson().fromJson(jsonString, MessageStructure.class);
		wrapper = wbRepository.upsertStructure(msgStructure);

		return wrapper;
	}

	@Override
	public ResponseWrapper createUser(String jsonString) {
		ResponseWrapper wrapper = new ResponseWrapper();
		User user=new User();
		user = new Gson().fromJson(jsonString, User.class);
		wrapper = wbRepository.upsertUser(user);

		return wrapper;
	}


	@Override
	public ResponseWrapper updateUser(String jsonString) {
		ResponseWrapper wrapper = new ResponseWrapper();
		User user=new User();
		user = new Gson().fromJson(jsonString, User.class);
		wrapper = wbRepository.upsertUserUpdate(user);

		return wrapper;
	}


	@Override
	public ResponseWrapper createUserTest(String jsonString) {
		ResponseWrapper wrapper = new ResponseWrapper();
		UserTest user=new UserTest();
		user = new Gson().fromJson(jsonString, UserTest.class);
		wrapper = wbRepository.upsertUserTest(user);
		return wrapper;
	}


	@Override
	public ResponseWrapper updateUserTest(String jsonString) {
		ResponseWrapper wrapper = new ResponseWrapper();
		UserTest user=new UserTest();
		user = new Gson().fromJson(jsonString, UserTest.class);
		wrapper = wbRepository.upsertUserUpdateTest(user);

		return wrapper;
	}


	@Override
	public ResponseWrapper removeUserTest(String jsonString) {
		ResponseWrapper wrapper = new ResponseWrapper();
		UserTest user=new UserTest();
		user = new Gson().fromJson(jsonString, UserTest.class);
		wrapper = wbRepository.removetUserUpdateTest(user);
		return wrapper;
	}


	@Override
	public List<UserTest> findAllUserTest() {
		List<UserTest> user=new ArrayList<UserTest>();
		user = wbRepository.findAllUserTest();
		return user;
	}

}
