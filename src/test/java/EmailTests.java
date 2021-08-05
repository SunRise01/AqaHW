import consts.DP;
import org.testng.annotations.Test;
import pageObjects.AbstractPage;
import pageObjects.HomePage;

public class EmailTests extends BaseTest {

    @Test(description = "Verify that user cant log in with incorrect email", dataProvider = "data-provider", dataProviderClass = DP.class)
    public void verifyCantLogInWithIncorrectMail(String email){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email)
                .verifyContinueButtonWithSoftAssert()
                .verifyContinueButtonWithHardAssert();
    }

    @Test(description = "Verify user can log in with correct email")
    public void verifyCanLogInWithIncorrectMail(){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("exaaaaaaexaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaample@xxx.xx")
                .verifyContinueButtonIsClickable();
    }
}
