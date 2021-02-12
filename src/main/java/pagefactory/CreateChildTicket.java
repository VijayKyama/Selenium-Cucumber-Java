package pagefactory;

import managers.PageObjectManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.utilities.Assert;

import java.security.Key;

public class CreateChildTicket {

    @FindBy(xpath = "//button[@data-test-id='customer-context-tab-apps']")
    WebElement appsButton;

    @FindBy(xpath = "//div[@id='app']//button")
    WebElement make_a_project_button;

    @FindBy(xpath = "//*[@id='nav']/button[2]")
    WebElement create_single;

    @FindBy(xpath = "//div[@class='app_view app-39234 apps_ticket_sidebar box']//iframe")
    WebElement frame;

    @FindBy(xpath = "//*[@id='app']/div/div[12]/button")
    WebElement create_single_ticket;

    @FindBy(xpath = "//*[@class='app_container']/div[2]/div/span[1]")
    WebElement arrow;

    @FindBy(xpath = "//*[@id='ticketDesc']")
    WebElement textArea;

    @FindBy(xpath = "//div[@data-test-id='ticket-fields-tags']//li[2]/a")
    WebElement parentTag;

    @FindBy(xpath = "//*[@id='app']/div/table[2]/tbody/tr/td[1]/a")
    WebElement childTicket;

    WebDriver driver;


    public CreateChildTicket(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void switchToiFrame(){
        WebElement iframe;
        WebDriverWait wait=new WebDriverWait(driver, 20);
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='app_view app-39234 apps_ticket_sidebar box']//iframe")));

        driver.switchTo().frame(frame);
    }

    public void clickAppButton(){
        appsButton.click();
    }
    public void clickToMakeProject(){
        make_a_project_button.click();
    }

    public void clickSingle(){
        create_single.click();
    }


    public void clickSingleButton() throws InterruptedException {

       Thread.sleep(5000);

        driver.switchTo().defaultContent();
        arrow.click();
        arrow.click();

        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,10000)");
        driver.switchTo().frame(frame);
        textArea.click();
        Thread.sleep(5000);
        create_single_ticket.click();

        Thread.sleep(10000);
        driver.switchTo().defaultContent();
    }

    public void getParentTags(){
       String tag = parentTag.getText();

    }

    public void clickChildTicket() throws InterruptedException {
        driver.switchTo().frame(frame);
        childTicket.click();
        Thread.sleep(3000);

        System.out.println("Child ticket is clicked");
        driver.switchTo().defaultContent();
       // WebDriverWait wait=new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-id='ticket-fields-tags']//li[2]/a")));


    }

}
