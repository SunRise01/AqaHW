package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BlogPage extends AbstractPage{
    private static final Logger LOG = Logger.getLogger(HomePage.class);
    private By activeNavLink = By.xpath("//a[@class='tab-nav__item ng-scope active']");
    List <WebElement> navLinks = getElements("//a[@class='tab-nav__item ng-scope active']");

    public BlogPage verifyActiveLink(){
        Assert.assertTrue(getElement(activeNavLink).isDisplayed(), "Error, active link is not found");
        LOG.info("Verifyed active link");
        return this;
    }

    public void verifyNavLinks(){
        boolean linksIsDisplayed=true;
        for (int i = 1; i <= 5; i++) {
            if(navLinks.get(i).isDisplayed()) linksIsDisplayed=false;
        }
        Assert.assertTrue(linksIsDisplayed, "Error, Links is not displayed");
        LOG.info("Verifyed not active links");
    }
}
