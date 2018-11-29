//import base.BaseTest;
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class UsingExcel {
//
//    public void setUp() throws Exception {
//
//        BaseTest.getDriver().get(utilities.Constants.URL);
////        BaseTest.getDriver().findElement(By.xpath("//span[text()='Learn Now']")).click();
//        // Tell the code about the location of Excel file
//        utilities.ExcelUtility.setExcelFile(utilities.Constants.File_Path + utilities.Constants.File_Name, "LoginTests");
//    }
//
//    @DataProvider(name = "loginData")
//    public Object[][] dataProvider() {
//        Object[][] testData = utilities.ExcelUtility.getTestData("Invalid_Login");
//        return testData;
//    }
//
//    @Test(dataProvider="loginData")
//    public void testUsingExcel(String username, String password) throws Exception {
//        setUp();
//        // Click login button
//        base.BaseTest.getDriver().switchTo().frame(BaseTest.getDriver().findElement(By.xpath("//*[@id='login-frame-wraper']/iframe")));
//        base.BaseTest.getDriver().findElement(By.xpath("//*[@id=\"id-input-login\"]"));
//        Thread.sleep(2000);
//        // Enter username
//        base.BaseTest.getDriver().findElement(By.xpath("//*[@id=\"id-input-login\"]")).sendKeys(username);
//        // Enter password
//        base.BaseTest.getDriver().findElement(By.xpath("//*[@id=\"id-input-password\"]")).sendKeys(password);
//        // Click Login button
//        base.BaseTest.getDriver().findElement(By.xpath("/html/body/form/div[6]/button")).click();
//        Thread.sleep(2000);
//
//        // Find if error messages exist
////        boolean result = driver.findElements(By.xpath("//form[@id='new_user']//div[3]")).size() != 0;
////        Assert.assertTrue(result);
//    }
//
//
//}
