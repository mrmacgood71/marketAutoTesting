package smoke;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class StartingPageTest {
    private WebDriver chromeDriver;
    private WebDriver chromeDriver2;

    private WebDriverWait chromeWait;

    private String yandexMarket = "https://market.yandex.ru/";

    @BeforeTest(enabled = false)
    public void start() {
//        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "disable-infobars");
        chromeDriver = new ChromeDriver(options);
        chromeDriver2 = new ChromeDriver(options);
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeWait = new WebDriverWait(chromeDriver, 10);
    }

    @Test(enabled = false)
    public void cookiesInspecting() {
        chromeDriver.get(yandexMarket);
        chromeDriver2.get(yandexMarket);
        Set<Cookie> cookies = chromeDriver.manage().getCookies();
        System.out.println(cookies);
    }

    @Test(description = "Testing header search input on the home page", enabled = false)
    public void headerSearch() {
        chromeDriver.get(yandexMarket);
        chromeWait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.id("header-search"))));
        WebElement productsSearch = chromeDriver.findElement(By.id("header-search"));
        productsSearch.clear();
        productsSearch.sendKeys("лыжи");
        chromeDriver.findElement(By.xpath("//button[@data-r]")).click();
        chromeWait.until(ExpectedConditions.titleIs("«лыжи» — Результаты поиска — Яндекс.Маркет"));
    }


    @Test(enabled = false)
    public void authorizationTest() {
        chromeDriver.get(yandexMarket);
        chromeDriver.findElement(By.xpath("//span[text()='Войти']")).click();
    }


    @AfterTest(enabled = false)
    public void stop() {
        chromeDriver.quit();
        chromeDriver = null;
        chromeDriver2.quit();
        chromeDriver = null;
    }
}
