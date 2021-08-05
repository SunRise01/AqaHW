import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInTest extends BaseTest{

    @Test(description = "Verify user can successfully log in")
    public void canLogIn() {
        new HomePage()
                .proceedToHomePage()
                    .clickSignInButton()
                    .enterEmail("ivanhorintest@gmail.com")
                    .clickContinueButton()
                    .enterPassword("ivanhorintestPassword")
                    .clickSignInButton()
                .verifyUserIsLoggedIn();
    }

    @Test(description = "Verify error message appears when user logging in with inappropriate credentials.")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("incorrectmail@gmail.com")
                .clickContinueButton()
                .enterPassword("incorrectPassword")
                .clickSignInButton();
        new SignInPage()
                .verifyFailedLoginErrorMessageDisplayedWithSoftAssert()
                .verifyFailedLoginErrorMessageDisplayedWithHardAssert();

    }

    @Test(description = "Verify password input can take 8 symbols")
    public void verifyPasswordInputWithBoundaryValues() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("incorrectmail@gmail.com")
                .clickContinueButton()
                .enterPassword("12345678")
                .verifySignInButtonClickable();
    }
}
