package stepdefs;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;

public class BaseStepDefs {

    @When("open application")
    public void openApp(){
    }


    @And("Sleep {int}")
    public void sleep(int milliseconds) {
        Selenide.sleep(milliseconds);
    }

    @And("user waits till page is loaded")
    public void userWaitsTillPageIsLoaded() {
        Selenide.sleep(1000);
    }
}
