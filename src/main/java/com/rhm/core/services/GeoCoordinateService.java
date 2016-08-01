package com.rhm.core.services;

import com.rhm.core.entities.GeoCoordinate;

public interface GeoCoordinateService {

  double calculateDistance(GeoCoordinate source, GeoCoordinate destination);
}
