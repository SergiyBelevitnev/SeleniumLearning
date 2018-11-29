package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance(String suiteName) {
        if (extent == null)
            createInstance(suiteName);

        return extent;
    }

    public static ExtentReports createInstance(String suiteName) {
        Date dNow = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("MM.dd.yyyy");

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter( suiteName+"-"+ft.format(dNow)+".html");



//        Date date = new Date();
//        DateTimeFormatter oldFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy", new Locale("en"));
//        LocalDate parsedDate = LocalDate.parse(date, oldFormat);
//        DateTimeFormatter newFormat = DateTimeFormatter.ISO_DATE;
//        String newDate = parsedDate.format(newFormat);
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter( suiteName+"-"+newDate+".html");


        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Acceptance Tests");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("erer");


        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }
}
