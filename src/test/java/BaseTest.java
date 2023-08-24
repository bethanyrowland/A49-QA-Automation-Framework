import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    protected void clickSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    protected void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    protected void clickAddToBtn() {
        WebElement clickAddToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        clickAddToBtn.click();
    }

    protected void enterSongTitle() {
        WebElement enterSongTitle = driver.findElement(By.cssSelector(".search-results .song-item .title"));
        enterSongTitle.click();
    }

    protected void clickViewAllBtn() {
        WebElement clickViewAllBtn = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        clickViewAllBtn.click();
    }

    protected void searchInput() {
        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("Dark Days");
    }

    protected void choosePlaylist() {
        WebElement choosePlaylist = driver.findElement(By.cssSelector("#songResultsWrapper li:nth-child(5)"));
        choosePlaylist.click();
    }
}