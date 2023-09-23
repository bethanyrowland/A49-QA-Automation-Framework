
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.BasePage;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;


public class BaseTest {

    public WebDriver driver = null;
//    public static Actions actions = null;
    public String url = "https://qa.koel.app/";
//    public WebDriverWait wait;
//    BasePage basePage;
//    HomePage homePage;
//    LoginPage loginPage;


        @BeforeMethod
        public void launchBrowser() throws MalformedURLException {
            String browser = System.getProperty("browser");
            driver = setupBrowser(browser);
            driver.get(url);
        }
//
//        public void launchBrowser () {
//            basePage = new BasePage(driver);
//            basePage.openLoginUrl(url);
//        }

        WebDriver setupBrowser(String browser) throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            String gridURL = "http://192.168.0.25:4444";
            switch (browser) {
                case "chrome":
                    return setupChrome();
                case "edge":
                    return setupEdge();
                case "grid-chrome":
                    caps.setCapability("browserName", "chrome");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                case "grid-edge":
                    caps.setCapability("browserName", "edge");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                case "cloud":
                    return setupLambda();
                default:
                    return setupChrome();
            }
        }
//
//    protected void clickAddToBtn() {
//        WebElement clickAddToBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='add-to-btn']")));
//        clickAddToBtn.click();
//    }
//
//    protected void enterSongTitle() {
//        WebElement enterSongTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".search-results .song-item .title")));
//        enterSongTitle.click();
//    }
//
//    protected void clickViewAllBtn() {
//        WebElement clickViewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='view-all-songs-btn']")));
//        clickViewAllBtn.click();
//    }
//
//    protected void searchInput() {
//        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
//        searchInput.click();
//        searchInput.clear();
//        searchInput.sendKeys("Dark Days");
//    }
//
//    protected void choosePlaylist() {
//        WebElement choosePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper li:nth-child(5)")));
//        choosePlaylist.click();
//    }
    public WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }
    public WebDriver setupEdge() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }
    public WebDriver setupLambda() throws MalformedURLException {
        String hubURL ="https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("118.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "bethany.rowland85");
        ltOptions.put("accessKey", "1GjL4tiCi5ztEZ2gnNpcRBlZivbeLMw9cmfBHBgi6nIjFsyCmM");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    @AfterMethod
    public void closeBrowser () {
        driver.quit();
    }
}