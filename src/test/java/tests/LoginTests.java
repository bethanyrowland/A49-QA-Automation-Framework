package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
        @Test(description = "Login with Empty Email and Password Fields")
    public void loginEmptyEmailPassword() {

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();

    }
}
