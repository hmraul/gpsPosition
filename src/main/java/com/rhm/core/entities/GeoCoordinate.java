package com.rhm.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GeoCoordinate {
  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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
