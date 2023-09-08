package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.Assert;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;


    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public void openLoginUrl(String url) {
        driver.get(url);
    }
    public void quitBrowser(){
        driver.quit();
    }
    public WebElement findElement (By Locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
    }
    public void doubleClick (By locator){
        actions.doubleClick(findElement(locator)).perform();
    }
}
