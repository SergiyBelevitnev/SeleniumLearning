import base.BaseTest;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Test2 extends BaseTest {



    @Test

    private void waitForpresence() {

        base.BaseTest.getDriver().get("https://optovik.biz.ua/");
        Reporter.log("open browser");
        waitForPresenceOfElement(By.xpath("//*[.='Мелкая бытовая техника']/preceding-sibling:: *"));
        WebElement element = base.BaseTest.getDriver().findElement(By.xpath("//*[.='Мелкая бытовая техника']/preceding-sibling:: *"));

        Reporter.log("find element");
        element.click();
        Reporter.log("clicking category");

        WebElement element2 = BaseTest.getDriver().findElement(By.xpath("//*[@id=\"link_to_product_221829002\"]"));
        element2.click();
        Reporter.log("clicking item");

//        element.submit();
//        Reporter.log("creating search");
        goSleep(8000);

    }
}
