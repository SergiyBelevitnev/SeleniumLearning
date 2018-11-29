import base.BaseTest;
import base.Reporter;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtil;

public class DaraDrivenTestExcel extends BaseTest {

    @BeforeMethod
            public void setUp() {
        BaseTest.LaunchBrowser("chrome");
        getDriver().manage().window().maximize();
        getDriver().get("https://www.ukr.net");
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//*[@id='login-frame-wraper']/iframe")));

    }

    @DataProvider
    public Object[][] getLoginData() {
        Object data[][] = ExcelUtil.getTestData("login");
        return data;
    }

    @Test(dataProvider = "getLoginData")

    public void loginTest(String username, String password) {

        getDriver().findElement(By.xpath("//*[@id=\"id-input-login\"]")).sendKeys(username);
        getDriver().findElement(By.xpath("//*[@id=\"id-input-password\"]")).sendKeys(password);
        getDriver().findElement(By.xpath("/html/body/form/div[6]/button")).click();
        goSleep(8000);
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"id-logout\"]")).isDisplayed());
        if (isElementPresent(By.xpath("//*[@id=\"id-logout\"]"))) {
            Reporter.log("Username " + "'"+ username +"'" + " login test passed");
            BaseTest.getDriver().findElement(By.xpath("//*[@id=\"id-logout\"]")).click();

        } else Reporter.log("Username" + username + "login failed");
        getDriver().close();

    }

}
