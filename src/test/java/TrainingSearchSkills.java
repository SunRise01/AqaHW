import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.TrainingListPage;

public class TrainingSearchSkills extends BaseTest{
    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’")
    public void verifyTrainingSearchWithSkills(){
        new HomePage()
                .proceedToHomePage()
                    .clickSignInButton()
                    .enterEmail("ivanhorintest@gmail.com")
                    .clickContinueButton()
                    .enterPassword("ivanhorintestPassword")
                    .clickSignInButton()
                .clickTrainingListButton()
                    .disableBelarus()
                    .clickOnJavaCheckbox()
                    .verifyAmountOfJavaCourses()
                    .uncheckJava()
                    .clickOnRubyCheckbox()
                    .verifyAmountOfRubyCourses();

    }
}
