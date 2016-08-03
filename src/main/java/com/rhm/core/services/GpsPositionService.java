package com.rhm.core.services;

import com.rhm.core.entities.GpsPosition;

import java.util.List;

public interface GpsPositionService {
  void save(GpsPosition gpsPosition);

  List<GpsPosition> findAll();

  GpsPosition findOne(long id);
}
