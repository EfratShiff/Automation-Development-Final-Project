
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
