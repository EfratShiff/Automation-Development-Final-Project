import drivers.DriverManger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsuranceFlowFullTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        DriverManger.initDriver();
//        driver = new ChromeDriver();
        driver = DriverManger.getDriver();

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void fullInsuranceCalculationTest() throws InterruptedException{
        driver.get("https://www.btl.gov.il/");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ctl00_Topmneu_InsuranceHyperLink']")).click();


        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ctl00_Topmneu_Insurance']/ul/li[1]/a")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='mainContent']/div[1]/div[2]/span/div[2]/p[3]/a/strong")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_employeType_2']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_Gender_0']"))).click();

        WebElement birthDate = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id='ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_DynDatePicker_BirthDate_Date']")
        ));
        birthDate.clear();
        birthDate.sendKeys("1/11/2006");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_StartNavigationTemplateContainerID_StartNextButton']"))).click();

        WebElement stepTwoHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header']")));

//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_GetNechut_1\"]"))).click();

        WebElement radioBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id='ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_GetNechut_1']")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioBtn);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioBtn);


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_StepNavigationTemplateContainerID_StepNextButton\"]"))).click();

        WebElement finishHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header']")));

        String result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_div_Result']/ul/li[1]"))
        ).getText().trim();
        String result2 = driver.findElement(
                By.xpath("//*[@id='ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_div_Result']/ul/li[2]")
        ).getText().trim();
        String result3 = driver.findElement(
                By.xpath("//*[@id='ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_div_Result']/ul/li[3]")
        ).getText().trim();


        if (result1.contains("43")) {
            System.out.println("✔️ דמי ביטוח לאומי נכונים: 43 ש\"ח");
        }
        assertTrue(result1.contains("43"), "Expected 43 in ביטוח לאומי");

        if (result2.contains("120.00")) {
            System.out.println("✔️ דמי ביטוח בריאות נכונים: 120.00 ש\"ח");
        }
        assertTrue(result2.contains("120.00"), "Expected 120.00 in ביטוח בריאות");

        if (result3.contains("163")) {
            System.out.println("✔️ סך הכל נכון: 163 ש\"ח");
        }
        assertTrue(result3.contains("163"), "Expected 163 in סך הכל");
        }
        @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
