package managers;

import org.openqa.selenium.WebDriver;
import pagefactory.*;


public class PageObjectManager {

    private WebDriver driver;


    private LandingPage landingPage;
    private LoginPage loginPage;
    private CreateChildTicket createChildTicket;
    private ChangeStatusOfTicket changeStatusOfTicket;
    private TicketCreationTab ticketCreationTab;
    private VisitUrls visitUrls;




    public PageObjectManager(WebDriver driver) {

        this.driver = driver;

    }



    public LandingPage getLandingPage(){
        return (landingPage == null) ? landingPage = new LandingPage(driver) : landingPage;
    }

    public LoginPage getLoginPage(){

        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

    }

    public TicketCreationTab getTicketCreationTab(){
        return (ticketCreationTab == null) ? ticketCreationTab = new TicketCreationTab(driver) : ticketCreationTab;
    }

    public CreateChildTicket createChildTicket(){
        return (createChildTicket == null) ? createChildTicket = new CreateChildTicket(driver) : createChildTicket;
    }



}
