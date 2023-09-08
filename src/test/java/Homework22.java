//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pages.HomePage;
//import pages.LoginPage;
//import pages.BasePage;
//
//public class Homework22 extends BaseTest {
//
//    @Test(description = "Homework 22 - POM Rename Playlist")
//    public void renamePlaylist() {
//        String newPlaylistName = "New Name";
//        String successMessage = "Updated playlist \"New Name.\"";
//
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);
//        BasePage basePage = new BasePage(driver);
//
//        loginPage.login();
//        homePage.doubleClickPlaylist();
//        homePage.typeNewPlaylistName(newPlaylistName);
//        Assert.assertEquals(homePage.verifySuccessMessage(), successMessage);
//
//    }
//
//
//}

