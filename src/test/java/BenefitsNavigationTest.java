////    //// src/test/java/tests/BenefitsNavigationTest.java
////    //
////    //
////    //import org.junit.jupiter.params.ParameterizedTest;
////    //import org.junit.jupiter.params.provider.CsvSource;
////    //import org.openqa.selenium.WebDriver;
////    //import org.openqa.selenium.chrome.ChromeDriver;
////    //import pageObject.BenefitsPage;
////    //
////    //import static org.junit.jupiter.api.Assertions.assertTrue;
////    //
////    //public class BenefitsNavigationTest {
////    //
////    //    @ParameterizedTest
////    //    @CsvSource({
////    //            "הבטחת הכנסה, income-support",
////    //            "נכות כללית, general-disability",
////    //            "ילד נכה, disabled-child",
////    //            "שארים, survivors",
////    //            "זקנה, old-age"
////    //    })
////    //    void testNavigationFromBenefitsPage(String linkText, String expectedUrlPart) {
////    //        WebDriver driver = new ChromeDriver();
////    //        driver.manage().window().maximize();
////    //
////    //        try {
////    //            driver.get("https://www.btl.gov.il/benefits");
////    //
////    //            BenefitsPage benefitsPage = new BenefitsPage(driver);
////    //            benefitsPage.clickLinkByText(linkText);
////    //
////    //            Thread.sleep(2000);
////    //
////    //            String currentUrl = driver.getCurrentUrl();
////    //            assertTrue(currentUrl.contains(expectedUrlPart), "URL should contain: " + expectedUrlPart);
////    //        } catch (Exception e) {
////    //            e.printStackTrace();
////    //        } finally {
////    //            driver.quit();
////    //        }
////    //    }
////    //}
////
////    // src/test/java/tests/BenefitsNavigationTest.java
////
////    import org.junit.jupiter.params.ParameterizedTest;
////    import org.junit.jupiter.params.provider.CsvSource;
////    import org.openqa.selenium.WebDriver;
////    import org.openqa.selenium.chrome.ChromeDriver;
////    import org.openqa.selenium.support.ui.WebDriverWait;
////    import org.openqa.selenium.support.ui.ExpectedConditions;
////    import org.openqa.selenium.By;
////    import pageObject.BenefitsPage;
////
////    import java.time.Duration;
////
////    import static org.junit.jupiter.api.Assertions.assertTrue;
////
////    public class BenefitsNavigationTest {
////
////        @ParameterizedTest
////        @CsvSource({
////                "הבטחת הכנסה, income-support",
////                "נכות כללית, general-disability",
////                "ילד נכה, disabled-child",
////                "שארים, survivors",
////                "זקנה, old-age"
////        })
////        void testNavigationFromBenefitsPage(String linkText, String expectedUrlPart) {
////            WebDriver driver = new ChromeDriver();
////            driver.manage().window().maximize();
////
////            try {
////                driver.get("https://www.btl.gov.il/benefits");
////
////                BenefitsPage benefitsPage = new BenefitsPage(driver);
////                benefitsPage.clickLinkByText(linkText);
////
////                // הגדרת WebDriverWait במקום Thread.sleep
////                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////                wait.until(ExpectedConditions.urlContains(expectedUrlPart));
////
////                String currentUrl = driver.getCurrentUrl();
////                assertTrue(currentUrl.contains(expectedUrlPart), "URL should contain: " + expectedUrlPart);
////            } catch (Exception e) {
////                e.printStackTrace();
////            } finally {
////                driver.quit();
////            }
////        }
////    }
//
//// src/test/java/tests/BenefitsNavigationTest.java
//
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.By;
//import pageObject.BenefitsPage;
//
//import java.time.Duration;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class BenefitsNavigationTest {
//
//    @ParameterizedTest
//    @CsvSource({
//            "הבטחת הכנסה, income-support",
//            "נכות כללית, general-disability",
//            "ילד נכה, disabled-child",
//            "שארים, survivors",
//            "זקנה, old-age"
//    })
//    void testNavigationFromBenefitsPage(String linkText, String expectedUrlPart) {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        System.out.println("🚀 התחלת בדיקה עבור: " + linkText);
//
//        try {
//            driver.get("https://www.btl.gov.il/benefits");
//            System.out.println("🔗 נפתח הדף הראשי");
//
//            BenefitsPage benefitsPage = new BenefitsPage(driver);
//            System.out.println("🔍 מנסה ללחוץ על הקישור: " + linkText);
//            benefitsPage.clickLinkByText(linkText);
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.urlContains(expectedUrlPart));
//
////            String currentUrl = driver.getCurrentUrl();
////            System.out.println("🌐 ה-URL לאחר לחיצה: " + currentUrl);
////
////            assertTrue(currentUrl.contains(expectedUrlPart),
////                    "❌ ה-URL לא מכיל את המחרוזת הצפויה: " + expectedUrlPart);
////            System.out.println("✅ עבר בהצלחה עבור: " + linkText);
//
//            String currentUrl = driver.getCurrentUrl();
//            System.out.println("🌐 ה-URL לאחר לחיצה: " + currentUrl);
//
//            assertTrue(currentUrl.toLowerCase().contains(expectedUrlPart.toLowerCase()),
//                    "❌ ה-URL לא מכיל את המחרוזת הצפויה: " + expectedUrlPart);
//            System.out.println("✅ עבר בהצלחה עבור: " + linkText);
//
//        } catch (AssertionError ae) {
//            System.out.println("❗️ בדיקה נכשלה עבור: " + linkText);
//            System.out.println("📛 שגיאה: " + ae.getMessage());
//            throw ae; // זורק מחדש כדי שה-JUnit יסמן כשגיאה
//        } catch (Exception e) {
//            System.out.println("💥 שגיאת מערכת: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            driver.quit();
//            System.out.println("🧹 הדפדפן נסגר\n");
//        }
//    }
//}

