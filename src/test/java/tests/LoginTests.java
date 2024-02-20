package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test
    public void loginValidEmailPasswordTest (){
        loginPage.loginCorrectCred();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void loginEmailInvalidPassword() {
        loginPage.enterEmail("bethany85@gmail.com");
        loginPage.enterPassword("InvalidPassword");
        loginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
