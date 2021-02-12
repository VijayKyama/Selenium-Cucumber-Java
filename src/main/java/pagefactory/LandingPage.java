package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class LandingPage {
    @FindBy(xpath = "//button[@data-test-id='header-toolbar-add-menu-button']")
    WebElement add_ticket;

    @FindBy(xpath = "//li[@data-test-id='header-toolbar-add-menu-new-ticket']")
    WebElement click_new_ticket;

    @FindBy(id = "ember1829")
    WebElement Home_icon;

    @FindBy(id = "ember4303")
    WebElement tickets_dashboard;

    @FindBy(xpath = "//div[@id='table1']//li[8]")
    WebElement pagination_last_page;

    @FindBy(linkText = "")
    WebElement open_recent_ticket;

    @FindBy(xpath = "//div[@data-test-id='header-toolbar-search-button']")
    WebElement search_ticket;


    @FindBy(xpath = "//input[@data-test-id='header-toolbar-search-input']")
    WebElement search_field;

    @FindBy(xpath = "//a[@data-garden-id='buttons.anchor']")
    WebElement search_result;

    WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void waitForTicketDashboard(){
        
        WebElement dashboard;
        WebDriverWait wait=new WebDriverWait(driver, 20);
       dashboard =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@data-test-id='table_header']")));
        dashboard.click();
    }

    public void addTicket(){
        System.out.println("in add ticket");
        add_ticket.click();

    }

    public void OpenTicket(){
        click_new_ticket.click();
    }

    public void search_ticket (){
        search_ticket.click();
    }

    public void search_text() {

        search_field.sendKeys();
    }

    public  void select_search_result(){

        search_result.click();
    }

}
