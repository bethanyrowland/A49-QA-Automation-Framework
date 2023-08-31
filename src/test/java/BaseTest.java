import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public WebDriver driver = null;
//    public static String url = "https://qa.koel.app/";
    String url;
    WebDriverWait wait;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        url = BaseURL;
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void clickSubmit() {
        WebElement submitLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitLogin.click();
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    protected void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    protected void clickAddToBtn() {
        WebElement clickAddToBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='add-to-btn']")));
        clickAddToBtn.click();
    }

    protected void enterSongTitle() {
        WebElement enterSongTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".search-results .song-item .title")));
        enterSongTitle.click();
    }

    protected void clickViewAllBtn() {
        WebElement clickViewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='view-all-songs-btn']")));
        clickViewAllBtn.click();
    }

    protected void searchInput() {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("Dark Days");
    }

    protected void choosePlaylist() {
        WebElement choosePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper li:nth-child(5)")));
        choosePlaylist.click();
    }
}