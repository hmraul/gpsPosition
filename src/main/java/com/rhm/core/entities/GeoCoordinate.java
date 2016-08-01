package com.rhm.core.entities;

public class GeoCoordinate {
  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  private double latitude;
  private double longitude;

  public GeoCoordinate(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
