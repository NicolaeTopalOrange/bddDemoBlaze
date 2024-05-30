package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.IndexPage;

public class IndexStepDefs {

    IndexPage indexPage = new IndexPage();

    @When("user select phone category")
    public void clickPhoneCategoryButton() {
        indexPage.selectPhoneCategory();
    }


    @And("user selects {string} device")
    public void selectDevice(String phoneName) {
        indexPage.choosePhone(phoneName);
    }
}
