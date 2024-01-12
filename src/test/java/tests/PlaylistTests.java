package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTests extends BaseTest {


    @Test(description = "renamePlaylist")
    public void renamePlaylist() {
        String newPlaylistName = "New Name";
        String successMessage = "Updated playlist \"New Name.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.typeNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.verifySuccessMessage(), successMessage);
    }


    @Test(description = "deletePlaylist")
    public void deletePlaylist(){
        String expectedPlaylistDeletedMessage = "Deleted playlist \"Bethany.\"";

        openLoginUrl();
        enterEmail("bethany85@gmail.com");
        enterPassword("AsherDrew0717!");
        clickSubmit();
        clickPlaylist();
        clickDelPlaylistBtn();
        clickOkToDel();
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);
    }















}
