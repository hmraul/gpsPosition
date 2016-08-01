package com.rhm.core.entities;

public class GpsPosition {

  public GeoCoordinate getGeoCoordinate() {
    return geoCoordinate;
  }
  public String getUserId() {
    return userId;
  }
  public long getId() {
    return id;
  }

  private GeoCoordinate geoCoordinate;
  private String userId;
  private long id;

  public GpsPosition(long id, GeoCoordinate geoCoordinate, String userId) {
    this.id = id;
    this.geoCoordinate = geoCoordinate;
    this.userId = userId;
  }
}
