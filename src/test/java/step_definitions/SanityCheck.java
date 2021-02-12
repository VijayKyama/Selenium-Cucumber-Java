package step_definitions;
import env.Env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.LoginPage;

public class SanityCheck {

        LoginPage login;


        @Given("This is my first statement")
        public void this_is_my_first_statement() {
           System.out.println("First statement is printed");

        }

        @When("This is my second statement")
        public void this_is_my_second_statement() {
            System.out.println("Second statement is printed");
        }

        @Then("This is my third statement")
        public void this_is_my_third_statement() {
            System.out.println("Third statement is printed");
        }



}
