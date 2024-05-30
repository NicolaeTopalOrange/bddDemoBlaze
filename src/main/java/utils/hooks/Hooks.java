package utils.hooks;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.open;

public class Hooks {

    @Before
    public void setUp(){
        Configuration.browser = "edge";
        Configuration.baseUrl = "https://www.demoblaze.com/";
        open("/");
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        Thread.sleep(3000);
        if (scenario.isFailed()){
            // attach screenshot
            final byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
        WebDriverRunner.getWebDriver().quit();
    }
}
