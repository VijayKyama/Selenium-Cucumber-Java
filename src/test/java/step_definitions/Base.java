package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class Base {
    WebDriverManager webDriverManager;
    PageObjectManager pageObjectManager;
    WebDriver driver;

    protected void setWedriverManager(){
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();

    }

    protected void setPageObjectManager(){
        pageObjectManager = new PageObjectManager(this.driver);
    }

    protected WebDriver getDriver(){
        return this.driver;
    }

    protected PageObjectManager getPageObjectManager(){
        return this.pageObjectManager;
    }


}
