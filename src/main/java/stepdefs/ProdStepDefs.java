package stepdefs;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.ProdPage;

import static com.codeborne.selenide.Selenide.$;

public class ProdStepDefs {
    ProdPage prodPage = new ProdPage();


    @And("user should see the selected {string} page")
    public void checkDevice(String phoneName){
        prodPage.checkDevice(phoneName);

    }

    @And("user clicks add to cart")
    public void addToCart() {
        prodPage.clickAddToCart();
    }

    @Then("user should see an alert with {string} message")
    public void checkIfAlertTextIsCorrect(String message){
        prodPage.checkAlertMessage(message);
    }

    @And("user navigates to cart")
    public void userNavigatesToCart() {
        prodPage.clickCartButton();
    }


}
