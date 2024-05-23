package ontrack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class OnTrackTest {

    private WebDriver driver;
    private String baseUrl = "http://ontrack.deakin.edu.au"; // Update with the correct URL

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dhruv\\OneDrive\\Desktop\\Assignment\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        driver.get(baseUrl + "/login");
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("btn-primary"));

        usernameInput.sendKeys("your_username");
        passwordInput.sendKeys("your_password");
        loginButton.click();

        // Verify login success by checking if user profile element exists
        WebElement userProfile = driver.findElement(By.className("user-profile"));
        assertEquals(true, userProfile.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
