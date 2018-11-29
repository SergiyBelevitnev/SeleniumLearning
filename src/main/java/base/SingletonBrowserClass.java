package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonBrowserClass {

    // instance of singleton class
    private static SingletonBrowserClass instanceOfSingletonBrowserClass=null;


    private WebDriver driver;

    // Constructor
    private SingletonBrowserClass(){
        WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
    }

    // TO create instance of class
    public static SingletonBrowserClass getInstanceOfSingletonBrowserClass(){
        if(instanceOfSingletonBrowserClass==null){
            instanceOfSingletonBrowserClass = new SingletonBrowserClass();
        }
        return instanceOfSingletonBrowserClass;
    }

    // To get driver
    public WebDriver getDriver2()
    {
        return driver;
    }



}