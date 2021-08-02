package pageObjects;

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

    public TrainingListPage clickOnJavaCheckbox(){
        actionProvider.moveToElement(getElement(divWithCourses)).perform();
        getElement(trainingSearch).click();
        LOG.info(String.format("Moved to training search"));
        getElement(searchBySkills).click();
        LOG.info(String.format("Clicked on skills"));
        getElement(javaCheckbox).click();
        LOG.info(String.format("Clicked on java checkbox"));
        getElement(trainingSearch).click();
        return this;
    }

    public TrainingListPage verifyAmountOfJavaCourses(){
        List<WebElement> javaCoursesList = getElements("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__title ng-binding']");
        Assert.assertTrue(javaCoursesList.size()==18, "Error, wrong amount of Java courses");
        LOG.info(String.format("Checked amount of java courses"));
        return this;
    }

    public TrainingListPage uncheckJava(){
        actionProvider.moveToElement(getElement(divWithCourses)).perform();
        LOG.info(String.format("Moved to training search"));
        getElement(activeCheckbox).click();
        LOG.info(String.format("Disabled java"));
        return this;
    }

    public TrainingListPage clickOnRubyCheckbox(){
        actionProvider.moveToElement(getElement(divWithCourses)).perform();
        getElement(trainingSearch).click();
        LOG.info(String.format("Moved to training search"));
        actionProvider.moveToElement(getElement(rubyCheckbox)).click().perform();
        LOG.info(String.format("Clicked on ruby checkbox"));
        getElement(trainingSearch).click();
        return this;
    }

    public TrainingListPage verifyAmountOfRubyCourses(){
        List<WebElement> rubyCoursesList = getElements("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__title ng-binding']");
        Assert.assertTrue(rubyCoursesList.size()==0, "Error, wrong amount of Ruby courses");
        LOG.info(String.format("Checked amount of ruby courses"));
        return this;
    }
}
