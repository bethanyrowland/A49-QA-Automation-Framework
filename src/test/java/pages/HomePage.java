package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By inputNameField = By.cssSelector("[name='name']");
    By successMessage = By.cssSelector("div.success.show");

    By newPlaylistName = By.cssSelector(".playlist:nth-child(3)");



    public void typeNewPlaylistName(String newPlaylistName) {
        findElement(inputNameField).sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        findElement(inputNameField).sendKeys(newPlaylistName);
        findElement(inputNameField).sendKeys(Keys.ENTER);
    }
    public String verifySuccessMessage() {
        return findElement(successMessage).getText();
    }

    public void doubleClickPlaylist() {
        doubleClick(newPlaylistName);
    }


}
