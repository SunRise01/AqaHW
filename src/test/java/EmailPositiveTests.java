import org.testng.annotations.Test;
import pageObjects.AbstractPage;
import pageObjects.HomePage;

public class EmailPositiveTests extends BaseTest {
    @Test(description = "Verify user can log in with correct email")
    public void verifyCanLogInWithIncorrectMail(){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("exaaaaaaexaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaample@xxx.xx")
                .verifyContinueButtonIsClickable();
    }
}
