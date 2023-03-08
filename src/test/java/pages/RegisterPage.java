package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterPage {

    public RegisterPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[contains(@class,\"login\")]")
    public WebElement ikonSignIn;


    @FindBy(css = ".register.inline-type")
    public WebElement register;

    @FindBy(xpath= "//a[text()='Become a Vendor']")
    public WebElement becomeAvendor;

    @FindBy(xpath = "//h2[text()='Vendor Registration']")
    public WebElement vendorRegisterVisible;
   //============================================
    @FindBy(css = "#user_email")
    public WebElement emailBox;

    @FindBy(css = "#passoword")
    public WebElement passwordBox;

    @FindBy(css = "#confirm_pwd")
    public WebElement comfirmPasswordBox;

    //==============================
    @FindBy(xpath = "//*[@id='wcfm_membership_register_button']")
    public  WebElement REGISTER;


    @FindBy(css = ".wcfm_form_simple_submit_wrapper")
    public  WebElement requireWarningText;
    //==================
    @FindBy(xpath = "//span[@id='email']")
    public WebElement minuteemail;

    @FindBy(xpath = "//input[@type='button']")
    public WebElement re_sendCode;

    @FindBy(xpath = "(//tbody/tr/td)[2] ")
    public WebElement verificationCode;

    @FindBy(xpath = "//input[contains(@name,'verified_input')]")
    public WebElement codeBox;

    @FindBy(xpath = "//h1[contains(text(),'Welcome')]")
    public WebElement welcomeToHuncomfy;

    //=======================
    @FindBy(xpath = "//*[text()='Please provide a valid email address.']")
    public WebElement invalidEmailWarning;

    @FindBy(xpath="//div[text()='This Email already exists. Please login to the site and apply as vendor.']")
    public WebElement nonUniqeText;

    @FindBy(xpath="//div[@id='password_strength']")
    public WebElement strongText;



    @FindBy(xpath="//div[contains(text(),'Password and Confirm')]")
    public WebElement notSameText;

    @FindBy(xpath="(//tbody/tr/td)[2]")
    public WebElement hubcomfyText;




}