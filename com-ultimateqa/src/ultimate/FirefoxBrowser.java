package ultimate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowser {
    public static void main(String[] args) {
        String baseUrl = "https://courses.ultimateqa.com/users/sign_in";
        System.setProperty("webdriver.firefox.driver", "drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

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
        WebElement email = driver.findElement(By.name("user[email]"));
        email.sendKeys("Test");

        WebElement password = driver.findElement(By.name("user[password]"));
        password.sendKeys("test123");


        //Close the browser
        driver.quit();
    }
}
