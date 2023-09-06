package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By submitBtn = By.cssSelector("button[type='submit']");
    By passwordInput = By.cssSelector("[type='password']");
    By emailInput = By.cssSelector("[type='email']");


    public void clickSubmit() {
        findElement(submitBtn).click();
    }

    public void enterPassword(String password) {
        findElement(passwordInput).click();
        findElement(passwordInput).clear();
        findElement(passwordInput).sendKeys(password);
    }

    public void enterEmail(String email) {
        findElement(emailInput).click();
        findElement(emailInput).clear();
        findElement(emailInput).sendKeys(email);
    }

    public void login(){
        enterEmail("bethany85@gmail.com");
        enterPassword("AsherDrew0717!");
        clickSubmit();
}

}
