package automation.Entities;

import automation.pageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends pageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username") WebElement username;
    @FindBy(id = "password") WebElement password;
    @FindBy(id = "kc-login") WebElement submit;

    public void login()
    {


       /* WebElement d = driver.get(Utilities.credentials("testURL"));

        driver.findElement(By.id("username")).sendKeys(Utilities.credentials("BillingAdmin"));
        driver.findElement(By.id("password")).sendKeys(Utilities.credentials("passBillingAdmin"));
        driver.findElement(By.id("kc-login")).click();
*/
    }
}
