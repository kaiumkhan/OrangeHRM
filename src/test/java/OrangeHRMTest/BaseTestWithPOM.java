package OrangeHRMTest;

import org.OrangeHRMPages.OrangeHRMLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTestWithPOM {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void SuccessLogin(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        OrangeHRMLogin.userName(driver).sendKeys("Admin");
        OrangeHRMLogin.Password(driver).sendKeys("admin123");
        OrangeHRMLogin.Loginbtn(driver).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='client brand banner']")));
    }
    @Test
    public void InvalidLogin(){
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            OrangeHRMLogin.userName(driver).sendKeys("Admin1");
            OrangeHRMLogin.Password(driver).sendKeys("admin123y");
            OrangeHRMLogin.Loginbtn(driver).click();
            OrangeHRMLogin.InvalidCredentials(driver).isDisplayed();
            OrangeHRMLogin.InvalidCredentials(driver).getText();
            System.out.println(OrangeHRMLogin.InvalidCredentials(driver).getText());

    }



    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();
    }
}
