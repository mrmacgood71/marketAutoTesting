import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.Extension;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        WebDriverWait chromeWait = new WebDriverWait(chromeDriver, 10);
        chromeWait
                .until(d -> chromeDriver.findElement(By.name("title"))).isDisplayed();
    }
}
