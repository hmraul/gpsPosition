package com.rhm.infrastructure.services;

import com.rhm.core.entities.GeoCoordinate;
import com.rhm.core.services.GeoCoordinateService;

//@Service
public class GeoService implements GeoCoordinateService {
  @Override
  public double calculateDistance(GeoCoordinate source, GeoCoordinate destination) {
    long R = 6378137; // Earth’s mean radius in meter
    double latitudeDistance = toRadiant(destination.getLatitude() - source.getLatitude());
    double longitudeDistance = toRadiant(destination.getLongitude() - source.getLongitude());
    double a = Math.sin(latitudeDistance / 2) * Math.sin(latitudeDistance / 2) +
        Math.cos(toRadiant(source.getLatitude())) * Math.cos(toRadiant(destination.getLatitude())) *
            Math.sin(longitudeDistance / 2) * Math.sin(longitudeDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return R * c;

  }

  private double toRadiant(double value) {
    return value * Math.PI / 180;
  }

}
