package nl.inholland.guitarshopapi.controller;

import nl.inholland.guitarshopapi.model.Guitar;
import nl.inholland.guitarshopapi.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("guitars")
public class GuitarController {

  private GuitarService guitarService;

  public GuitarController(GuitarService guitarService) {
    this.guitarService = guitarService;
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getAllGuitars() {
    List<Guitar> guitars = guitarService.getAllGuitars();
    return ResponseEntity
        .status(200)
        .body(guitars);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getGuitarById(@PathVariable long id) {
    try {
      Guitar guitar = guitarService.getGuitarById(id);
      return ResponseEntity.status(HttpStatus.OK).body(guitar);
    } catch (IllegalArgumentException iae) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity createGuitar(@RequestBody Guitar guitar) {
    guitarService.addGuitar(guitar);
    return ResponseEntity.status(HttpStatus.CREATED).body(guitar.getId());
  }

  @RequestMapping(value = "/value/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getValueByGuitarId(@PathVariable long id) {
    int value = guitarService.valueByGuitarId(id);
    return ResponseEntity.status(HttpStatus.OK).body(value);
  }

  @RequestMapping(value="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = {"minprice"})
  public ResponseEntity getGuitarsByMinimumPrice(@RequestParam("minprice") double price) {
    return ResponseEntity.status(HttpStatus.OK).body(guitarService.getGuitarsByMinimumPrice(price));
  }
}
