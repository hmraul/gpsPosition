package com.rhm.controllers;

import com.rhm.core.dto.GpsPositionRequest;
import com.rhm.core.entities.GeoCoordinate;
import com.rhm.core.entities.GpsPosition;
import com.rhm.core.repositories.GpsPositionRepository;
import com.rhm.core.services.GeoCoordinateService;
import com.rhm.core.services.GpsPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/positions")
public class Positions {


  @Autowired
  GeoCoordinateService geoCoordinateService;

  @Autowired
  GpsPositionService gpsPositionService;

  @PostConstruct
  public void init() {
    gpsPositionService.save(new GpsPosition(0.0, 0.0, 0.0, 0.0, 0, "rhm"));
    gpsPositionService.save(new GpsPosition(0.0, 0.1, 0.0, 0.0, 0, "rhm"));
    gpsPositionService.save(new GpsPosition(0.0, 0.2, 0.0, 0.0, 0, "rhm"));
    gpsPositionService.save(new GpsPosition(41.527506, 2.363573, 0.0, 0.0, 0, "rhm"));
    gpsPositionService.save(new GpsPosition(0.0, 0.0, 0.0, 0.0, 0, "user"));
    gpsPositionService.save(new GpsPosition(0.0, 0.11, 0.0, 0.0, 0, "user"));
    gpsPositionService.save(new GpsPosition(0.0, 0.19, 0.0, 0.0, 0, "user"));
    gpsPositionService.save(new GpsPosition(41.527129, 2.363100, 0.0, 0.0, 0, "user"));
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<GpsPosition> getPositions() {
    return gpsPositionService.findAll();
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
        request.getLatitude(),
        request.getLongitude(),
        request.getAltitude(),
        request.getSpeed(),
        request.getTime(),
        request.getUser()
    );

    gpsPositionService.save(gpsPosition);
    return gpsPosition;
  }

  @RequestMapping(value = "/bulk", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void createPositions(@RequestBody List<GpsPositionRequest> positions) {
    positions.forEach(gpsPositionRequest -> {
      GpsPosition gpsPosition = new GpsPosition(
          gpsPositionRequest.getLatitude(),
          gpsPositionRequest.getLongitude(),
          gpsPositionRequest.getAltitude(),
          gpsPositionRequest.getSpeed(),
          gpsPositionRequest.getTime(),
          gpsPositionRequest.getUser()
      );
      gpsPositionService.save(gpsPosition);
    });
  }



  private GpsPosition getGpsPosition(long id) {
//    return positions.stream().filter(p -> p.getId() == id).findFirst().get();

    return gpsPositionService.findOne(id);
  }
}
