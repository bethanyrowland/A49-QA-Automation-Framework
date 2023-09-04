import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.BasePage;

import java.time.Duration;


public class BaseTest {

    public WebDriver driver = null;
    public static Actions actions = null;
    public String url = "https://qa.koel.app/";
    public WebDriverWait wait;
    BasePage basePage;
    HomePage homePage;
    LoginPage loginPage;



    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        basePage = new BasePage(driver);
        basePage.openLoginUrl(url);
    }

    @AfterClass
    public void closeBrowser(){
        basePage.quitBrowser();
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