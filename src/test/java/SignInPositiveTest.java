import org.testng.annotations.Test;
import pageObjects.HomePage;

public class SignInPositiveTest extends BaseTest{

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
}
