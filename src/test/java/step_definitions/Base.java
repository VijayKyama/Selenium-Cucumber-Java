package step_definitions;

import dataProviders.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class Base {
    WebDriverManager webDriverManager;
    PageObjectManager pageObjectManager;
    ConfigFileReader configFileReader;
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

    protected ConfigFileReader getConfigData(){
        configFileReader= new ConfigFileReader();
        return this.configFileReader;
    }


}
