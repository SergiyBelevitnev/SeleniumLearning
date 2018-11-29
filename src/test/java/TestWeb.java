import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestWeb extends BaseTest {
    @Test
    public void chooseCneckbox(){

        base.BaseTest.getDriver().get("https://optovik.biz.ua/");
        String xpathCheckBox = "//*[@class='b-filter-list js-not-selected']/li[1]//*[@class='b-form-checkbox__input']";
        waitForPresenceOfElement(By.xpath(xpathCheckBox));
        selectCheckBox(xpathCheckBox);
        goSleep(8000);
    }
}
