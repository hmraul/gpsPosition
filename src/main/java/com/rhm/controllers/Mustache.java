package com.rhm.controllers;

import com.rhm.core.entities.GpsPosition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Mustache {
  @RequestMapping("/list")
  public String getList(Model model) {
    //WTF!!! Just for testing
    Positions positionsController = new Positions();

    List<GpsPosition> positions = positionsController.getPositions();
    model.addAttribute("positions", positions);
    return "list_template";
  }
}
