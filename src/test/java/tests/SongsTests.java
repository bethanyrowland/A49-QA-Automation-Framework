package tests;

import org.testng.annotations.Test;

public class SongsTests extends BaseTest{
        @Test(description = "Add Song to Playlist")
    public void addSongToPlaylist() {
            openLoginUrl();
            enterEmail("bethany85@gmail.com");
            enterPassword("AsherDrew0717!");
            clickSubmit();
            searchInput();
            clickViewAllBtn();
            enterSongTitle();
            clickAddToBtn();
            choosePlaylist();
            verifySuccessMessage();


        }

}
