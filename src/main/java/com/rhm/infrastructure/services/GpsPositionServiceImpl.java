package com.rhm.infrastructure.services;

import com.rhm.core.entities.GpsPosition;
import com.rhm.core.repositories.GpsPositionRepository;
import com.rhm.core.services.GpsPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GpsPositionServiceImpl implements GpsPositionService {

  @Autowired
  private GpsPositionRepository gpsPositionRepository;


  @Override
  public void save(GpsPosition gpsPosition) {
    gpsPositionRepository.save(gpsPosition);
  }

  @Override
  public List<GpsPosition> findAll() {
    return gpsPositionRepository.findAll();
  }

  @Override
  public GpsPosition findOne(long id) {
    return gpsPositionRepository.findOne(id);
  }
}
