package com.example.definitions;

import com.example.pom.login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

import static com.example.base.driver;

public class LoginPageDefinitions {

  //  private static WebDriver driver;
 //   public final static int TIMEOUT = 5;



    @Before
    public void setUp() {

        login  lg= new login();
       lg.lanchbrowser();

    }

    @Given("User is on HRMLogin page {string}")
    public void loginTest(String url) {

        driver.get(url);

    }

    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) {

      login  lg= new login();
      lg.logintoapp("admib", "password");

        // go the next page
    }

    @Then("User should be able to login successfully and new page open")
    public void verifyLogin() {

        String homePageHeading = driver.findElement(By.xpath("//*[@class='oxd-topbar-header-breadcrumb']/h6")).getText();

        //Verify new page - HomePage
        Assert.assertEquals(homePageHeading, "Dashboard");

    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {

        String actualErrorMessage = driver.findElement(By.xpath("//*[@class='orangehrm-login-error']/div[1]/div[1]/p")).getText();

        // Verify Error Message
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }

    @After
    public void teardown() {

        driver.quit();
    }


}
