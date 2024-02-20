package tests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PlaylistTests extends BaseTest {

    @Test
    public void renamePlaylist() {
        String newPlaylistName = "New Name";
        String successMessage = "Updated playlist \"New Name.\"";

        loginPage.loginCorrectCred();
        homePage.doubleClickPlaylist();
        homePage.typeNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.verifySuccessMessage(), successMessage);
    }
    @Test
    public void addSongToPlaylist() {
        loginPage.loginCorrectCred();
        loginPage.clickSubmit();
        homePage.searchInput();
        songsPage.clickViewAllBtn();
        homePage.enterSongTitle();
        songsPage.clickAddToBtn();
        homePage.choosePlaylist();
        homePage.verifySuccessMessage();
    }
    @Test
    public void deletePlaylist(){
        String expectedPlaylistDeletedMessage = "Deleted playlist \"Bethany.\"";
        loginPage.loginCorrectCred();
        loginPage.clickSubmit();
        homePage.clickPlaylist();
        playlistPage.clickDelPlaylistBtn();
        playlistPage.clickOkToDel();
        Assert.assertEquals(playlistPage.getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);
    }
}
