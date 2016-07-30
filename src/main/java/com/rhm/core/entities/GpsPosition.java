package com.rhm.core.entities;

public class GpsPosition {

  public Geocoordinate getGeocoordinate() {
    return geocoordinate;
  }
  public String getUserId() {
    return userId;
  }
  public long getId() {
    return id;
  }

  private Geocoordinate geocoordinate;
  private String userId;
  private long id;

  public GpsPosition(long id, Geocoordinate geocoordinate, String userId) {
    this.id = id;
    this.geocoordinate = geocoordinate;
    this.userId = userId;
  }
}
