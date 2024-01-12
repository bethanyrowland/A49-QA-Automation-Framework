package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaylistPage extends BasePage{

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }

    private void clickOkToDel() {
        WebElement delPlaylistMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
        delPlaylistMessage.click();
    }

    private void clickDelPlaylistBtn() {
        WebElement delPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Delete this playlist']")));
        delPlaylistBtn.click();
    }

    private void clickPlaylist() {
        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists ul li:nth-child(3)")));
        newPlaylist.click();
    }

    private void verifySuccessMessage() {
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='alertify-logs top right']")));
        Assert.assertTrue(successBanner.isDisplayed());













}
