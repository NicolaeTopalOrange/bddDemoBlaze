package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CartPage {

    //Locator
    private final ElementsCollection checkPhoneInCart = $$(By.xpath("//tr[@class='success']"));
    private final SelenideElement placeOrderButton = $(By.xpath("//button[@class=('btn btn-success')]"));
    private final SelenideElement nameField = $(By.xpath("//input[@id=('name')]"));
    private final SelenideElement countryField = $(By.xpath("//input[@id=('country')]"));
    private final SelenideElement cityField = $(By.xpath("//input[@id=('city')]"));
    private final SelenideElement creditCardField = $(By.xpath("//input[@id=('card')]"));
    private final SelenideElement monthField = $(By.xpath("//input[@id=('month')]"));
    private final SelenideElement yearField = $(By.xpath("//input[@id=('year')]"));
    private final SelenideElement purchaseButton = $(By.xpath("//button[@class='btn btn-primary' and text()='Purchase']"));
    private final SelenideElement orderCredentials = $(By.xpath("//p[@class='lead text-muted ']"));
    private final SelenideElement thanksForTheOrder = $(By.xpath("(//h2[normalize-space()='Thank you for your purchase!'])[1]"));


    public void checkDevice(String phone) {
        boolean isProductInTheCart = false;
        for (SelenideElement element : checkPhoneInCart) {
            if (element.getText().contains(phone)) {
                isProductInTheCart = true;
                break;
            }

        }

    }

    public void clickPlaceOrderButton() {
        placeOrderButton.should(Condition.appear);
        placeOrderButton.should(Condition.visible, Duration.ofSeconds(1));
        placeOrderButton.click();
    }

    public void enterName(String name){
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterCountry(String country){
        countryField.clear();
        countryField.sendKeys(country);
    }

    public void enterCity(String city){
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void enterCreditCard(String creditCard){
        creditCardField.clear();
        creditCardField.sendKeys(creditCard);
    }

    public void enterMonth(String month){
        monthField.clear();
        monthField.sendKeys(month);
    }

    public void enterYear(String year){
        yearField.clear();
        yearField.sendKeys(year);
    }

    public void clickPurchase(){
        purchaseButton.should(Condition.visible);
        purchaseButton.should(Condition.clickable);
        purchaseButton.click();
    }

    public void checkOrderSummary(){
        Assert.isTrue(orderCredentials.getText().contains("Card Number:"), "Summary is not visible");
        Assert.isTrue(thanksForTheOrder.getText().contains("Thank you for your purchase!"),"Site didn't say thank you");
    }
}
