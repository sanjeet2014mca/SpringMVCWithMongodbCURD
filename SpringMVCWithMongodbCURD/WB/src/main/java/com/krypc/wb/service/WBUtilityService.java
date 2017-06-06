package com.krypc.wb.service;

import java.util.List;

import com.krypc.wb.dao.entity.UserTest;
import com.krypc.wb.utils.ResponseWrapper;

public interface WBUtilityService {

	public ResponseWrapper createProgram(String jsonData);

	public ResponseWrapper createParticipant(String jsonString);

	public ResponseWrapper createParty(String jsonString);

	public ResponseWrapper createStructure(String jsonString);

	public ResponseWrapper createUser(String jsonString);

	public ResponseWrapper updateUser(String jsonString);
	
	public ResponseWrapper createUserTest(String jsonString);

	public ResponseWrapper updateUserTest(String jsonString);
	
	public ResponseWrapper removeUserTest(String jsonString);
	
	public List<UserTest> findAllUserTest();
	
}
