package nl.inholland.guitarshopapi.controller;

import nl.inholland.guitarshopapi.model.Guitar;
import nl.inholland.guitarshopapi.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Component
@Path("guitars")
@Produces(MediaType.APPLICATION_JSON_VALUE)
public class GuitarController {

  @Autowired
  private GuitarService service;

  @GET
  public ResponseEntity getAllGuitars() {
    List<Guitar> guitars = service.getAllGuitars();
    return ResponseEntity
        .status(200)
        .body(guitars);
  }
}
