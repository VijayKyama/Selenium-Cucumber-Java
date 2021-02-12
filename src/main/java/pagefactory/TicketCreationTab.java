package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TicketCreationTab {
   public static String TicketNum;
    @FindBy(xpath = "//input[@data-test-id='new-ticket-subject']")
    WebElement subjectfield;

    @FindBy(xpath = "//*[@id='downshift-5-input']")
    WebElement to_field;

    @FindBy(xpath = "//*[@id='downshift-5-item-0']")
    WebElement dropdown_item;

    @FindBy(xpath = "//*[@id='editor0']/div[1]/div[1]/p")
    WebElement description_field;

    @FindBy(xpath = "//button[@data-test-id='submit_button-menu-button']")
    WebElement submit_button_options;


    @FindBy(xpath = "//li[@data-test-id='submit_button-menu-open']")
    WebElement submit_button_open;

    @FindBy(xpath = "//*[@id='jGrowl']/div[2]")
    WebElement notification;

    @FindBy(xpath = "//div[@data-garden-id='forms.faux_input']")
    WebElement searchicon;

    @FindBy(xpath = "//input[@data-test-id='header-toolbar-search-input']")
    WebElement textfield;

    @FindBy(xpath = "//div[@data-test-id='search_tables_table-body']//a[1]")
    WebElement search_result;

    WebDriver driver;

    public  TicketCreationTab(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enter_subject_field(){
        String subject;
        subject = "Test-Vijay-001";
        subjectfield.sendKeys(subject);
    }

    public void enter_to_field() throws InterruptedException {
        String email;
        email = "test@test.com";
        to_field.sendKeys(email);

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(3000);
        dropdown_item.click();
        //to_field.sendKeys(Keys.ENTER);
    }

    public void enter_description_field(){

        String description;
        description = "This is new ticket";
        description_field.sendKeys(description);
    }

    public void submit_button_options (){

        submit_button_options.click();
    }

    public void submit_as_open(){

        submit_button_open.click();
    }
    public void notification(){
        WebElement notification;
        WebDriverWait wait=new WebDriverWait(driver, 20);
        notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='jGrowl-message']/a")));
        System.out.println(notification.getText());

        TicketNum = notification.getText().substring(9);
        System.out.println(TicketNum);
        notification.click();

    }

    public void searchTicket() throws InterruptedException {
        searchicon.click();
        textfield.sendKeys(TicketNum);
        Thread.sleep(20000);
        textfield.sendKeys(Keys.ENTER);

    }

    public void clickNewTicket(){

       search_result.click();
    }
}
