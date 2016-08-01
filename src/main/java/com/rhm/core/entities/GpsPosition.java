package com.rhm.core.entities;

public class GpsPosition {

  public Geocoordinateee getGeocoordinateee() {
    return geocoordinateee;
  }
  public String getUserId() {
    return userId;
  }
  public long getId() {
    return id;
  }

  private Geocoordinateee geocoordinateee;
  private String userId;
  private long id;

  public GpsPosition(long id, Geocoordinateee geocoordinateee, String userId) {
    this.id = id;
    this.geocoordinateee = geocoordinateee;
    this.userId = userId;
  }
}
