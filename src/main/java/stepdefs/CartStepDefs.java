package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;

public class CartStepDefs {
    CartPage cartPage = new CartPage();

@And("user checks if correct {string} is in cart")
    public void checkDeviceInTheCart(String phone){
    cartPage.checkDevice(phone);
}


    @And("user clicks place order button")
    public void userClickPlaceOrderButton() {
    cartPage.clickPlaceOrderButton();
    }

    @And("user enters the name {string}")
    public void userEntersTheName(String name) {
    cartPage.enterName(name);
    }

    @And("user enters the country {string}")
    public void userEntersTheCountry(String country) {
    cartPage.enterCountry(country);
    }

    @And("user enters city {string}")
    public void userEntersCity(String city) {
    cartPage.enterCity(city);
    }


    @And("user enters credit card {string}")
    public void userEntersCreditCard(String creditCard) {
    cartPage.enterCreditCard(creditCard);
    }

    @And("user enters month {string}")
    public void userEntersMonth(String month) {
    cartPage.enterMonth(month);
    }

    @And("user enters year {string}")
    public void userEntersYear(String year) {
    cartPage.enterYear(year);
    }

    @And("user click purchase button")
    public void userClickPurchaseButton() {
    cartPage.clickPurchase();
    }

    @Then("user should receive the order summary")
    public void userShouldReceiveTheOrderSummary() {
    cartPage.checkOrderSummary();
    }
}
