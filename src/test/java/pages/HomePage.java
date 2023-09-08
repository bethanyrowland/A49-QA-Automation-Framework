package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css = "[name='name']")
        WebElement inputNameField;
    @FindBy (css = "div.success.show")
        WebElement successMessage;

    By newPlaylistName = By.cssSelector(".playlist:nth-child(3)");

    public void typeNewPlaylistName(String newPlaylistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) inputNameField));
        inputNameField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        inputNameField.sendKeys(newPlaylistName);
        inputNameField.sendKeys(Keys.ENTER);
    }
    public String verifySuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) successMessage));
        return successMessage.getText();
    }
    public void doubleClickPlaylist() {
        doubleClick(newPlaylistName);
    }


}
