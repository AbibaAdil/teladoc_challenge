package step_definitions;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utilities.Driver;
import utilities.PropertiesReader;

public class Hook {

	// this method is to set up a wait for page to be loaded before driver goes into
	// action
	@Before
    public void before() {
        Driver.getDriver().get(PropertiesReader.getProperty("URL"));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }
    @After
    public void tearDown(io.cucumber.java.Scenario scenario) {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot)
                        Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            }
            Driver.quitDriver();
        }
}
