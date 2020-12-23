package Network;

import Objects.LoginData;
import Objects.LoginDom;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TorHandler implements Handler {
    private WebDriver driver;
    private WebDriverWait wait;
    private Process torProcess;

    public TorHandler() throws IOException {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        String torBinaryPath = "C:\\Users\\airph\\Desktop\\Tor Browser\\Browser\\firefox.exe";
        Runtime runTime = Runtime.getRuntime();
        torProcess = runTime.exec(torBinaryPath + " -f");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.socks", "127.0.0.1");
        profile.setPreference("network.proxy.socks_port", 9150);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(profile);
        //firefoxOptions.setHeadless(true);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
    }

    @Override
    public boolean getResponse(LoginData person, LoginDom domModel) throws IOException, InterruptedException {

        driver.navigate().to(domModel.url);

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(domModel.usernameXPath)));
        WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(domModel.passwordXPath)));
        if (domModel.checkForXPath != null) {
            try {
                driver.findElement(By.xpath(domModel.checkForXPath)).click();
            } catch (ElementNotVisibleException | NoSuchElementException e) {
            }
        }

        username.sendKeys(person.username);
        pwd.sendKeys(person.password);

        // Locate the login button and click on it
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(domModel.loginXPath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(domModel.loginXPath))).click();
        try {
            WebDriverWait waitS = new WebDriverWait(driver, 5);
            waitS.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(domModel.message)));
            return false;
        } catch (NoSuchElementException | TimeoutException e) {
            return true;

        }
       /* if (driver.getCurrentUrl().equals(domModel.url)) {
            return false;
        } else {
            return true;
        }*/

    }
}
