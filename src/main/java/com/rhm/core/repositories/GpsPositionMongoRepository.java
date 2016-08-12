package com.rhm.core.repositories;

import com.rhm.core.entities.GpsPosition;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GpsPositionMongoRepository extends MongoRepository<GpsPosition, Long> {
}
