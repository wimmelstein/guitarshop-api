package nl.inholland.guitarshopapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.inholland.guitarshopapi.model.Guitar;
import nl.inholland.guitarshopapi.service.GuitarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class GuitarControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean private GuitarService service;
  private Guitar guitar;

  @BeforeEach
  public void setup() {
    guitar = new Guitar("Fender", "Cougar", 1899);
  }
  @Test
  public void getAllGuitarsShouldReturnJsonArray() throws Exception {
      given(service.getAllGuitars()).willReturn(Arrays.asList(guitar));
      this.mvc.perform(get("/guitars")).andExpect(
              status().isOk())
              .andExpect(jsonPath("$", hasSize(1)))
              .andExpect(jsonPath("$[0].brand").value(guitar.getBrand()));

  }
  @Test
  public void callingAllGuitarsShouldReturnOK() throws Exception {
    /*
    Removed the servlet context /api for testing
     */
    this.mvc.perform(get("/guitars"))
        .andExpect(status().isOk());
  }

  @Test
  public void postingAGuitarShouldReturn201Created() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Guitar guitar = new Guitar("Fender", "Cougar", 1899);
    this.mvc
        .perform(
            post("/guitars")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(guitar)))
        .andExpect(status().isCreated());
  }

}