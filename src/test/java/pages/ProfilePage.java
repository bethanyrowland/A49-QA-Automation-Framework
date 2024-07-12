package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage{

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void enterCurrentPassword() {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#inputProfileCurrentPassword")));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("how!e123456");
    }

    public void enterNewPassword(){
        WebElement newPasswordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#inputProfileNewPassword")));
        newPasswordField.click();
        newPasswordField.clear();
        newPasswordField.sendKeys("how!e1234");
    }

    public void clickOnSaveBtn(){
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='profileWrapper']/div/form/div[5]/button")));
        saveButton.click();
    }

    public String getNewPasswordSuccessMsg() {
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        return successMsg.getText();
    }

    public String getNewPasswordErrorMsg(){
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error.show")));
        return errorMsg.getText();
    }
}









