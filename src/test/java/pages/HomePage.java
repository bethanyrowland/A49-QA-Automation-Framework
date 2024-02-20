package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By successMessage = By.cssSelector("div.success.show");
    By newPlaylistName = By.cssSelector(".playlist:nth-child(3)");


    public void clickPlaylist() {
        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists ul li:nth-child(3)")));
        newPlaylist.click();
    }
    public void typeNewPlaylistName(String newPlaylistName) {
        WebElement inputNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        inputNameField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        inputNameField.sendKeys(newPlaylistName);
        inputNameField.sendKeys(Keys.ENTER);
    }
    public String verifySuccessMessage() {
        return findElement(successMessage).getText();
    }
    public void doubleClickPlaylist() {
        doubleClick(newPlaylistName);
    }
    public void searchInput() {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("Dark Days");
    }
    public void choosePlaylist() {
        WebElement choosePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper li:nth-child(5)")));
        choosePlaylist.click();
    }
    public void enterSongTitle() {
        WebElement enterSongTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".search-results .song-item .title")));
        enterSongTitle.click();
    }
    public void clickViewAllBtn() {
        WebElement clickViewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='view-all-songs-btn']")));
        clickViewAllBtn.click();
    }
}
