import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test(description = "Homework 19 - deletePlaylist")
    public void deletePlaylist() throws InterruptedException{
        String expectedPlaylistDeletedMessage = "Deleted playlist \"Bethany.\"";

        openLoginUrl();
        enterEmail("bethany85@gmail.com");
        enterPassword("AsherDrew0717!");
        clickSubmit();
        Thread.sleep(3000);
        clickPlaylist();
        clickDelPlaylistBtn();
        clickOkToDel();
        Thread.sleep(3000);
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);


    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }

    private void clickOkToDel() {
        WebElement delPlaylistMessage = driver.findElement(By.cssSelector("button.ok"));
        delPlaylistMessage.click();
    }

    private void clickDelPlaylistBtn() throws InterruptedException {
        WebElement delPlaylistBtn = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        delPlaylistBtn.click();
        Thread.sleep(2000);
    }

    private void clickPlaylist() {
        WebElement newPlaylist = driver.findElement(By.cssSelector("#playlists ul li:nth-child(3)"));
        newPlaylist.click();
    }

    private void verifySongBar() {
        WebElement songBars = driver.findElement(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(songBars.isDisplayed());
    }

    private void clickPlayBtn() {
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']");
        playBtn.click();
    }

    private void clickPlayNextSongBtn() {
        WebElement playNextSongBtn = driver.findElement(By.cssSelector("[title = 'Play next song']"));
        playNextSongBtn.click();
    }
}
