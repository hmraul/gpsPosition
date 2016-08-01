package com.rhm.core.entities;

public class Geocoordinateee {
  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  private double latitude;
  private double longitude;

  public Geocoordinateee(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
