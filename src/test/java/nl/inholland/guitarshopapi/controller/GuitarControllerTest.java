package nl.inholland.guitarshopapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class GuitarControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void callingAllGuitarsShouldReturnOK() throws Exception {
    /*
    Removed the servlet context /api for testing
     */
    this.mvc.perform(get("/guitars"))
        .andExpect(status().isOk());
  }

}