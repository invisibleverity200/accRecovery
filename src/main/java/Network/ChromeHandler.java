package Network;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Objects.LoginData;

public abstract class ChromeHandler implements Handler {
    private WebDriver driver;

    public ChromeHandler() {
        try {
            String chromeDriverPath = "C:\\Users\\airph\\Downloads\\chromedriver_win32\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--silent");
            driver = new ChromeDriver(options);
        } catch (IllegalArgumentException e) {
            System.out.println("Chrome not Found!");
        }
    }

    public boolean getResponse(String url, LoginData person) {
        // Get the login page
        driver.get(url);

        // Search for username / password input and fill the inputs
        driver.findElement(By.xpath("//input[@name='acct']")).sendKeys(person.username);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(person.password);

        // Locate the login button and click on it
        driver.findElement(By.xpath("//input[@value='login']")).click();

        if (driver.getCurrentUrl().equals(url)) {
            System.out.println("Incorrect credentials");
            driver.quit();
            return false;
        } else {
            driver.findElement(By.id("logout")).click();
            return true;
        }


    }

    public void close() {
        driver.quit();
    }
}
