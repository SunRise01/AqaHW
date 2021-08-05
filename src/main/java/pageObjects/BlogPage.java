package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class BlogPage extends AbstractPage{
    private static final Logger LOG = Logger.getLogger(HomePage.class);
    private By newsLink = By.xpath("//a[@href='#!/News/Category/news']");
    private By realStoriesLink = By.xpath("//a[@href='#!/News/Category/real-stories']");
    private By materialsLink = By.xpath("//a[@href='#!/News/Category/materials']");
    private By hardSkillsLink = By.xpath("//a[@href='#!/News/Category/hard-skills']");
    private By softSkillsLink = By.xpath("//a[@href='#!/News/Category/soft-skills']");
    private By eventsLink = By.xpath("//a[@href='#!/News/Category/events']");

    public void verifyNavLinks(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getElement(newsLink).isDisplayed());
        LOG.info("News link is checked");
        softAssert.assertTrue(getElement(realStoriesLink).isDisplayed());
        LOG.info("Real stories link is checked");
        softAssert.assertTrue(getElement(materialsLink).isDisplayed());
        LOG.info("Materials link is checked");
        softAssert.assertTrue(getElement(hardSkillsLink).isDisplayed());
        LOG.info("Hard skills link is checked");
        softAssert.assertTrue(getElement(softSkillsLink).isDisplayed());
        LOG.info("Soft skills link is checked");
        softAssert.assertTrue(getElement(eventsLink).isDisplayed());
        LOG.info("Events link is checked");
        softAssert.assertAll();
    }
}
