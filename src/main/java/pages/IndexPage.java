package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class IndexPage {

    private final SelenideElement phoneCategory = $(By.xpath("//a[@class='list-group-item' and text()='Phones']"));
    private final ElementsCollection phoneNameLocator = $$(By.xpath("//a[@class='hrefch']"));

    public void selectPhoneCategory() {
        phoneCategory.should(Condition.appear);
        phoneCategory.should(Condition.clickable);
        phoneCategory.should(Condition.visible, Duration.ofSeconds(1));
        phoneCategory.click();

    }

    public void choosePhone(String phoneName) {
        Selenide.sleep(1000);
        for (SelenideElement element : phoneNameLocator) {
            if (element.getText().contains(phoneName)) {
                element.should(Condition.visible);
                element.should(Condition.clickable);
                element.click();
                break;
            }

        }

    }
}


