//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import pageObject.BtlBasePage;
//import pageObject.Menu;
//
//import java.sql.Driver;
//
//public class BTLMenuTest {
//    WebDriver driver = new ChromeDriver();
//    BtlBasePage page = new BtlBasePage(driver);
//    @BeforeEach
//    public void setUp() {
//        driver.get("https://www.btl.gov.il");
//    }
//      @Test
//              public void testSearch (){
//          page.enterSearchText("חישוב סכום דמי לידה ליום");
//            boolean titleIsCorrect = driver.getTitle().contains("חישוב סכום דמי לידה ליום");
////            assertTrue(titleIsCorrect, "כותרת הדף לא תואמת את תוצאת החיפוש הצפויה.");
//
//     }
//
//@AfterAll
//        public static void after() {
//            if (driver != null) {
//                driver.quit();
//        }
////    @Test
////    public void testClickMenuItem() {
////        WebDriver driver = new ChromeDriver();
////        driver.get("https://www.btl.gov.il");
////        BtlBasePage page = new BtlBasePage(driver);
////        page.choose(Menu.TopMenuEnum.CONTACT);
////    }
//
//
////    @Test
////    public void testSearchBranch() {
////        WebDriver driver = new ChromeDriver();
////        driver.get("https://www.btl.gov.il");
////        BtlBasePage page = new BtlBasePage(driver);
////        page.enterSearchText("תשלומים");
////
////    }
////    @Test
////            public void testSnifim(){
////    WebDriver driver = new ChromeDriver();
////    driver.get("https://www.btl.gov.il");
////    BtlBasePage page = new BtlBasePage(driver);
////    page.clickSnifim();
////}
//    }



//package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.BtlBasePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BTLMenuTest {

    WebDriver driver;
    BtlBasePage page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.btl.gov.il");
        page = new BtlBasePage(driver);
    }

    @Test
    public void testSearchResultsTitle() {
        String searchQuery = "חישוב סכום דמי לידה ליום";
        page.enterSearchText(searchQuery);

        // בדיקה שהכותרת מכילה את מחרוזת החיפוש
       // boolean titleIsCorrect = driver.getTitle().contains(searchQuery);
        assertEquals("חישוב סכום דמי לידה ליום - מחשבוני זכויות | ביטוח לאומי",driver.getTitle(),"כותרת הדף לא תואמת את תוצאת החיפוש הצפויה.");


    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
