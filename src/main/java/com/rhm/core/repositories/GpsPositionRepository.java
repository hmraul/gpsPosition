package com.rhm.core.repositories;

import com.rhm.core.entities.GpsPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpsPositionRepository extends JpaRepository<GpsPosition, Long>{
}
