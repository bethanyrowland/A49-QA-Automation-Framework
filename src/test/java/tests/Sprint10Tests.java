package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sprint10Tests extends BaseTest {

    @Test
    public void welcomeMessageDisplayedOnHomepage() {
        loginPage.loginCorrectCred();
        homePage.verifyWelcomeMessage();
    }

    @Test
    public void searchBarIsWorking(){
        loginPage.loginCorrectCred();
        homePage.enterTextInSearchField();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/#!/search");
    }








}
