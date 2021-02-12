package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SanityCheckProjectApp extends Base{


    @Before
    public void initialize(){
        super.setWedriverManager();
        super.setPageObjectManager();
    }

    @After
    public void tearDown(){
        super.getDriver().close();
        super.getDriver().quit();

    }

    @Given("User launches the application url")
    public void user_launches_the_application_url() {
        String url_to_visit= super.getConfigData().getApplicationUrl();
       super.getPageObjectManager().getLoginPage().visitTestUrl(url_to_visit);


    }


    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        pageObjectManager.getLoginPage().enterEmail(super.getConfigData().emailId());
        pageObjectManager.getLoginPage().enterPassword(super.getConfigData().passWord());

    }

    @When("Click on signin button")
    public void click_on_signin_button() {
        pageObjectManager.getLoginPage().submitButton();


    }

    @Then("User should land on home screen")
    public void user_should_land_on_home_screen() {

        pageObjectManager.getLandingPage().waitForTicketDashboard();
        String title;
        title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.equalsIgnoreCase("Zendesk - Agent"));

    }

    @Given("User is on home screen")
    public void user_is_on_home_screen() {



    }

    @When("User hovers on Add button")
    public void user_hovers_on_button() {
        pageObjectManager.getLandingPage().addTicket();
    }

    @Then("multiple buttons should appear along with Ticket")
    public void multiple_buttons_should_appear_along_with_ticket() {

        Boolean result = driver.findElement(By.xpath("//li[@data-test-id='header-toolbar-add-menu-new-ticket']")).isDisplayed();
        Assert.assertTrue(result);
    }

    @When("User clicks on Ticket")
    public void user_clicks_on_ticket() {
        pageObjectManager.getLandingPage().OpenTicket();
    }

    @Then("new tab should open to create a new ticket")
    public void new_tab_should_open_to_create_a_new_ticket() {
       String tabTitle = driver.findElement(By.xpath("//div[@data-test-id='header-tab-title']")).getText();
        Assert.assertTrue(tabTitle.equalsIgnoreCase("New ticket"));
    }

    @When("User enters subject, To and description fields")
    public void user_enters_subject_to_and_description_fields() throws InterruptedException {
        pageObjectManager.getTicketCreationTab().enter_subject_field();
        pageObjectManager.getTicketCreationTab().enter_to_field();
        pageObjectManager.getTicketCreationTab().enter_description_field();

    }

    @When("click on submit as new button")
    public void click_on_submit_as_new_button() {
        pageObjectManager.getTicketCreationTab().submit_button_options();
        pageObjectManager.getTicketCreationTab().submit_as_open();
    }

    @Then("a new ticket should be created")
    public void a_new_ticket_should_be_created() {
        pageObjectManager.getTicketCreationTab().notification();
    }


    @Given("User opened newly created original ticket")
    public void user_opened_newly_created_original_ticket() throws InterruptedException {
       pageObjectManager.getLandingPage().waitForTicketDashboard();
       pageObjectManager.getTicketCreationTab().searchTicket();
       pageObjectManager.getTicketCreationTab().clickNewTicket();

    }



    @When("User clicks on Make a Project from this Ticket button")
    public void user_clicks_on_make_a_project_from_this_ticket_button() throws InterruptedException {
        pageObjectManager.createChildTicket().clickAppButton();
        pageObjectManager.createChildTicket().switchToiFrame();
        pageObjectManager.createChildTicket().clickToMakeProject();



    }
    @Then("create single, Create Bulk, Add existing options should appear")
    public void create_single_create_bulk_add_existing_options_should_appear() {

    }
    @When("User selects to create single")
    public void user_selects_to_create_single() {
        pageObjectManager.createChildTicket().clickSingle();
    }
    @Then("a new screen should appear in sidebar with all required fields")
    public void a_new_screen_should_appear_in_sidebar_with_all_required_fields() {

    }
    @When("User clicks on create single tasks in sidebar overlay")
    public void user_clicks_on_create_single_tasks_in_sidebar_overlay() throws InterruptedException {
        pageObjectManager.createChildTicket().clickSingleButton();
    }
    @Then("a child ticket should be created")
    public void a_child_ticket_should_be_created() {

    }


    @Given("User opens parent ticket")
    public void user_opens_parent_ticket() {

    }


    @Then("User should see valid parent tags")
    public void user_should_see_valid_parent_tags() {
        String parentTag = driver.findElement(By.xpath("//div[@data-test-id='ticket-fields-tags']//li[2]/a")).getText();
        Assert.assertTrue(parentTag.equalsIgnoreCase("project_parent"));
    }
    @When("User opens child ticket")
    public void user_opens_child_ticket() throws InterruptedException {
        pageObjectManager.createChildTicket().clickChildTicket();
    }
    @Then("User should see valid project id from parent ticket")
    public void user_should_see_valid_project_id_from_parent_ticket() {
        String childTag = driver.findElement(By.xpath("(//div[@data-test-id='ticket-fields-tags']//li[2]/a)[2]")).getText();
        Assert.assertTrue(childTag.equalsIgnoreCase("project_child"));
    }
    @Then("valid tag for child ticket")
    public void valid_tag_for_child_ticket() {

    }




    @Given("User access the parent ticket")
    public void user_access_the_parent_ticket() {

    }




    @When("User clicks on arrow mark in the right bottom of the page to update status")
    public void user_clicks_on_arrow_mark_in_the_right_bottom_of_the_page_to_update_status() {

    }
    @Then("submit as solved option should be visible along with Open and Pending")
    public void submit_as_solved_option_should_be_visible_along_with_open_and_pending() {

    }
    @When("User clicks on submit as solved without closing child ticket")
    public void user_clicks_on_submit_as_solved_without_closing_child_ticket() {

    }
    @Then("User should receive proper message that it is not possible to close parent ticket unless child ticket is closed")
    public void user_should_receive_proper_message_that_it_is_not_possible_to_close_parent_ticket_unless_child_ticket_is_closed() {

    }


}
