package base;

import org.apache.log4j.Logger;


public class Reporter {
    private static final Logger LOGGER =Logger.getLogger(Reporter.class.getName());




    public static void log(String s) {printStdOut(s);}
    private static void  printStdOut (String message) {
        BaseTest.getTest().get().info(message);
        LOGGER.info(message);
    }
    public  static void  logFail(String s) {LOGGER.error(s);}
}
