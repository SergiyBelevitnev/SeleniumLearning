import base.BaseTest;
import base.Reporter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class TestAli extends BaseTest {


    @Test
    private void findBottomElement() {

        base.BaseTest.getDriver().get("https://best.aliexpress.com/?lan=ru");
        Reporter.log("open browser");
        String xpath = "//*[@id=\"home-just-for-you-area\"]/div[2]/ul/li[120]/a/div";
        scrollUntilElementIsVisible(xpath);

//        explicitWaitPresenceOfElement(xpath);
        WebElement element = base.BaseTest.getDriver().findElement(By.xpath(xpath));

        Reporter.log("clicking item");
        element.click();


        goSleep(5000);

//        element.submit();
//        Reporter.log("creating search");
//        goSleep(5000);
//       String xpathCloseButton = "/html/body/div[21]/div/div/a";
//       waitForPresenceOfElement(By.xpath("//*[@class='ui-window-bd']"));
////        Reporter.log("sleeping");
//        WebElement closeButton = base.BaseTest.getDriver().findElement(By.xpath(xpathCloseButton));
//        closeButton.click();
    }


}

///html/body/div[21]/
