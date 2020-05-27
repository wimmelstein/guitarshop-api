package nl.inholland.guitarshopapi.controller;

import nl.inholland.guitarshopapi.model.Guitar;
import nl.inholland.guitarshopapi.model.SecurityUserDetails;
import nl.inholland.guitarshopapi.model.User;
import nl.inholland.guitarshopapi.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    System.out.println("User id: " +   getUserId());
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

  @RequestMapping(
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Guitar> createGuitar(@RequestBody Guitar guitar) {
    guitarService.addGuitar(guitar);
    return ResponseEntity.status(HttpStatus.CREATED).body(guitar);
  }

  @RequestMapping(
      value = "{id}/value",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getValueByGuitarId(@PathVariable long id) {
    int value = guitarService.valueByGuitarId(id);
    return ResponseEntity.status(HttpStatus.OK).body(value);
  }

  @RequestMapping(value="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = {"minprice"})
  public ResponseEntity getGuitarsByMinimumPrice(@RequestParam("minprice") double price) {
    return ResponseEntity.status(HttpStatus.OK).body(guitarService.getGuitarsByMinimumPrice(price));
  }

  private long getUserId() {
    Object bla = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User user = ((SecurityUserDetails) bla).getUser();
    return user.getId();
  }
}
