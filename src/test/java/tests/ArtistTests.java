package tests;
import org.testng.annotations.Test;

public class ArtistTests extends BaseTest{

    @Test
    public void artistNameInApp() {
    loginPage.loginCorrectCred();
    homePage.clickAllSongsTab();
    songsPage.verifyArtistName();
    }

    @Test
    public void artistNameAppearsInSearchField(){
    loginPage.loginCorrectCred();
    homePage.searchArtistInSearchField();




}


}
