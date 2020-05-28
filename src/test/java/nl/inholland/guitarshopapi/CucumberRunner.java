package nl.inholland.guitarshopapi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:",
    strict = true,
    plugin = {"pretty"}
)
public class CucumberRunner {
}
