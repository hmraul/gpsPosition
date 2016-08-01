package com.rhm.core.services;

import com.rhm.core.entities.Geocoordinateee;

public interface GeoCoordinateService {

  double calculateDistance(Geocoordinateee source, Geocoordinateee destination);
}
