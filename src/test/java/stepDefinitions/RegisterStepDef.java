package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class RegisterStepDef {

    RegisterPage registerPage = new RegisterPage();

    @When("User goes to Hubcomfy")
    public void user_goes_to_hubcomfy() {
        Driver.getDriver().get(ConfigReader.getProperty("Hubcomfy"));

    }

    @When("User verifies that he or she went to the home page")
    public void user_verifies_that_he_or_she_went_to_the_home_page() {

        Assert.assertTrue(registerPage.ikonSignIn.isDisplayed());
    }

    @When("User click the register button")
    public void user_click_the_register_button() {
        registerPage.register.click();

    }

    @When("User clicks on the Become a vendor link")
    public void user_clicks_on_the_become_a_vendor_link() {

        registerPage.becomeAvendor.click();

    }

    @Then("User verifies that Vendor Registration is visible")
    public void user_verifies_that_vendor_registration_is_visible() {
        Assert.assertTrue(registerPage.vendorRegisterVisible.isDisplayed());
    }

    @And("User quits page")
    public void userQuitsPage() {
        Driver.quitDriver();
    }


    @Then("User verifies that there is an email box on the Vendor Registration page")
    public void userVerifiesThatThereIsAnEmailBoxOnTheVendorRegistrationPage() {
        Assert.assertTrue(registerPage.emailBox.isDisplayed());

    }

    @Then("User verifies that there is a password box on the Vendor Registration page")
    public void userVerifiesThatThereIsAPasswordBoxOnTheVendorRegistrationPage() {
        Assert.assertTrue(registerPage.passwordBox.isDisplayed());
    }

    @Then("User verifies that there is a confirm password box on the Vendor Registration page")
    public void userVerifiesThatThereIsAConfirmPasswordBoxOnTheVendorRegistrationPage() {
        Assert.assertTrue(registerPage.comfirmPasswordBox.isDisplayed());
    }

    @And("User click the REGISTER button")
    public void userClickTheREGISTERButton() {
        registerPage.REGISTER.click();
    }

    @Then("User verifies that they have received the warning Email This field is required.")
    public void userVerifiesThatTheyHaveReceivedTheWarningEmailThisFieldIsRequired() {
        Assert.assertTrue(registerPage.requireWarningText.isDisplayed());
    }

    @Then("User go to {string} to receive a valid email")
    public void userGoToToReceiveAValidEmail(String minuteEmail) {
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty(minuteEmail));
    }

    String minuteemail;

    @And("User receive the email from the page they go to")
    public void userReceiveTheEmailFromThePageTheyGoTo() {
        minuteemail = registerPage.minuteemail.getText();
    }

    List<String> windowList;

    @And("The user returns to the hub-comfy page and enters the email in the email box")
    public void theUserReturnsToTheHubComfyPageAndEntersTheEmailInTheEmailBox() {
        windowList = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowList.get(0));
        registerPage.emailBox.sendKeys(minuteemail);
    }

    @And("User clicks the RE-SEND CODE button")
    public void userClicksTheRESENDCODEButton() {
        // registerPage.re_sendCode.click();

    }
    String verificetionCode;
    @And("The user goes back to {string} to get the code sent to the email address")
    public void theUserGoesBackToToGetTheCodeSentToTheEmailAddress(String minuteEmail) {
        Driver.getDriver().switchTo().window(windowList.get(1));
        ReusableMethods.waitFor(3);
        Driver.getDriver().navigate().refresh();

        verificetionCode=registerPage.verificationCode.getText().replaceAll("\\D","").substring(0,6);

    }

    @And("User receives the code and returns to hubcomfy")
    public void userReceivesTheCodeAndReturnsToHubcomfy() {
      Driver.getDriver().switchTo().window(windowList.get(0));
    }

    @And("The user enters the code that comes to the e-mail address entered in the Verification Code box")
    public void theUserEntersTheCodeThatComesToTheEMailAddressEnteredInTheVerificationCodeBox() {
        registerPage.codeBox.sendKeys(verificetionCode);
    }

    @And("User enter a valid password")
    public void userEnterAValidPassword() {
        registerPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
    }

    @And("User enters valid confirm password")
    public void userEntersValidConfirmPassword() {
        registerPage.comfirmPasswordBox.sendKeys(ConfigReader.getProperty("validPassword"));
    }

    @And("User clicks the register button")
    public void userClicksTheRegisterButton() {
        registerPage.REGISTER.click();
    }

    @Then("The user verifies seeing the text Welcome to Hubcomfy!")
    public void theUserVerifiesSeeingTheTextWelcomeToHubcomfy() {
        ReusableMethods.waitFor(15);
        Assert.assertTrue(registerPage.welcomeToHuncomfy.isDisplayed());
    }

    @And("User enters an {string}")
    public void userEntersAn(String invalidEmail) {
        registerPage.emailBox.sendKeys(invalidEmail);
        registerPage.re_sendCode.click();
        ReusableMethods.waitFor(3);
    }

    @Then("User verifies that Please provide a valid email address. appears")
    public void userVerifiesThatPleaseProvideAValidEmailAddressAppears() {
        Assert.assertTrue(registerPage.invalidEmailWarning.isDisplayed());
    }
    //*******TC_010****
    @When("User go to minutesEmail to receive a valid email and uniqe mail")
    public void userGoToMinutesEmailToReceiveAValidEmailAndUniqeMail() {
        windowList = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowList.get(0));
        ReusableMethods.waitFor(3);
        registerPage.emailBox.sendKeys(minuteemail);
    }

    //**********TC_011***********
    @When("User enters a non-unique email in the email box")
    public void userEntersANonUniqueEmailInTheEmailBox() {
        registerPage.emailBox.sendKeys(ConfigReader.getProperty("nonUniqe"));
    }

    @And("User enters a postal code in the Verification Code box")
    public void userEntersAPostalCodeInTheVerificationCodeBox() {

        registerPage.codeBox.sendKeys("code");
    }
    @And("User confirms that This Email already exists. Please login to the site and apply as a vendor.")
    public void userConfirmsThatThisEmailAlreadyExistsPleaseLoginToTheSiteAndApplyAsAVendor() {
        ReusableMethods.waitFor(7);
        Assert.assertTrue(registerPage.nonUniqeText.isDisplayed());
    }
    @And("The user enters a {string} of at least six characters including lowercase, uppercase, numbers and special characters")
    public void theUserEntersAOfAtLeastSixCharactersIncludingLowercaseUppercaseNumbersAndSpecialCharacters(String password) {
     registerPage.passwordBox.sendKeys(password);
    }

    @Then("The user verifies seeing the text Strong")
    public void theUserVerifiesSeeingTheTextStrong() {
        Assert.assertEquals(registerPage.strongText.getText(),"Strong");
    }


    @And("User enters {string} use cases\\(PageThree)")
    public void userEntersUseCasesPageThree(String invalidPassword) {
        registerPage.passwordBox.sendKeys(invalidPassword);
    }

    @Then("User verifies that he or she cannot see the strong text")
    public void userVerifiesThatHeOrSheCannotSeeTheStrongText() {
        Assert.assertNotEquals(registerPage.strongText.getText(),"Strong");
    }

    @And("The user enters the same valid password in the confirm password as they enter in the password")
    public void theUserEntersTheSameValidPasswordInTheConfirmPasswordAsTheyEnterInThePassword() {
        registerPage.comfirmPasswordBox.sendKeys(ConfigReader.getProperty("validPassword"));
    }

    @And("To confirm the password, the user enters a different password than the current password entered in the password")
    public void toConfirmThePasswordTheUserEntersADifferentPasswordThanTheCurrentPasswordEnteredInThePassword() {
        registerPage.comfirmPasswordBox.sendKeys(ConfigReader.getProperty("notSamePassword"));
    }

    @Then("The user confirms that they are unable to log in by seeing the text {string}")
    public void theUserConfirmsThatTheyAreUnableToLogInBySeeingTheText(String text) {
        Assert.assertEquals(text,registerPage.notSameText.getText());
    }

    @And("The user goes to minuteEmail to verify incoming email")
    public void theUserGoesToMinuteEmailToVerifyIncomingEmail() {
        Driver.getDriver().switchTo().window(windowList.get(1));
    }

    @And("The user clicks on the Hubcomfy email")
    public void theUserClicksOnTheHubcomfyEmail() {
        Driver.getDriver().navigate().refresh();


    }

    @Then("The user confirms that their My Account is visible by clicking on the Visit now... link in the email")
    public void theUserConfirmsThatTheirMyAccountIsVisibleByClickingOnTheVisitNowLinkInTheEmail() {
        Assert.assertEquals(registerPage.hubcomfyText.getText(),"[Hubcomfy] Successfully Registered");


    }
}