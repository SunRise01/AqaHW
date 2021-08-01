import consts.DP;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class EmailNegativeTest extends BaseTest {
    @Test(description = "Verify that user cant log in with incorrect email", dataProvider = "data-provider", dataProviderClass = DP.class)
    public void verifyCantLogInWithIncorrectMail(String email){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email)
                .verifyContinueButtonWithSoftAssert()
                .verifyContinueButtonWithHardAssert();
    }
}
