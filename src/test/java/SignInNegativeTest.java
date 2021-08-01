import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInNegativeTest extends BaseTest {


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
}
