package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.*;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import static base.BaseTest.getDriver;

public class Listeners implements IInvokedMethodListener, ITestListener {
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.logFail("Test failed");
        String methodName = result.getMethod().getMethodName();
        String testName = result.getMethod().getXmlTest().getName();
        captureScreenshot(methodName, testName, result);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    public void captureScreenshot(String methodName, String testName, ITestResult testResult) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy MM d");
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Kiev"));
        String currentDate = dateFormat.format(calendar.getTime());
        String timeIdentificator = new SimpleDateFormat("HH_mm_ss").format(calendar.getTime());

        String fileName = methodName + timeIdentificator + ".png";
        String filePath = System.getProperty("user.dir") + File.separator
                + "target" + File.separator + "result" + File.separator
                + testName + File.separator + currentDate + File.separator;

        try {
            WebDriver augmentedDriver = new Augmenter().augment(getDriver());
            File screenshot = ((TakesScreenshot) augmentedDriver)
                    .getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(filePath + fileName));

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}