package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BenefitsPage {
    private WebDriver driver;

    public BenefitsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLinkByText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
