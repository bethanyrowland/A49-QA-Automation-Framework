package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        findElement(submitBtn);
        submitBtn.click();
    }

    public void enterPassword(String password) {
        findElement(passwordInput);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        findElement(emailInput);
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
