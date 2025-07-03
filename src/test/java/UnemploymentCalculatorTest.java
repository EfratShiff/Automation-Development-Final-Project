import drivers.DriverManger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnemploymentCalculatorTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        DriverManger.initDriver();
        driver = DriverManger.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void unemploymentCalculationFlow() throws InterruptedException {
        driver.get("https://www.btl.gov.il/");

        clickByXpath("//*[@id='ctl00_Topmneu_HyperLink3']");

        clickByXpath("//*[@id='ctl00_Topmneu_Benefits']/div/div[1]/div[5]/ul/li[1]/a");

        clickByXpath("//*[@id='mainContent']/div[1]/div[2]/span/div[2]/div[3]/a/strong");

        clickByXpath("//*[@id='ctl00_PlaceHolderMain_SiteNodesControl_ChildrensDiv']/ul/li[2]/a");

        WebElement piturimDateInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_DynDatePicker_PiturimDate_Date\"]")));
        piturimDateInput.clear();
        piturimDateInput.sendKeys("1/5/2025");

        clickByXpath("//*[@id=\"ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_rdb_age_1\"]");

        clickByXpath("//*[@id=\"ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_StartNavigationTemplateContainerID_StartNextButton\"]");

        String[] salaries = {"8000", "7500", "7000", "7200", "7400", "7600"};
        for (int i = 2; i <= 7; i++) {
            String xpath = String.format(
                    "//*[@id='ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_IncomeGrid_ctl0%d_Txt_Sallary']",
                    i
            );
            WebElement salaryInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            salaryInput.clear();
            salaryInput.sendKeys(salaries[i - 2]);
        }

            clickByXpath("//*[@id=\"ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_StepNavigationTemplateContainerID_StepNextButton\"]");

        WebElement resultTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_StepDiv3\"]/h3")));
        String titleText = resultTitle.getText().trim();
        printAssert(titleText, "תוצאות החישוב", "כותרת");

        checkResultLabel(1, "שכר יומי ממוצע לצורך חישוב דמי אבטלה:");
        checkResultLabel(2, "דמי אבטלה ליום:");
        checkResultLabel(3, "דמי אבטלה לחודש (לפי 25 ימים):");
    }

    private void clickByXpath(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    private void printAssert(String actual, String expected, String fieldName) {
        if (actual.equals(expected)) {
            System.out.println("✔️ " + fieldName + " תקינה: " + actual);
        } else {
            System.out.println("❌ " + fieldName + " לא תקינה. צפוי: " + expected + ", בפועל: " + actual);
        }
        assertEquals(expected, actual);
    }

    private void checkResultLabel(int liIndex, String expectedText) {
        String xpath = String.format(
                "//*[substring(@id, string-length(@id) - string-length('_StepDiv3') + 1) = '_StepDiv3']/div[3]/ul/li[%d]/label",
                liIndex);
        WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String actualText = label.getText().trim();
        printAssert(actualText, expectedText, "שורת תוצאה " + liIndex);
    }

    @AfterEach
    public void tearDown() {
        DriverManger.quitDriver();
    }
}
