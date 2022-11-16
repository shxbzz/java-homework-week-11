package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {

    static String browser = "Edge";
    static String baseUrl = "https://www.saucedemo.com/";

    static WebDriver driver;


    public static void main(String[] args) {

        //Browser selection
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.firefox.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
        }

        //Launch the URL
        driver.get(baseUrl);

        //Maximise Window
        driver.manage().window().maximize();

        //Give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        //Get current URL
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        //Get Page Source
        System.out.println("Page source: " + driver.getPageSource());

        //Find and enter login details
        WebElement email = driver.findElement(By.name("user-name"));
        email.sendKeys("Test");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("test123");

        //Close the browser
        driver.quit();
    }

}
