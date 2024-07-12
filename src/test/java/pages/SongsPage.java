package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SongsPage extends BasePage{

    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void clickViewAllBtn() {
        WebElement clickViewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='view-all-songs-btn']")));
        clickViewAllBtn.click();
    }
    public void clickAddToBtn() {
        WebElement clickAddToBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='add-to-btn']")));
        clickAddToBtn.click();
    }

    public void verifyArtistName() {
        WebElement verifyArtistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[3]")));
        verifyArtistName.click();
    }
}
