package com.rhm.controllers;

import com.rhm.core.dto.GpsPositionRequest;
import com.rhm.core.entities.GeoCoordinate;
import com.rhm.core.entities.GpsPosition;
import com.rhm.core.repositories.GpsPositionRepository;
import com.rhm.core.services.GeoCoordinateService;
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
  private GpsPositionRepository gpsPositionRepository;

//  private AtomicLong lastId = new AtomicLong();
//  List<GpsPosition> positions = new ArrayList<GpsPosition>() {{
//    add(new GpsPosition(0.0, 0.0, "rhm"));
//    add(new GpsPosition(0.0, 0.1, "rhm"));
//    add(new GpsPosition(0.0, 0.2, "rhm"));
//    add(new GpsPosition(41.527506, 2.363573, "rhm"));
//    add(new GpsPosition(0.0, 0.0, "user"));
//    add(new GpsPosition(0.0, 0.11, "user"));
//    add(new GpsPosition(0.0, 0.19, "user"));
//    add(new GpsPosition(41.527129, 2.363100, "user"));
//  }};

  @Autowired
  GeoCoordinateService geoCoordinateService;

  @PostConstruct
  public void init() {
    gpsPositionRepository.save(new GpsPosition(0.0, 0.0, "rhm"));
    gpsPositionRepository.save(new GpsPosition(0.0, 0.1, "rhm"));
    gpsPositionRepository.save(new GpsPosition(0.0, 0.2, "rhm"));
    gpsPositionRepository.save(new GpsPosition(41.527506, 2.363573, "rhm"));
    gpsPositionRepository.save(new GpsPosition(0.0, 0.0, "user"));
    gpsPositionRepository.save(new GpsPosition(0.0, 0.11, "user"));
    gpsPositionRepository.save(new GpsPosition(0.0, 0.19, "user"));
    gpsPositionRepository.save(new GpsPosition(41.527129, 2.363100, "user"));
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<GpsPosition> getPositions() {
    return gpsPositionRepository.findAll();
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
        request.getUser()
    );

    gpsPositionRepository.save(gpsPosition);
    return gpsPosition;
  }

  @RequestMapping(value = "/bulk", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void createPositions(@RequestBody List<GpsPositionRequest> positions) {
    positions.forEach(gpsPositionRequest -> {
      GpsPosition gpsPosition = new GpsPosition(
          gpsPositionRequest.getLatitude(),
          gpsPositionRequest.getLongitude(),
          gpsPositionRequest.getUser()
      );
      gpsPositionRepository.save(gpsPosition);
    });
  }



  private GpsPosition getGpsPosition(long id) {
//    return positions.stream().filter(p -> p.getId() == id).findFirst().get();

    return gpsPositionRepository.findOne(id);
  }
}
