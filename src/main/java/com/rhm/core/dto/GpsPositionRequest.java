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

  public double getAltitude() {
    return altitude;
  }

  public double getSpeed() {
    return speed;
  }

  public long getTime() {
    return time;
  }

  double latitude;
  double longitude;
  double altitude;
  double speed;
  long time;
  String user;
}
