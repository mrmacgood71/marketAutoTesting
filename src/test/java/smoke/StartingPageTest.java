package smoke;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StartingPageTest {
    private WebDriver chromeDriver;

    private WebDriverWait chromeWait;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeWait = new WebDriverWait(chromeDriver, 10);
    }

    @Test(description = "Testing header search input on the home page")
    public void headerSearch() {
        chromeDriver.get("https://market.yandex.ru/");
        WebElement productsSearch = chromeDriver.findElement(By.id("header-search"));
        productsSearch.clear();
        productsSearch.sendKeys("лыжи");
        chromeDriver.findElement(By.xpath("//button[@data-r]")).click();

        Assert.assertEquals(chromeDriver.getTitle(), "«лыжи» — Результаты поиска — Яндекс.Маркет");
    }

    @AfterTest
    public void stop() {
        chromeDriver.quit();
        chromeDriver = null;
    }
}
