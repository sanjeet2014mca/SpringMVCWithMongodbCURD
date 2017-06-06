package com.krypc.wb.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.krypc.wb.dao.entity.MessageStructure;

public interface MessageStructureRepository extends MongoRepository<MessageStructure, Long>{

}
