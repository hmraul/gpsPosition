package com.rhm.controllers;

import com.rhm.core.entities.GeoCoordinate;
import com.rhm.core.entities.GpsPosition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/positions")
public class Positions {

  List<GpsPosition> positions = new ArrayList<GpsPosition>();

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<GpsPosition> getPositions() {
    positions.add(new GpsPosition(1, new GeoCoordinate(0.0, 0.0), "user"));
    positions.add(new GpsPosition(2, new GeoCoordinate(0.0, 0.1), "user"));
    positions.add(new GpsPosition(3, new GeoCoordinate(0.0, 0.2), "user"));
    return positions;
  }
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public GpsPosition getPosition(@PathVariable long id) {
    return positions.parallelStream().filter(p -> p.getId() == id).findFirst().get();
  }
}
