package com.pradeep.rest.webservices.epasswebservices.fileUpload;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> { }

