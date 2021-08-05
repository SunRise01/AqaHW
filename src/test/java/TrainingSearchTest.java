import consts.CitiesNames;
import consts.CountriesNames;
import consts.CoursesNames;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.TrainingListPage;

public class TrainingSearchTest extends BaseTest{

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
                    .clickOnCourse(CoursesNames.JAVA)
                    .verifyAmountOfJavaCourses()
                    .uncheckActiveCourse()
                    .clickOnCourse(CoursesNames.RUBY)
                    .verifyAmountOfRubyCourses();

    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’")
    public void verifyTrainingSearchWithLocations(){
        new HomePage()
                .proceedToHomePage()
                    .clickSignInButton()
                    .enterEmail("ivanhorintest@gmail.com")
                    .clickContinueButton()
                    .enterPassword("ivanhorintestPassword")
                    .clickSignInButton()
                .clickTrainingListButton()
                    .disableBelarus()
                    .clickOnCountry(CountriesNames.UKRAINE)
                    .clickOnCity(CitiesNames.LVIV)
                    .verifyAmountOfCourses();
    }
}
