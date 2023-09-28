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


public class RenamePlaylistStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    String newPlaylistName = "New Name";
    String successMessage = "Updated playlist \"New Name.\"";


    @Before
    public WebDriver launchBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }

    @After
        public void closeBrowser() {
            driver.quit();
        }


        @Given("I am logged in")
        public void login() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login();
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

