package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "guitars")
public class GuitarController {

    private GuitarService service;

    public GuitarController(GuitarService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guitar>> getGuitars() {
        return new ResponseEntity<>(service.getGuitars(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guitar> createGuitar(@RequestBody Guitar guitar) {
        service.addGuitar(guitar);
        return new ResponseEntity<>(guitar, HttpStatus.CREATED);
    }
}
