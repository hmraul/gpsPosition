package com.rhm.core.entities;

public class Geocoordinate {
  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  private double latitude;
  private double longitude;

  public Geocoordinate(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
