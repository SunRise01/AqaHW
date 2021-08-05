package pageObjects;

import consts.CitiesNames;
import consts.CountriesNames;
import consts.CoursesNames;
import driver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import java.util.List;

import static java.lang.Thread.sleep;

public class TrainingListPage extends AbstractPage{
    private static final Logger LOG = Logger.getLogger(HomePage.class);
    private By trainingSearch = By.xpath("//form[@class='training-search-form ng-pristine ng-valid ng-scope']");
    private By searchBySkills = By.xpath("//div[@class='navigation-item ng-binding' and contains(text(), 'By skills')]");
    private By searchByLocations = By.xpath("//div[@class='navigation-item ng-binding' and contains(text(), 'By locations')]");
    private By activeCheckbox = By.xpath("//span[@class='filter-field__input-item-close-icon']");
    private By divWithCourses = By.xpath("//div[@class='training-list__container training-list__desktop']");
    private By javaCheckbox = By.xpath("//label[normalize-space()='Java']/span");
    private By rubyCheckbox = By.xpath("//label[normalize-space()='Ruby']/span");
    Actions actionProvider = new Actions(DriverFactory.getDriver());

    public TrainingListPage disableBelarus(){
        actionProvider.moveToElement(getElement(activeCheckbox)).click().perform();
        LOG.info(String.format("Disabled belarus"));
        return this;
    }

    public TrainingListPage clickOnCourse(CoursesNames courseName){
        actionProvider.moveToElement(getElement(trainingSearch)).perform();
        getElement(trainingSearch).click();
        LOG.info(String.format("Moved to training search"));
        getElement(searchBySkills).click();
        LOG.info(String.format("Clicked on skills"));

        LOG.info("Chosen course is "+ courseName.getCourseName());
        getElement((By.xpath
                ("//label[@class='location__not-active-label ng-binding'][normalize-space()='"
                        + courseName.getCourseName() + "']//span[@class='checkmark']"))).click();
        LOG.info("Clicked on course");
        getElement(trainingSearch).click();
        return this;
    }

    public TrainingListPage uncheckActiveCourse(){
        actionProvider.moveToElement(getElement(trainingSearch)).perform();
        LOG.info(String.format("Moved to training search"));
        getElement(activeCheckbox).click();
        LOG.info(String.format("Disabled java"));
        getElement(trainingSearch).click();
        getElement(searchByLocations).click();
        LOG.info("Clicked on locations");
        getElement(trainingSearch).click();
        LOG.info("Clicked on training search");
        return this;
    }

    public TrainingListPage verifyAmountOfJavaCourses(){
        List<WebElement> javaCoursesList = getElements("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__title ng-binding']");
        Assert.assertTrue(javaCoursesList.size()==18, "Error, wrong amount of Java courses");
        LOG.info(String.format("Checked amount of java courses"));
        return this;
    }

    public TrainingListPage verifyAmountOfRubyCourses(){
        Assert.assertTrue(getElement(By.xpath("//span[contains(text(), 'No training are available.')]")).isDisplayed(), "Error, wrong amount of Ruby courses");
        LOG.info(String.format("Checked error message on ruby courses"));
        return this;
    }

    public TrainingListPage clickOnCountry(CountriesNames countryName){
        actionProvider.moveToElement(getElement(trainingSearch)).click().perform();
        LOG.info(String.format("Moved to training search"));
        getElement(By.xpath("//div[contains(text(), '"+countryName.getCountryName()+"')]")).click();
        LOG.info("Clicked on "+countryName.getCountryName());
        return this;
    }

    public TrainingListPage clickOnCity(CitiesNames cityName){
        getElement(By.xpath("//label[@class='location__not-active-label ng-binding'][normalize-space()='"+cityName.getCityName()+"']//span[@class='checkmark']")).click();
        LOG.info("Clicked on "+cityName);
        getElement(trainingSearch).click();
        return this;
    }
    public void verifyAmountOfCourses(){
        List<WebElement> coursesList = getElements("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__title ng-binding']");
        Assert.assertTrue(coursesList.size()==9, "Error, wrong amount of courses");
        LOG.info(String.format("Checked amount of courses"));
    }
}
