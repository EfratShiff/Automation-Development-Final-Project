//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import pageObject.BtlBasePage;
//import pageObject.InsuranceCalculatorPage;
//import pageObject.Menu;
//
//import java.time.Duration;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class InsuranceCalculatorTest {
//    private WebDriver driver;
//    private WebDriverWait wait;
//    private BtlBasePage basePage;
//
//    @BeforeEach
//    public void setUp() {
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://www.btl.gov.il/");
//        basePage = new BtlBasePage(driver);
//    }
//
////    @Test
////    public void testYeshivaStudentInsuranceCalculation() {
////        // שלב 1: ניווט בתפריט
////        basePage.choose(Menu.TopMenuEnum.PREMIUM);
////
////        // debug - הדפסת קישורים בתפריט
////        List<WebElement> links = driver.findElements(By.tagName("a"));
////        System.out.println("== קישורים בדף ==");
////        for (WebElement link : links) {
////            System.out.println("🔗 " + link.getText());
////        }
////
////        // ניסיון למצוא קישור לפי טקסט
////        boolean found = false;
////        for (WebElement link : links) {
////            if (link.getText().contains("דמי ביטוח לאומי")) {
////                link.click();
////                found = true;
////                break;
////            }
////        }
////
////        // fallback אם לא נמצא קישור — ניגש ישירות
////        if (!found) {
////            System.out.println("⚠️ לא נמצא קישור - מעבר ישיר לכתובת");
////            driver.get("https://www.btl.gov.il/benefits/Insurance/Pages/InsuranceAmountCalculation.aspx");
////        }
////
////        wait.until(ExpectedConditions.titleContains("דמי ביטוח לאומי"));
////
////        // שלב 2: כניסה למחשבון
////        try {
////            WebElement calcLink = wait.until(ExpectedConditions.elementToBeClickable(
////                    By.partialLinkText("מחשבון לחישוב דמי ביטוח")));
////            calcLink.click();
////        } catch (Exception e) {
////            System.out.println("⚠️ לא נמצא הקישור למחשבון - מעבר ישיר");
////            driver.get("https://www.btl.gov.il/benefits/Insurance/Pages/Calculator.aspx");
////        }
////
////        wait.until(ExpectedConditions.titleContains("חישוב דמי ביטוח עבור"));
////
////        // שלב 3: מילוי פרטים
////        InsuranceCalculatorPage calculatorPage = new InsuranceCalculatorPage(driver);
////        calculatorPage.selectStudentYeshiva();
////        calculatorPage.enterBirthDate("01/11/2006");
////        calculatorPage.clickContinue();
////
////        wait.until(ExpectedConditions.elementToBeClickable(By.id("rblDisability_1")));
////        calculatorPage.selectDisabilityNo();
////        calculatorPage.clickContinue();
////
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblTotal")));
////
////        // שלב 4: בדיקת סכומים
////        String bituachLeumi = calculatorPage.getNationalInsuranceAmount();
////        String briut = calculatorPage.getHealthInsuranceAmount();
////        String total = calculatorPage.getTotalAmount();
////
////        System.out.println("🧾 ביטוח לאומי: " + bituachLeumi);
////        System.out.println("🧾 בריאות: " + briut);
////        System.out.println("🧾 סך הכול: " + total);
////
////        assertEquals("43", bituachLeumi.trim(), "דמי ביטוח לאומי לא תואמים");
////        assertEquals("120.00", briut.trim(), "דמי ביטוח בריאות לא תואמים");
////        assertEquals("163", total.trim(), "סך הכל דמי ביטוח לא תואמים");
////    }
//
//    @Test
//    public void testYeshivaStudentInsuranceCalculation() {
//        // שלב 1: פתיחה ובחירה בתפריט "דמי ביטוח" > "דמי ביטוח לאומי"
//        basePage.choose(Menu.TopMenuEnum.PREMIUM); // זה אמור להיות התפריט העליון "דמי ביטוח"
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));
//
//        // נבחר ידנית מתוך הקישורים את זה שכתוב בו "דמי ביטוח לאומי"
////        List<WebElement> links = driver.findElements(By.tagName("a"));
////        boolean clicked = false;
////        for (WebElement link : links) {
////            if (link.getText().trim().equals("דמי ביטוח לאומי")) {
////                link.click();
////                clicked = true;
////                break;
////            }
////        }
////
////        if (!clicked) {
////            System.out.println("⚠️ לא נמצא הקישור 'דמי ביטוח לאומי' - מעבר ישיר");
////            driver.get("https://www.btl.gov.il/benefits/Insurance/Pages/InsuranceAmountCalculation.aspx");
////        }
//
//        try {
//            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//*[@id=\"ctl00_Topmneu_Insurance\"]/ul/li[1]/a")));
//            link.click();
//        } catch (Exception e) {
//            System.out.println("⚠️ לא נמצא הקישור לפי XPath - מעבר ישיר");
//            driver.get("https://www.btl.gov.il/benefits/Insurance/Pages/InsuranceAmountCalculation.aspx");
//        }
//
//        wait.until(ExpectedConditions.titleContains("דמי ביטוח לאומי"));
//
//        // שלב 2: כניסה ללינק של המחשבון מתוך העמוד
//        try {
//            WebElement calcLink = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.partialLinkText("מחשבון לחישוב דמי ביטוח")));
//            calcLink.click();
//        } catch (Exception e) {
//            System.out.println("⚠️ לא נמצא הקישור למחשבון - מעבר ישיר");
//            driver.get("https://www.btl.gov.il/benefits/Insurance/Pages/Calculator.aspx");
//        }
//
//        wait.until(ExpectedConditions.titleContains("חישוב דמי ביטוח עבור"));
//
//        // שלב 3: מילוי פרטי תלמיד ישיבה
//        InsuranceCalculatorPage calculatorPage = new InsuranceCalculatorPage(driver);
//        calculatorPage.selectStudentYeshiva(); // בוחר ברדיו "תלמיד ישיבה"
//        calculatorPage.enterBirthDate("01/11/2006"); // תאריך דמה – לוודא מעל גיל 18
//        calculatorPage.clickContinue();
//
//        // שלב 4: שלב שני - מקבל קצבת נכות? -> לא
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("rblDisability_1")));
//        calculatorPage.selectDisabilityNo();
//        calculatorPage.clickContinue();
//
//        // שלב 5: תוצאות - סיום
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblTotal")));
//        String bituachLeumi = calculatorPage.getNationalInsuranceAmount();
//        String briut = calculatorPage.getHealthInsuranceAmount();
//        String total = calculatorPage.getTotalAmount();
//
//        System.out.println("🧾 ביטוח לאומי: " + bituachLeumi);
//        System.out.println("🧾 בריאות: " + briut);
//        System.out.println("🧾 סך הכול: " + total);
//
//        assertEquals("43", bituachLeumi.trim(), "דמי ביטוח לאומי לא תואמים");
//        assertEquals("120.00", briut.trim(), "דמי ביטוח בריאות לא תואמים");
//        assertEquals("163", total.trim(), "סך הכל דמי ביטוח לא תואמים");
//    }
//
//    @AfterEach
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
