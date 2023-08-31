import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SongTests extends BaseTest {

    @Test(description = "Homework 17 - addSongToPlaylist")
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

    private void verifySuccessMessage() {
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='alertify-logs top right']")));
        Assert.assertTrue(successBanner.isDisplayed());

    }

}
