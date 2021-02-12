package env;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Env {

    WebDriver driver = null;
    @Before
    public void setChromeDriver() {
        this.driver = driver;
        System.getProperty("webdriver.chrome.driver","/Selenium-UI-TestAutomation/src/test/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);

    }
    @After
    public void existdriver(){
        driver.close();
        driver.quit();
    }



}
