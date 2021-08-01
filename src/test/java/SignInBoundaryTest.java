import org.testng.annotations.Test;
import pageObjects.HomePage;

public class SignInBoundaryTest extends BaseTest{


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
