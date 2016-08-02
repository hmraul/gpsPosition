package com.rhm.core.dto;

public class GpsPositionRequest {
  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public String getUser() {
    return user;
  }

  double latitude;
  double longitude;
  String user;
}
