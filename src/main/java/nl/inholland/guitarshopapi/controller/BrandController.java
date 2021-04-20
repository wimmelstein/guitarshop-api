package nl.inholland.guitarshopapi.controller;

import nl.inholland.guitarshopapi.model.Brand;
import nl.inholland.guitarshopapi.model.Guitar;
import nl.inholland.guitarshopapi.service.BrandService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("brands")
public class BrandController {

    BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllBrands() {
        List<Brand> brands = brandService.getAllBrands();
        return ResponseEntity
                .status(200)
                .body(brands);
    }

}
