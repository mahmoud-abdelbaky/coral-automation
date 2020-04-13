package automation;

import com.google.common.io.Files;
import com.google.errorprone.annotations.Var;
import org.graalvm.compiler.lir.Variable;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.*;
import automation.utils.eventReporter;
import sun.tools.jconsole.Plotter;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class testBase {
    public static EventFiringWebDriver driver;
    String firefoxPath =  System.getProperty("user.dir")+"/Drivers/geckodriver";
    String chromePath = System.getProperty("user.dir")+"/Drivers/chromedriver";
 //  public static WebDriverWait wait = new WebDriverWait(driver, 10);

    @BeforeSuite
    @Parameters({"browser"})
    public void setupBrowser(@Optional("chrome") String webBrowser) throws IOException {


        if (webBrowser.equalsIgnoreCase("chrome"))
        {

            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new EventFiringWebDriver(new ChromeDriver(chromeOptions()));
        }
        else  if (webBrowser.equalsIgnoreCase("firefox"))
        {

            System.setProperty("webdriver.gecko.driver", firefoxPath);
            driver = new EventFiringWebDriver(new FirefoxDriver());
        }

        driver.register(new eventReporter());

        driver.get(Utilities.credentials("testURL"));

        driver.findElement(By.id("username")).sendKeys(Utilities.credentials("BillingAdmin"));
        driver.findElement(By.id("password")).sendKeys(Utilities.credentials("passBillingAdmin"));
        driver.findElement(By.id("kc-login")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

   /* @BeforeClass
    public void login () throws IOException {
        driver.get(Utilities.credentials("testURL"));

        driver.findElement(By.id("username")).sendKeys(Utilities.credentials("BillingAdmin"));
        driver.findElement(By.id("password")).sendKeys(Utilities.credentials("passBillingAdmin"));
        driver.findElement(By.id("kc-login")).click();
    }*/

 /*@BeforeClass
    public void userCredentials(  ) throws IOException {
        driver.get(Utilities.credentials("testURL"));
        driver.findElement(By.id("username")).sendKeys(Utilities.credentials("BillingAdmin"));
        driver.findElement(By.id("password")).sendKeys(Utilities.credentials("passBillingAdmin"));
        driver.findElement(By.id("kc-login")).click();
    }*/
/*@BeforeMethod(groups={""})
public void login()
{

}*/

    @AfterSuite(enabled = false)
    public void tearDown ()
    {
        driver.quit();
    }


    @AfterMethod
    public void screenShot(ITestResult result)
    {
        if(ITestResult.FAILURE == result.getStatus())
        {
            //var camera = (TakesScreenshot)driver;
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("Screenshots/" + result.getName()+"screenshots" + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }


    public ChromeOptions chromeOptions()
    {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("disable-infobars");
        opt.addArguments("start-maximized");
        opt.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        //opt.setHeadless(true);
       //opt.addArguments("--headless");
       // opt.addArguments("--disable-gpu");


        return opt;
    }

}