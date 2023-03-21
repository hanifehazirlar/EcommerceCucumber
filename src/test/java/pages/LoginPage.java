package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[contains(@class,'login__submit')]")
    public WebElement signInButton;

    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath = "//p[text()='Wrong username or password.']")
    public WebElement wrong;

    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    public WebElement myAccount;

    @FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation col-md-3 mb-8']/ul/li/a")
    public List<WebElement> dasboardList;


    @FindBy(xpath = "//p[@class='text-uppercase text-center mb-0']")
    public List<WebElement> dasboardIconsList;



}
