package nl.inholland.guitarshopapi.IT.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.inholland.guitarshopapi.model.Guitar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class StepDefinitions {

  RestTemplate template = new RestTemplate();
  ResponseEntity<String> responseEntity;
  String response;

  HttpHeaders headers = new HttpHeaders();
  String baseUrl = "http://localhost:8080/api/guitars";

  @When("I retrieve all guitars")
  public void iRetrieveAllGuitars() throws URISyntaxException {
    URI uri = new URI(baseUrl);
    HttpEntity<String> entity = new HttpEntity<>(null, headers);
    responseEntity = template.getForEntity(uri, String.class);
  }

  @Then("I get http status {int}")
  public void iGetHttpStatus(int status) {
    Assert.assertEquals(responseEntity.getStatusCodeValue(), status);
  }

  @Then("I get a list of {int} guitars")
  public void iGetAListOfGuitars(int size) throws JSONException {
    response = responseEntity.getBody();
    JSONArray array = new JSONArray(response);
    Assert.assertEquals(size, array.length());
  }

  @When("I retrieve guitar with id {int}")
  public void iRetrieveGuitarWithId(int id) throws URISyntaxException {
    URI uri = new URI(baseUrl + "/" + id);
    responseEntity = template.getForEntity(uri, String.class);
  }

  @Then("The guitar brand is {string}")
  public void theGuitarBrandIs(String brand) throws JSONException {
    response = responseEntity.getBody();
    Assert.assertEquals(brand,
        new JSONObject(response)
            .getString("brand"));
  }

  @When("I post a guitar")
  public void iPostAGuitar() throws JsonProcessingException, URISyntaxException {
    ObjectMapper mapper = new ObjectMapper();
    Guitar guitar = new Guitar("Gibson", "Flying V", 2599);
    URI uri = new URI(baseUrl);
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(guitar), headers);
    responseEntity = template.postForEntity(uri, entity, String.class);
  }
}
