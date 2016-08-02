package com.rhm.core.entities;

import java.time.Instant;
import java.util.Date;

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
  public Date getTimestamp() {return timestamp;}

  private GeoCoordinate geoCoordinate;
  private String userId;
  private long id;
  private Date timestamp;

  public GpsPosition(long id, GeoCoordinate geoCoordinate, String userId) {

    this.id = id;
    this.geoCoordinate = geoCoordinate;
    this.userId = userId;
    this.timestamp = Date.from(Instant.now());
  }
}
