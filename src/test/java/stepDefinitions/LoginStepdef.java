package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class LoginStepdef {
    LoginPage loginPage =new LoginPage();
    @And("User clicks Sign In")
    public void userClicksSignIn() {
        loginPage.signIn.click();
    }

    @And("User enters a valid email in the email box")
    public void userEntersAValidEmailInTheEmailBox() {
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("validEmail"));
    }

    @And("User enters the valid password in the password box")
    public void userEntersTheValidPasswordInThePasswordBox() {
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validpassword"));
    }

    @And("User click the SIGN IN button")
    public void userClickTheSIGNINButton() {
        loginPage.signInButton.click();
    }

    @Then("The user confirms that they went to the My Account page")
    public void theUserConfirmsThatTheyWentToTheMyAccountPage() {
        Assert.assertTrue(loginPage.signOut.isDisplayed());
    }
    @And("User enters {string} and {string} from use cases")
    public void userEntersAndFromUseCases(String invalidEmail, String invalidPasword) {
        loginPage.emailBox.sendKeys(invalidEmail);
        loginPage.passwordBox.sendKeys(invalidPasword);

    }

    @Then("User confirms that they cannot go to the My Account page")
    public void userConfirmsThatTheyCannotGoToTheMyAccountPage() {
        Assert.assertEquals(loginPage.wrong.getText(),"Wrong username or password.");
    }

    @And("Click on the My Account link")
    public void clickOnTheMyAccountLink() {
        ReusableMethods.jsScrollClick(loginPage.myAccount);
    }
    List<String> dasboardIconsStringList=new ArrayList<>();
    @Then("Verifies the visibility of Orders")
    public void verifiesTheVisibilityOfOrders() {

        for (WebElement w:loginPage.dasboardIconsList) {
            dasboardIconsStringList.add(w.getText());
        }
        System.out.println("dasboardIconsStringList = " + dasboardIconsStringList);

        Assert.assertTrue(dasboardIconsStringList.contains("ORDERS"));
    }

    @Then("Corrects the visibility of the Downloads text")
    public void correctsTheVisibilityOfTheDownloadsText() {
        Assert.assertTrue(dasboardIconsStringList.contains("DOWNLOADS"));
    }

    @Then("Verifies the visibility of Addresses")
    public void verifiesTheVisibilityOfAddresses() {
        Assert.assertTrue(dasboardIconsStringList.contains("ADDRESSES"));
    }

    @Then("Verifies the visibility of Account details")
    public void verifiesTheVisibilityOfAccountDetails() {
        Assert.assertTrue(dasboardIconsStringList.contains("ACCOUNT DETAILS"));
    }
    @Then("Verifies the visibility of the Wishlist text")
    public void verifiesTheVisibilityOfTheWishlistText() {
        Assert.assertTrue(dasboardIconsStringList.contains("WISHLIST"));
    }
    @Then("Verifies the visibility of the Logout text")
    public void verifiesTheVisibilityOfTheLogoutText() {
        Assert.assertTrue(dasboardIconsStringList.contains("LOGOUT"));
    }
    List<String> dasboardStringList=new ArrayList<>();
    @Then("Store manager confirms that the text is there")
    public void storeManagerConfirmsThatTheTextIsThere() {
        for (WebElement w:loginPage.dasboardList) {
            dasboardStringList.add(w.getText());
        }
        System.out.println("dasboardStringList = " + dasboardStringList);
        Assert.assertTrue(dasboardStringList.contains("Store Manager"));
    }
    @Then("Then orders confirm that the text is there")
    public void thenOrdersConfirmThatTheTextIsThere() {
        Assert.assertTrue(dasboardStringList.contains("Orders"));
    }
    @Then("Downloads confirm that the text is there")
    public void downloadsConfirmThatTheTextIsThere() {
        Assert.assertTrue(dasboardStringList.contains("Downloads"));
    }
    @Then("Addresses confirm that there is writing")
    public void addressesConfirmThatThereIsWriting() {
        Assert.assertTrue(dasboardStringList.contains("Addresses"));
    }
    @Then("Confirms the existence of account details")
    public void confirmsTheExistenceOfAccountDetails() {
        Assert.assertTrue(dasboardStringList.contains("Account details"));
    }
    @Then("Confirms that there is an Appointments sign")
    public void confirmsThatThereIsAnAppointmentsSign() {
        Assert.assertFalse(dasboardStringList.contains("Appointments"));
    }

    @Then("Wishlist confirms that there is writing")
    public void wishlistConfirmsThatThereIsWriting() {
        Assert.assertTrue(dasboardStringList.contains("Wishlist"));
    }
    @Then("Confirms that there are support tickets")
    public void confirmsThatThereAreSupportTickets() {
        Assert.assertTrue(dasboardStringList.contains("Support Tickets"));
    }
    @Then("Followings confirms that the text exists")
    public void followingsConfirmsThatTheTextExists() {
        Assert.assertTrue(dasboardStringList.contains("Followings"));
    }
    @Then("Confirms that there is a logout sign")
    public void confirmsThatThereIsALogoutSign() {
        Assert.assertTrue(dasboardStringList.contains("Logout"));
    }
}
