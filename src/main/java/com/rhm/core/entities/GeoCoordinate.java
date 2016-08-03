package com.rhm.core.entities;

public class GeoCoordinate {
  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  private long id;
  private double latitude;
  private double longitude;

  public GeoCoordinate() {
    //used by spring.data
  }

  public GeoCoordinate(double latitude, double longitude) {
    super();
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
