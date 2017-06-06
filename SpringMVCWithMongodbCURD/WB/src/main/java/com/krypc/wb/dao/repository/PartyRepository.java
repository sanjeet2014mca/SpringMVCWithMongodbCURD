package com.krypc.wb.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.krypc.wb.dao.entity.Party;

public interface PartyRepository extends MongoRepository<Party, Long>{

}
