package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ParallelGoogleFirstTest extends TestsBase {

    @Test
    public void firstSearchingTest() {
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
    }

    @Test
    public void secondSearchingTest() {
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);

    }

    @Test
    public void thirdSearchingTest() {
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
    }
}
