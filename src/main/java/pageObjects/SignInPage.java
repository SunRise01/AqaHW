package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SignInPage extends AbstractPage{

    private static final Logger LOG = Logger.getLogger(SignInPage.class);

    private By mailInput = By.id("username");

    private By passwordInput = By.id("password");

    private By signInButton = By.id("kc-login");

    private By continueButton = By.id("kc-login-next");

    private By loginFailedErrorMessage = By.xpath("//span[text()=\"We can't find user with such credentials.\"]");

    public SignInPage enterEmail(String email){
        getElement(mailInput).sendKeys(email);
        LOG.info("Mail was entered.");
        return this;
    }

    public  SignInPage clickContinueButton(){
        getElement(continueButton).click();
        LOG.info("Continue button clicked.");
        return this;
    }

    public SignInPage enterPassword(String password){
        getElement(passwordInput).sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public  HomePage clickSignInButton(){
        getElement(signInButton).click();
        LOG.info("Sign in button clicked.");
        return new HomePage();
    }

    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Is 'Login Failed' error message displayed': '%s'",isDisplayed));
        return isDisplayed;
    }

    public boolean isSignInButtonClickable(){
        boolean isClickable = (isDisplayed(signInButton)&&isEnabled(signInButton));
        LOG.info(String.format("Sign in button was checked"));
        return isClickable;
    }
    public boolean isContinueButtonClickable(String asset){
        boolean isClickable = (isDisplayed(continueButton)&&isEnabled(continueButton));
        LOG.info(String.format("Continue button was checked with "+asset+" asset"));
        return isClickable;
    }

    public void verifyFailedLoginErrorMessageDisplayedWithHardAssert(){
        Assert.assertTrue(isLoginFailedErrorMessageDisplayed(),
                "'Hard assert login failed' error message is not displayed");
    }

    public SignInPage verifyFailedLoginErrorMessageDisplayedWithSoftAssert(){
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertTrue(isLoginFailedErrorMessageDisplayed(),
                "'Soft assert login failed' error message is not displayed");
        softAssertion.assertAll();
        return this;
    }

    public void verifySignInButtonClickable(){
        Assert.assertTrue(isSignInButtonClickable(),
                "'Assert failed' Sign in button is not clickable");
    }

    public SignInPage verifyContinueButtonWithSoftAssert(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(isContinueButtonClickable("Soft"), "'Soft assert failed' Continue button is clickable");
        softAssert.assertAll();
        return this;
    }

    public void verifyContinueButtonWithHardAssert(){
        Assert.assertFalse(isContinueButtonClickable("Hard"), "'Hard assert failed' Continue button is clickable");
    }

    public void verifyContinueButtonIsClickable(){
        Assert.assertTrue(isDisplayed(continueButton)&&isEnabled(continueButton), "Error continue button is not clickable");
    }

}
