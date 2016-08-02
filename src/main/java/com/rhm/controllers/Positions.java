package com.rhm.controllers;

import com.rhm.core.dto.GpsPositionRequest;
import com.rhm.core.entities.GeoCoordinate;
import com.rhm.core.entities.GpsPosition;
import com.rhm.core.services.GeoCoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/positions")
public class Positions {

  private AtomicLong lastId = new AtomicLong();
  List<GpsPosition> positions = new ArrayList<GpsPosition>() {{
    add(new GpsPosition(lastId.incrementAndGet(), new GeoCoordinate(0.0, 0.0), "rhm"));
    add(new GpsPosition(lastId.incrementAndGet(), new GeoCoordinate(0.0, 0.1), "rhm"));
    add(new GpsPosition(lastId.incrementAndGet(), new GeoCoordinate(0.0, 0.2), "rhm"));
    add(new GpsPosition(lastId.incrementAndGet(), new GeoCoordinate(41.527506, 2.363573), "rhm"));
    add(new GpsPosition(lastId.incrementAndGet(), new GeoCoordinate(0.0, 0.0), "user"));
    add(new GpsPosition(lastId.incrementAndGet(), new GeoCoordinate(0.0, 0.11), "user"));
    add(new GpsPosition(lastId.incrementAndGet(), new GeoCoordinate(0.0, 0.19), "user"));
    add(new GpsPosition(lastId.incrementAndGet(), new GeoCoordinate(41.527129, 2.363100), "user"));
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

//    double distance = geoCoordinateService.calculateDistance(
//        getGpsPosition(4).getGeoCoordinate(),
//        getGpsPosition(8).getGeoCoordinate()
//    );

    return getGpsPosition(id);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public GpsPosition createPosition(@RequestBody GpsPositionRequest request) {
    GpsPosition gpsPosition = new GpsPosition(
        lastId.incrementAndGet(),
        new GeoCoordinate(request.getLatitude(), request.getLongitude()),
        request.getUser()
    );

    positions.add(gpsPosition);
    return gpsPosition;
  }

  private GpsPosition getGpsPosition(long id) {
    return positions.stream().filter(p -> p.getId() == id).findFirst().get();
  }
}
