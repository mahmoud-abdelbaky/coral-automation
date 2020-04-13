package automation;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;

public class pageBase {
    public  WebDriverWait wait;
    public  Actions action;
    public  Select select;
    public  JavascriptExecutor jse;

    public pageBase(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, 15);
        this.jse =  (JavascriptExecutor)driver;
    }

    public void text(WebElement sendText, String value)
    {
        sendText.sendKeys(value);
    }
    public void click(WebElement clickOn)
    {
        clickOn.click();
    }

    public void clearText(WebElement clear)
    {
        clear.clear();
    }

}
