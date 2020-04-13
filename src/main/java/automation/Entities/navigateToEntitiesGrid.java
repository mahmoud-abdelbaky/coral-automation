package automation.Entities;

import automation.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class navigateToEntitiesGrid extends pageBase {
    public navigateToEntitiesGrid(WebDriver driver) {
        super(driver);
    }
@FindBy(xpath= "//a[@href='/entities']") WebElement Entities;



public void grid ()
{
    click(Entities);

}



}