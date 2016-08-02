package com.rhm.core.repositories;

import com.rhm.core.entities.GeoCoordinate;

public interface GeoCoordinateRepository {
  void save(GeoCoordinate geoCoordinate);
}
