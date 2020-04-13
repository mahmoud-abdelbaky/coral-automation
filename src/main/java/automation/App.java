package automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("https://coral-test.tech4health.io/");
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys("mahmoudbillingadmin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.className("btn")).click();
        Thread.sleep(3000);
driver.findElement(By.xpath("//a[@href='/entities']")).click();
        Thread.sleep(3000);
driver.findElement(By.xpath("//*[contains(@class, 'add-product-button')]")).click();

        List <WebElement> entity_typess  = driver.findElements(By.xpath("//personal-info/form/div[1]/div"));
        for(WebElement ty : entity_typess)
        {            Thread.sleep(2000);

            String type_name = ty.getText();
            System.out.println(type_name);
        }



    }
}
