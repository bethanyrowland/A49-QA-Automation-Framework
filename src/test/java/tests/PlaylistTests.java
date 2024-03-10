package tests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PlaylistTests extends BaseTest {

    @Test(priority = 2)
    public void renamePlaylist() {
        String newPlaylistName = "New Name";
        String successMessage = "Updated playlist \"New Name.\"";

        loginPage.loginCorrectCred();
        homePage.doubleClickPlaylist();
        homePage.typeNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.verifySuccessMessage(), successMessage);
    }
    @Test(priority = 1)
    public void addSongToPlaylist() {
        loginPage.loginCorrectCred();
        homePage.searchInput();
        songsPage.clickViewAllBtn();
        homePage.enterSongTitle();
        songsPage.clickAddToBtn();
        homePage.choosePlaylist();
        homePage.verifySuccessMessage();
    }
    @Test(priority = 3)
    public void deletePlaylist(){
        String expectedPlaylistDeletedMessage = "Deleted playlist \"New Name.\"";
        loginPage.loginCorrectCred();
        homePage.clickPlaylist();
        playlistPage.clickDelPlaylistBtn();
        playlistPage.clickOkToDel();
        Assert.assertEquals(playlistPage.getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);
    }
}
