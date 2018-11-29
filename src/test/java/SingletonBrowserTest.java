import base.SingletonBrowserClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public  class SingletonBrowserTest {
    @Test
    public static void singletonBrowserTest(){
    SingletonBrowserClass sbc1= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver = sbc1.getDriver2();
    driver.get("https://www.ukr.net");



    SingletonBrowserClass sbc2= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver2 = sbc2.getDriver2();
    driver2.get("https://www.google.com");
    driver.quit();


    }

}

