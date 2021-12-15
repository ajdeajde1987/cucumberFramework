package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public static WebDriver driver;



    public void openBrowser() throws IOException {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {


            case "chrome":
              //  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.setHeadless(true);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("invalid browser name");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }
    public static void sendText(WebElement element,String textToSend){//for the employee iD that is already provided
        element.clear();                                     //we are clearinig it and adding what we want
        element.sendKeys(textToSend);
    }
    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
        return wait;
    }
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }
    public static JavascriptExecutor getJSWExecuter(){//java script executor is inteface it does not need an object so no new
       JavascriptExecutor js=(JavascriptExecutor) driver;
       return js;
    }
    public static void jsClick(WebElement element){
        getJSWExecuter().executeScript("arguments[0].click()",element);

    }

    public static byte[] takeScreenshot(String fileName){
        TakesScreenshot ts=(TakesScreenshot) driver;

        byte[] picBytes=ts.getScreenshotAs(OutputType.BYTES);//added for cucumber

        File sourceFile=ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,new File(Constants.SCREENSHOT_FILEPATH +fileName+" "+getTimeStamp("yyyy-,,-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }
    public static String getTimeStamp(String pattern){
        Date date=new Date();
        //yyyy-mm-dd-hh-mm-ss-ms pattern
        //to format the date according to our choice we have a function

        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);

    }


    public void tearDown () {
        driver.quit();
    }
}


