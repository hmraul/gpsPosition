package com.rhm.infrastructure.repositories;

import com.rhm.core.entities.GeoCoordinate;
import com.rhm.core.repositories.GeoCoordinateRepository;
import org.springframework.stereotype.Service;

@Service
public class GeoRepository implements GeoCoordinateRepository{
  @Override
  public void save(GeoCoordinate geoCoordinate) {

  }
}
