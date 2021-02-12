package pagefactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {


    @FindBy(id = "user_email")
    WebElement email_field;

    @FindBy(id = "user_password")
    WebElement password_field;

    @FindBy(id = "sign-in-submit-button")
    WebElement sign_in_button;

    @FindBy(xpath = "//iframe[@scrolling='no']")
    WebElement frame;


    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitTestUrl(String url){
        driver.navigate().to(url);
    }

    public void enterEmail(String email) {

        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.switchTo().frame(frame);

        email_field.sendKeys(email);

    }

    public void enterPassword(String password){
        password_field.sendKeys(password);

    }
    public void submitButton(){
        sign_in_button.click();
    }
}
