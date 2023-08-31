import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test(description = "Homework 18 - playSong")
    public void playSong() {
        openLoginUrl();
        enterEmail("bethany85@gmail.com");
        enterPassword("AsherDrew0717!");
        clickSubmit();
        clickPlayNextSongBtn();
        verifySongBar();

    }

    private void verifySongBar() {
        WebElement songBars = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[alt='Sound bars']")));
        Assert.assertTrue(songBars.isDisplayed());
    }

    private void clickPlayNextSongBtn() {
        WebElement panel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.side.player-controls")));
        panel.click();
        WebElement playNextSongBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title = 'Play next song']")));
        playNextSongBtn.click();
        WebElement playBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        playBtn.click();
    }
}
