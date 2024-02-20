package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage{

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }
    public void clickOkToDel() {
        WebElement delPlaylistMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
        delPlaylistMessage.click();
    }
    public void clickDelPlaylistBtn() {
        WebElement delPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Delete this playlist']")));
        delPlaylistBtn.click();
    }
}
