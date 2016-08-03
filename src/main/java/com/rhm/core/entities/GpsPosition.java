package com.rhm.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Entity
public class GpsPosition {

  public double getLongitude() {
    return longitude;
  }
  public double getLatitude() {
    return latitude;
  }
  public String getUserId() {
    return userId;
  }
  public long getId() {
    return id;
  }
  public Date getTimestamp() {
    return timestamp;
  }


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private double latitude;
  private double longitude;
  private String userId;
  private Date timestamp;

  public GpsPosition() {
    //USed by spring.data
  }

  public GpsPosition(double latitude, double longitude, String userId) {
    super();
    this.latitude = latitude;
    this.longitude = longitude;
    this.userId = userId;
    this.timestamp = Date.from(Instant.now());
  }
}
