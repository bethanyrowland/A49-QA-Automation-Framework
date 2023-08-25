import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test(description = "Homework 18 - playSong")
    public void playSong() throws InterruptedException{
        openLoginUrl();
        enterEmail("bethany85@gmail.com");
        enterPassword("AsherDrew0717!");
        clickSubmit();
        Thread.sleep(3000);
        clickPlayNextSongBtn();
        clickPlayBtn();
        verifySongBar();





    }

    private void verifySongBar() {
        WebElement songBars = driver.findElement(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(songBars.isDisplayed());
    }

    private void clickPlayBtn() {
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playBtn.click();
    }

    private void clickPlayNextSongBtn() {
        WebElement playNextSongBtn = driver.findElement(By.cssSelector("[title = 'Play next song']"));
        playNextSongBtn.click();
    }
}
