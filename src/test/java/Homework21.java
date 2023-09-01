import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String newPlaylistName = "New Name";

    @Test(description = "Homework 20 - Rename Playlist")
    public void renamePlaylist() {
        String successMessage = "Updated playlist \"Bethan.\"";

        openLoginUrl();
        enterEmail("bethany85@gmail.com");
        enterPassword("AsherDrew0717!");
        clickSubmit();
        doubleClickPlaylist();
        typeNewPlaylistName();
        verifySuccessMessage();

            }

    private void typeNewPlaylistName() {
        WebElement inputNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        inputNameField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        inputNameField.sendKeys(newPlaylistName);
        inputNameField.sendKeys(Keys.ENTER);
    }

    private void verifySuccessMessage() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    private void doubleClickPlaylist() {
        WebElement playlist =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlist).perform();
    }
}

//*[@class='existing-playlists']//li[contains(text(), 'Bethany')]
//*[@data-testid='playlist-context-menu-edit-69759']