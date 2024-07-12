package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sprint1Tests extends BaseTest{

    @Test
    public void updateUserPassword(){
        String expectedSuccessMessage = "Profile updated.";
        loginPage.loginCorrectCred();
        homePage.clickOnProfile();
        profilePage.enterCurrentPassword();
        profilePage.enterNewPassword();
        profilePage.clickOnSaveBtn();
        Assert.assertEquals(profilePage.getNewPasswordSuccessMsg(), expectedSuccessMessage);
    }

    @Test
    public void userCanLoginWithNewPassword(){
        loginPage.enterEmail("bethany85@gmail.com");
        loginPage.enterPassword("How!e123456");
        Assert.assertEquals(homeUrl, "https://qa.koel.app/#!/home");
    }

    @Test
    public void userCannotLoginWithOldPassword(){
        loginPage.enterEmail("bethany85@gmail.com");
        loginPage.enterPassword("AsherDrew0717!");
        Assert.assertEquals(url,"https://qa.koel.app/");
    }

    @Test
    public void cannotCreatePasswordWith9Chars(){
        String expectedErrorMessage= "The new password must be at least 10 characters.";
        loginPage.enterEmail("bethany85@gmail.com");
        loginPage.enterPassword("how!e123456");
        loginPage.clickSubmit();
        homePage.clickOnProfile();
        profilePage.enterCurrentPassword();
        profilePage.enterNewPassword();
        profilePage.clickOnSaveBtn();
        Assert.assertEquals(profilePage.getNewPasswordErrorMsg(), expectedErrorMessage);
    }

}
