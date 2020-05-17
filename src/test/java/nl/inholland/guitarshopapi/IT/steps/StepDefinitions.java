package nl.inholland.guitarshopapi.IT.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class StepDefinitions {

  RestTemplate template;
  ResponseEntity<String> responseEntity;
  String response;

  HttpHeaders headers = new HttpHeaders();
  String baseUrl = "http://localhost:8080/api/guitars";


  public StepDefinitions() throws URISyntaxException {}

//  @Given("^The guitar endpoint is available$")
//  public void isEndpointAvailable() {
//    template = new RestTemplate();
//    HttpEntity<String> entity = new HttpEntity<>(null, new HttpHeaders());
//    ResponseEntity<String> res = template.getForEntity(uri, String.class);
//    Assert.assertEquals(res.getStatusCodeValue(), 200);
//  }

  @When("I retrieve all guitars")
  public void iRetrieveAllGuitars() throws URISyntaxException {
    URI uri = new URI(baseUrl);
    HttpEntity<String> entity = new HttpEntity<>(null, headers);
    template = new RestTemplate();
    responseEntity = template.getForEntity(uri, String.class);
  }

//  @Then("^The guitar brand is {string}$")
//  public void theFirstGuitarBrandIs(String name) throws JSONException {
//    response = responseEntity.getBody();
//    Assert.assertEquals(name,
//        new JSONArray(response)
//            .getJSONObject(0)
//            .getString("brand"));
//  }

  @Then("I get a list of {int} guitars")
  public void iGetAListOfGuitars(int size) throws JSONException {
    response = responseEntity.getBody();
    JSONArray array = new JSONArray(response);
    Assert.assertEquals(size, array.length());
  }

  @Then("I get http status {int}")
  public void iGetHttpStatus(int status) {
    Assert.assertEquals(responseEntity.getStatusCodeValue(), status);
  }

  @When("I retrieve guitar with id {int}")
  public void iRetrieveGuitarWithId(int id) throws URISyntaxException {
    URI uri = new URI(baseUrl + "/" + id);
    HttpEntity<String> entity = new HttpEntity<>(null, headers);
    template = new RestTemplate();
    responseEntity = template.getForEntity(uri, String.class);
  }


  @Then("The guitar brand is {string}")
  public void theGuitarBrandIs(String brand) throws JSONException {
    response = responseEntity.getBody();
    Assert.assertEquals(brand,
        new JSONObject(response)
            .getString("brand"));
  }
}
