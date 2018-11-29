import base.BaseTest;
import base.Reporter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestAli3 extends BaseTest {
    @Test

    private void testAli3() {

        base.BaseTest.getDriver().get("https://best.aliexpress.com/?lan=ru");

        Reporter.log("open browser");
        String pathCategory = "//*[@id=\"home-firstscreen\"]/div/div[2]/div/div[2]/dl[3]/dt/span/a";
        String pathExample = "//*[@id=\"home-firstscreen\"]/div/fd/div[2]/div/div[2]/dl[3]/dt/span/a";
        By by2 = new By.ByXPath(pathExample);
        Boolean b = isElementPresent(by2);
        String s = String.valueOf(b);

        System.out.println(s);

        moveToElement(pathCategory);
        goSleep(10000);


        explicitWaitPresenceOfElement(pathCategory);
        WebElement element = base.BaseTest.getDriver().findElement(By.xpath(pathCategory));

        Reporter.log("clicking item");
        element.click();






        goSleep(10000);
//        WebElement element2 = base.BaseTest.getDriver().findElement(By.xpath("//*[@id=\"we-wholesale-category-list\"]/div[19]/div/div/a"));
//        element2.click();
//        Alert alert = BaseTest.getDriver().switchTo().alert();
//        selectCheckBox("//*[@id=\"linkFreeShip\"]/i");
//
//        alert.dismiss();
        Reporter.log("sleeping");
    }

}
