package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GridStepDef {
    WebDriver driver;
    RegisterPage registerPage=new RegisterPage();
    @Given("Grid User goes to Hubcomfy")
    public void gridUserGoesToHubcomfy() throws MalformedURLException {
         driver=new RemoteWebDriver(new URL("http://192.168.1.104:4444"),new ChromeOptions());
         driver.get(ConfigReader.getProperty("Hubcomfy"));
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
    }

    @Then("Grid User verifies that he or she went to the home page")
    public void gridUserVerifiesThatHeOrSheWentToTheHomePage() {

        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@class,\"login\")]")).isDisplayed());
    }

    @And("Grid User click the register button")
    public void gridUserClickTheRegisterButton() {
        driver.findElement(By.cssSelector(".register.inline-type")).click();
    }

    @And("Grid User clicks on the Become a vendor link")
    public void gridUserClicksOnTheBecomeAVendorLink() {
        driver.findElement(By.xpath("//a[text()='Become a Vendor']")).click();
    }
    String minuteemail;
    List<String> windowList;
    @When("Grid User go to minutesEmail to receive a valid email")
    public void gridUserGoToMinutesEmailToReceiveAValidEmail() {
        minuteemail = driver.findElement(By.xpath("//span[@id='email']")).getText();
        windowList = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        driver.switchTo().window(windowList.get(0));
        driver.findElement(By.cssSelector("#user_email")).sendKeys(minuteemail);
    }

    @And("Grid User receive the email from the page they go to")
    public void gridUserReceiveTheEmailFromThePageTheyGoTo() {

    }

    @And("Grid The user returns to the hub-comfy page and enters the email in the email box")
    public void gridTheUserReturnsToTheHubComfyPageAndEntersTheEmailInTheEmailBox() {

    }

    @And("Grid User clicks the RE-SEND CODE button")
    public void gridUserClicksTheRESENDCODEButton() {
    }
    String verificetionCode;
    @And("Grid The user goes back to minutesEmail to get the code sent to the email address")
    public void gridTheUserGoesBackToMinutesEmailToGetTheCodeSentToTheEmailAddress() {
       driver.switchTo().window(windowList.get(1));
        ReusableMethods.waitFor(3);
        driver.navigate().refresh();

        verificetionCode=registerPage.verificationCode.getText().replaceAll("\\D","").substring(0,6);
    }

    @And("Grid User receives the code and returns to Hubcomfy")
    public void gridUserReceivesTheCodeAndReturnsToHubcomfy() {
        driver.switchTo().window(windowList.get(0));
    }

    @And("Grid The user enters the code that comes to the e-mail address entered in the Verification Code box")
    public void gridTheUserEntersTheCodeThatComesToTheEMailAddressEnteredInTheVerificationCodeBox() {
        registerPage.codeBox.sendKeys(verificetionCode);
    }

    @And("Grid User enter a valid password")
    public void gridUserEnterAValidPassword() {
        registerPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
    }

    @And("Grid User enters valid confirm password")
    public void gridUserEntersValidConfirmPassword() {
        registerPage.comfirmPasswordBox.sendKeys(ConfigReader.getProperty("validPassword"));
    }

    @And("Grid User clicks the register button")
    public void gridUserClicksTheRegisterButton() {
        registerPage.REGISTER.click();
    }

    @Then("Grid The user verifies seeing the text Welcome to Hubcomfy!")
    public void gridTheUserVerifiesSeeingTheTextWelcomeToHubcomfy() {
        ReusableMethods.waitFor(15);
        org.testng.Assert.assertTrue(registerPage.welcomeToHuncomfy.isDisplayed());
    }


    @Given("GridEdge User goes to Hubcomfy")
    public void gridedgeUserGoesToHubcomfy() throws MalformedURLException {
        driver=new RemoteWebDriver(new URL("http://192.168.1.104:4444"),new EdgeOptions());
        driver.get(ConfigReader.getProperty("Hubcomfy"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
    }

    @And("Grid User quits page")
    public void gridUserQuitsPage() {
        driver.quit();
    }
}
