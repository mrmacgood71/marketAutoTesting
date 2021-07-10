package smoke;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GoogleSearchTest {
    private WebDriver chromeDriver;

    private WebDriverWait chromeWait;

    @BeforeTest(enabled = false)
    public void start() {
//        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeWait = new WebDriverWait(chromeDriver, 10);
    }

    @Test(enabled = false)
    public void headerSearch() {
        chromeDriver.get("https://google.com/");
        chromeDriver.findElement(By.name("q")).sendKeys("java");
        chromeWait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.xpath("//div[@class='BKRPef M2vV3']")))).click();
        Assert.assertEquals(chromeDriver.findElement(By.name("q")).getText(), "");
    }

    @AfterTest(enabled = false)
    public void stop() {
        chromeDriver.quit();
        chromeDriver = null;
    }
}
