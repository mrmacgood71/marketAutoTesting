import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        WebDriverWait chromeWait = new WebDriverWait(chromeDriver, 10);
        chromeWait
                .until(d -> chromeDriver.findElement(By.name("title"))).isDisplayed();
    }
}
