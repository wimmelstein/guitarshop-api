package nl.inholland.guitarshopapi.controller;

import nl.inholland.guitarshopapi.model.Guitar;
import nl.inholland.guitarshopapi.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("guitars")
public class GuitarController {

  @Autowired
  private GuitarService service;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getAllGuitars() {
    List<Guitar> guitars = service.getAllGuitars();
    return ResponseEntity
        .status(200)
        .body(guitars);
  }
}
