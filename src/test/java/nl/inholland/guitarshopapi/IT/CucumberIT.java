package nl.inholland.guitarshopapi.IT;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features",
    glue = "nl.inholland.guitarshopapi.IT.steps",
    plugin = "pretty",
    strict = true
)
public class CucumberIT {
}
