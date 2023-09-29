package com.pradeep.rest.webservices.epasswebservices.mongoDB;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pradeep.rest.webservices.epasswebservices.pass.EPass;

public interface EpassRepository extends MongoRepository<EPass,String> {
	
	@Query(value = "{'mobileNo' : ?0}")
	public List<EPass> findByMobileNo(String mobileNo);

}
