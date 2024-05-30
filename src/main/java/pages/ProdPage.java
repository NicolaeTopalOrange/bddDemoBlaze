package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class ProdPage {

    //Locator
    private final SelenideElement checkIfDeviceIsCorrect = $(By.xpath("//h2[@class='name']"));
    private final SelenideElement addToCartButtonLocator = $(By.xpath("//*[@href='#' and text()='Add to cart']"));
    private final SelenideElement cartButtonLocator = $(By.xpath("//a[@id='cartur']"));


    public void checkDevice(String phoneName) {
        checkIfDeviceIsCorrect.should(Condition.visible, Duration.ofSeconds(1));
        checkIfDeviceIsCorrect.should(Condition.exactText(phoneName));

    }

    public void clickAddToCart() {
        addToCartButtonLocator.should(Condition.appear);
        addToCartButtonLocator.should(Condition.visible);
        addToCartButtonLocator.click();
    }

    public void clickCartButton() {
        cartButtonLocator.should(Condition.appear);
        cartButtonLocator.should(Condition.visible);
        cartButtonLocator.should(Condition.clickable);
        cartButtonLocator.click();

    }

    public void checkAlertMessage(String message) {
        Selenide.sleep(1000);
        Alert alert = WebDriverRunner.getWebDriver().switchTo().alert();
        String alertMessage = alert.getText();
        Assert.isTrue(message.equals(alertMessage), "Alert message is not correct.");
        alert.accept();
    }

}
