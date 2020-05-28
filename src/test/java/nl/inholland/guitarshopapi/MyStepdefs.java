package nl.inholland.guitarshopapi;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {

  public MyStepdefs() {
    System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chocolatey\\bin\\chromedriver.exe");
  }

  ChromeOptions options = new ChromeOptions().addArguments("--ignore-certificate-errors");
  private final WebDriver driver = new ChromeDriver(options);

  @Given("I visit the login page")
  public void iVisitTheLoginPage() {
    driver.get("https://localhost:8443/login.html");
  }

  @After()
  public void closeBrowser() {
    driver.quit();
  }

  @When("I enter the username {string}")
  public void iEnterTheUsername(String username) {
    WebElement userNameElement = driver.findElement(By.id("username"));
    userNameElement.sendKeys(username);
  }

  @And("I enter password {string}")
  public void iEnterPassword(String password) {
    WebElement passwordElement = driver.findElement(By.id("password"));
    passwordElement.sendKeys(password);
    passwordElement.submit();
  }

  @Then("The title of the new page is {string}")
  public void theTitleOfTheNewPageIs(String title) {
    driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    Assert.assertEquals(title, driver.getTitle());
  }

  @Then("The url contains {string}")
  public void theUrlContains(String queryParam) {
    driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    Assert.assertTrue(driver.getCurrentUrl().contains(queryParam));
  }
}
