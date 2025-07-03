package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver webDriver1)
    {
        this.driver = webDriver1;

        PageFactory.initElements(driver,this);

    }
}
