package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class InsuranceCalculatorPage  extends BasePage {
    public InsuranceCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void selectStudentYeshiva() {
        driver.findElement(By.id("rblMStatus_3")).click(); // בחר "תלמיד ישיבה"
    }

    public void enterBirthDate(String birthDate) {
        WebElement birthDateField = driver.findElement(By.id("txtBirthDate"));
        birthDateField.clear();
        birthDateField.sendKeys(birthDate);
    }

    public void clickContinue() {
        driver.findElement(By.id("btnContinue")).click();
    }

    public void selectDisabilityNo() {
        driver.findElement(By.id("rblDisability_1")).click(); // "לא" בקצבת נכות
    }

    public String getNationalInsuranceAmount() {
        return driver.findElement(By.id("lblBitZl")).getText();
    }

    public String getHealthInsuranceAmount() {
        return driver.findElement(By.id("lblBriut")).getText();
    }

    public String getTotalAmount() {
        return driver.findElement(By.id("lblTotal")).getText();
    }


}
