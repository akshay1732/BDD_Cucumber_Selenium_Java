package StepDefinition;


import PageObjects.Searchpage;
import Utilities.Testbase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


import static org.junit.Assert.*;

public class Teststeps {

    Searchpage page;
    Testbase base = new Testbase();
    WebDriver driver = base.getdriverinstance();

    @Before
    public void beforescenario() throws IOException {
        base.setup();
    }

    @After
    public void afterscenario(){
        base.destroy();
    }

    @Given("^User is on Google search page$")
    public void user_is_on_google_search_page() {
        page  = new Searchpage(driver);
        String title= page.getpagetitle();
        assertEquals(title,"Google");

    }

    @Then("^Enter \"(.*)\" to search in search box$")
    public void enter_to_search_in_search_box(String value) {
        page.entersearchvalue(value);

    }

    @And("^Click on google search button$")
    public void click_on_google_search_button() {
        page.clicksearchbutton();
    }

    @And("^Click on I am feeling lucky button$")
    public void click_on_i_am_feeling_lucky_button() {
        page.clickimfeelingbutton();
    }
}
