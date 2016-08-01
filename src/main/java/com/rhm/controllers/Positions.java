package com.rhm.controllers;

import com.rhm.core.entities.GeoCoordinate;
import com.rhm.core.entities.GpsPosition;
import com.rhm.core.services.GeoCoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/positions")
public class Positions {

  List<GpsPosition> positions = new ArrayList<GpsPosition>() {{
    add(new GpsPosition(1, new GeoCoordinate(0.0, 0.0), "rhm"));
    add(new GpsPosition(2, new GeoCoordinate(0.0, 0.1), "rhm"));
    add(new GpsPosition(3, new GeoCoordinate(0.0, 0.2), "rhm"));
    add(new GpsPosition(4, new GeoCoordinate(0.0, 0.0), "user"));
    add(new GpsPosition(5, new GeoCoordinate(0.0, 0.11), "user"));
    add(new GpsPosition(6, new GeoCoordinate(0.0, 0.19), "user"));
  }};

  @Autowired
  GeoCoordinateService geoCoordinateService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<GpsPosition> getPositions() {
    return positions;
  }
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public GpsPosition getPosition(@PathVariable long id) {

    double distance = geoCoordinateService.calculateDistance(
        getGpsPosition(2).getGeoCoordinate(),
        getGpsPosition(1).getGeoCoordinate()
    );

    return getGpsPosition(id);
  }

  private GpsPosition getGpsPosition(long id) {
    return positions.stream().filter(p -> p.getId() == id).findFirst().get();
  }
}
