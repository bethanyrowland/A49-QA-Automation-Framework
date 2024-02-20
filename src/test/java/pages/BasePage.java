package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }
    public void navigateToPage(String url){
        driver.get(url);
    }
    public WebElement findElement (By Locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
    }
    public void doubleClick (By locator){
        actions.doubleClick(findElement(locator)).perform();
    }
    public void quitBrowser(){
        driver.quit();
    }
    }










//    public void verifySuccessMessage() {
//        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='alertify-logs top right']")));
//        Assert.assertTrue(successBanner.isDisplayed());
//    }