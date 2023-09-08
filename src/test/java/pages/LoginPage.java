package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy (css = "button[type='submit']")
        WebElement submitBtn;

    @FindBy (css = "[type='password']")
        WebElement passwordInput;

    @FindBy (css = "[type='email']")
            WebElement emailInput;


    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void login(){
        enterEmail("bethany85@gmail.com");
        enterPassword("AsherDrew0717!");
        clickSubmit();
}

}
