package nl.inholland.guitarshopapi.controller;

import nl.inholland.guitarshopapi.model.Brand;
import nl.inholland.guitarshopapi.model.Guitar;
import nl.inholland.guitarshopapi.service.GuitarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class GuitarControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private GuitarService service;

  @Test
  public void callingAllGuitarsShouldReturnOK() throws Exception {
    /*
    Removed the servlet context /api for testing
     */

    given(service.getAllGuitars()).willReturn(Arrays.asList(new Guitar(new Brand("fender"), "Stratocaster", 1299)));
    this.mvc.perform(get("/guitars"))
        .andExpect(status().isOk());
  }

}