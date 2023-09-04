//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class Homework19 extends BaseTest {
//    @Test(description = "Homework 19 - deletePlaylist")
//    public void deletePlaylist(){
//        String expectedPlaylistDeletedMessage = "Deleted playlist \"Bethany.\"";
//
//        openLoginUrl();
//        enterEmail("bethany85@gmail.com");
//        enterPassword("AsherDrew0717!");
//        clickSubmit();
//        clickPlaylist();
//        clickDelPlaylistBtn();
//        clickOkToDel();
//        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);
//
//    }
//
//    public String getDeletedPlaylistMsg() {
//        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
//        return notificationMsg.getText();
//    }
//
//    private void clickOkToDel() {
//        WebElement delPlaylistMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
//        delPlaylistMessage.click();
//    }
//
//    private void clickDelPlaylistBtn() {
//        WebElement delPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Delete this playlist']")));
//        delPlaylistBtn.click();
//    }
//
//    private void clickPlaylist() {
//        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists ul li:nth-child(3)")));
//        newPlaylist.click();
//    }
//
//}
