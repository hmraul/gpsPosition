package com.rhm.core.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
public class GpsPosition {
//  public double getLongitude() {
//    return longitude;
//  }
//  public double getLatitude() {
//    return latitude;
//  }
//  public String getUserId() {
//    return userId;
//  }
  public long getId() {
    return id;
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
  public GeoCoordinate getGeoCoordinate() {
    return geoCoordinate;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @OneToOne(cascade = CascadeType.ALL)
  private GeoCoordinate geoCoordinate;
//  private double latitude;
//  private double longitude;
  private double altitude;
  private double speed;
  private long time;
  private String userId;
  private Date timestamp;

  public GpsPosition() {
    //USed by spring.data
  }

  public GpsPosition(
      GeoCoordinate geoCoordinate,
//      double latitude,
//      double longitude,
      double altitude,
      double speed,
      long time,
      String userId) {
    super();
    this.geoCoordinate = geoCoordinate;
//    this.latitude = latitude;
//    this.longitude = longitude;
    this.altitude = altitude;
    this.speed = speed;
    this.time = time;
    this.userId = userId;
    this.timestamp = Date.from(Instant.now());
  }
}
