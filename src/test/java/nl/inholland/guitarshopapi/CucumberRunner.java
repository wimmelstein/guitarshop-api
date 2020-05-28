package nl.inholland.guitarshopapi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:",
    plugin = {"pretty"}
)
public class CucumberRunner {
}
