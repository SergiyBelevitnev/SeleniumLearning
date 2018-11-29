import base.BaseTest;
import base.Reporter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import  org.apache.poi.hssf.usermodel.HSSFCell;
import utils.Enums;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class ApacheTest extends BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    HSSFWorkbook workbook;
    HSSFSheet spreadsheet;
    HSSFCell cell;
    public static String bookName = "createworkbook999.xlsx";;


    @Test
    public static void createBook() throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet spreadsheet = workbook.createSheet("Sheet 1");

//        String bookName;


        FileOutputStream out = new FileOutputStream(new File(bookName));
        Row row = spreadsheet.createRow(0);
        row.createCell(0).setCellValue("belevitnev");
        row.createCell(1).setCellValue("3109703178");
        workbook.write(out);
        out.close();
    }
//
//
//
//
    @Test
    public void ReadData() throws IOException
    {
//        String bookName;
//        this.bookName = bookName;
        File src=new File(bookName);
        FileInputStream finput = new FileInputStream(src);
        workbook = new HSSFWorkbook(finput);
        spreadsheet= workbook.getSheetAt(0);

        Row row = spreadsheet.getRow(0);
        Cell cell = row.getCell(0);
        base.BaseTest.getDriver().get("https://www.ukr.net");
        base.BaseTest.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        base.BaseTest.getDriver().switchTo().frame(BaseTest.getDriver().findElement(By.xpath("//*[@id='login-frame-wraper']/iframe")));
        base.BaseTest.getDriver().findElement(By.xpath("//*[@id=\"id-input-login\"]")).sendKeys(cell.getRichStringCellValue().getString());
        Cell cell1 = row.getCell(1);
        base.BaseTest.getDriver().findElement(By.xpath("//*[@id=\"id-input-password\"]")).sendKeys(cell1.getRichStringCellValue().getString());
        base.BaseTest.getDriver().findElement(By.xpath("/html/body/form/div[6]/button")).click();
        goSleep(8000);

        }
}

