package StepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import java.time.Duration;


public class RenamePlaylistStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    String newPlaylistName = "New Name";
    String successMessage = "Updated playlist \"New Name.\"";


    @Before
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://qa.koel.app/");
            }

    @After
        public void closeBrowser() {
            driver.quit();
        }


        @Given("I am logged in")
        public void login() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginCorrectCred();
        }

        @When("I double click on playlist")
        public void doubleClickPlaylist() {
            HomePage homePage = new HomePage(driver);
            homePage.doubleClickPlaylist();
        }

        @And("I type new playlist name")
        public void typeNewPlaylistName() {
            HomePage homePage = new HomePage(driver);
            homePage.typeNewPlaylistName(newPlaylistName);
        }

        @Then("playlist is renamed successfully")
        public void verifySuccessMessage() {
            HomePage homePage = new HomePage(driver);
            Assert.assertEquals(homePage.verifySuccessMessage(), successMessage);
        }

    }

