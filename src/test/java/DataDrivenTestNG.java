import base.BaseTest;
import base.Reporter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ExcelUtil;

import static base.BaseTest.getDriver;
//https://github.com/SergiyBelevitnev/SeleniumLearning.git


public class DataDrivenTestNG extends BaseTest {

    @BeforeMethod
    public void setUp() {
        BaseTest.LaunchBrowser("chrome");
        getDriver().manage().window().maximize();
        getDriver().get("https://www.ukr.net");
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//*[@id='login-frame-wraper']/iframe")));

    }

    @DataProvider (name="TestData")
    public Object[][] getTestNGData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "belevitnev";
        data[0][1] = "3109703178";

        data[1][0] = "belevitnevalv";
        data[1][1] = "3109703178";

        data[2][0] = "belevitnevaov";
        data[2][1] = "3109703178";

        return data;
    }

    @Test(dataProvider = "TestData")

    public void loginTest(String username, String password) {


        getDriver().manage().window().maximize();
        getDriver().get("https://www.ukr.net");
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//*[@id='login-frame-wraper']/iframe")));

        getDriver().findElement(By.xpath("//*[@id=\"id-input-login\"]")).sendKeys(username);
        getDriver().findElement(By.xpath("//*[@id=\"id-input-password\"]")).sendKeys(password);
        getDriver().findElement(By.xpath("/html/body/form/div[6]/button")).click();
        goSleep(8000);
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"id-logout\"]")).isDisplayed());
        if (isElementPresent(By.xpath("//*[@id=\"id-logout\"]"))) {
            Reporter.log("Username " + "'"+ username +"'" + " login test passed");
            getDriver().findElement(By.xpath("//*[@id=\"id-logout\"]")).click();

        } else Reporter.log("Username" + username + "login failed");
        getDriver().close();

    }

}
