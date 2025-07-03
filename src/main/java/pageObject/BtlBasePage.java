package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class BtlBasePage extends BasePage{


    public BtlBasePage(WebDriver webDriver1) {
        super(webDriver1);
    }

public void choose(Menu.TopMenuEnum menuItem)
{
    List<WebElement> megaMenus = driver.findElements(By.cssSelector("ul.megamenu"));
    WebElement megaMenu = megaMenus.get(0);
    List<WebElement> links = megaMenu.findElements(By.tagName("a"));
    String wantedText = menuItem.getDisplayValue().trim();
    for (WebElement link : links) {
        String linkText = link.getText().trim();
        if (linkText.equals(wantedText)) {
            link.click();
            chooseSubItemBySubstring("אבטלה");
            return;
        }
    }

    throw new NoSuchElementException("לא נמצא פריט תפריט עם הטקסט: " + wantedText);
}
    public void chooseSubItemBySubstring(String partialText) {
        List<WebElement> allDivs = driver.findElements(By.tagName("div"));

        for (WebElement div : allDivs) {
            List<WebElement> links = div.findElements(By.tagName("a"));

            for (WebElement link : links) {
                String text = link.getText().trim();
                if (text.contains(partialText)) {
                    System.out.println("נמצא קישור: " + text);
                    link.click();
                    return;
                }
            }
        }

        throw new NoSuchElementException("לא נמצא קישור המכיל את הטקסט: " + partialText);
    }

    public void enterSearchText(String text) {
        WebElement searchInput = driver.findElement(By.id("TopQuestions"));
        searchInput.clear(); // נקה את השדה קודם
        searchInput.sendKeys(text);
        try {
            Thread.sleep(3000);// הכנס את הטקסט
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement searchButton = driver.findElement(By.className("SearchBtn"));
        searchButton.click();
    }
    public BasePage clickSnifim() {
        WebElement branchesButton = driver.findElement(By.className("snifim"));
        branchesButton.click();
        System.out.println(new BtlBasePage(driver));

        return new BasePage(driver) {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
    }
}