// src/test/java/tests/BenefitsNavigationTest.java

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.BenefitsPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BenefitsNavigationTest {

    @ParameterizedTest(name = "בודק ניווט עבור: {0} => כולל: {1}")
    @CsvSource({
            "הבטחת הכנסה, Income_support",
            "נכות כללית, Disability", // מותאם לשם אמיתי של URL
            "ילד נכה, Disabled_Child",
            "מענק לידה, maanakleda",
            "אמהות, maternity"
    })
    void testNavigationFromBenefitsPage(String linkText, String expectedUrlPart) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("🚀 התחלת בדיקה עבור: " + linkText);

        try {
            // שלב 1: ניווט לדף הראשי
            driver.get("https://www.btl.gov.il/benefits");
            System.out.println("🔗 נפתח הדף הראשי");

            // שלב 2: לחיצה על הקישור הרצוי
            BenefitsPage benefitsPage = new BenefitsPage(driver);
            System.out.println("🔍 מנסה ללחוץ על הקישור: " + linkText);
            benefitsPage.clickLinkByText(linkText);

            // שלב 3: המתנה לטעינה של כתובת URL חדשה
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains(expectedUrlPart));

            // שלב 4: בדיקת כתובת ה־URL
            String currentUrl = driver.getCurrentUrl();
            System.out.println("🌐 ה-URL לאחר לחיצה: " + currentUrl);

            assertTrue(
                    currentUrl.toLowerCase().contains(expectedUrlPart.toLowerCase()),
                    "❌ ה-URL לא מכיל את המחרוזת הצפויה: " + expectedUrlPart
            );

            System.out.println("✅ עבר בהצלחה עבור: " + linkText);

        } catch (AssertionError ae) {
            System.out.println("❗️ בדיקה נכשלה עבור: " + linkText);
            System.out.println("📛 שגיאה: " + ae.getMessage());
            throw ae; // נזרק שוב כדי ש-JUnit יסמן ככישלון
        } catch (Exception e) {
            System.out.println("💥 שגיאת מערכת: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("🧹 הדפדפן נסגר\n");
        }
    }
}
