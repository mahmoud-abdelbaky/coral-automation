package automation.Entities;

import automation.pageBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class addAggregatorEntity extends pageBase {
    private static String type_name;
    public addAggregatorEntity(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath= "//a[@href='/entities']") WebElement Entities;

    @FindBy(xpath="//*[contains(@class, 'add-product-button')]") WebElement add_new_entity;
    @FindBy(xpath="//personal-info/form/div[1]/div/mat-checkbox/label") List <WebElement> entity_types;
    @FindBy(xpath="(//div[@class='mat-form-field-infix']/input)[1]") WebElement Name;
    @FindBy(xpath="(//div[@class='mat-form-field-infix']/input)[2]") WebElement Email;
    @FindBy(xpath="(//div[@class='mat-form-field-infix']/input)[3]") WebElement Billing_Email;
    @FindBy(xpath="//*[contains(@class, 'content p-24')]/personal-info/form/div[4]/div[2]/kendo-textbox-container/kendo-maskedtextbox/input") WebElement default_TAXID;
    @FindBy(xpath="//*[contains(@class, 'content p-24')]/personal-info/form/div[5]/div/mat-checkbox/label/div") WebElement Active_Entity;
    @FindBy(xpath="//*[contains(@class, 'content p-24')]/personal-info/form/div[4]/div[3]/kendo-textbox-container/kendo-maskedtextbox/input") WebElement Default_Phone;



    //Entity Type = TPA, Provider, and/or aggregator
    @FindBy(xpath="//*[text()='TPA']//ancestor::div[1]") WebElement TPA;
    @FindBy(xpath="//*[text()='Provider']//ancestor::div[1]") WebElement Provider;
    @FindBy(id="mat-checkbox-27") WebElement Aggregator;

    //Location Section
    @FindBy(xpath = "//div[@class='mat-tab-labels']/div[1]") WebElement location_tab;
    @FindBy(xpath="//button[contains(@class, 'LOCATION_addBtn')]") WebElement add_location;
    @FindBy(xpath="(//input[starts-with(@class, 'k-textbox')])[3]") WebElement location_name;
    @FindBy(xpath="(//input[starts-with(@class, 'k-textbox')])[4]") WebElement location_description;
    @FindBy(xpath="(//input[starts-with(@class, 'k-textbox')])[5]") WebElement location_TAXID;
    @FindBy(xpath="(//input[starts-with(@class, 'k-textbox')])[7]") WebElement location_street;
    @FindBy(xpath="(//input[starts-with(@class, 'k-textbox')])[8]") WebElement location_city;
    @FindBy(xpath="(//input[starts-with(@class, 'k-textbox')])[9]") WebElement location_zipcode;
    //@FindBy(xpath="(//input[starts-with(@class, 'k-textbox')])[9]") WebElement location_fax;
    @FindBy(xpath="(//input[starts-with(@class, 'k-textbox')])[11]") WebElement location_phone1;

    //@FindBy(xpath="(//input[starts-with(@class, 'k-textbox')])[11]") WebElement location_phone2;
    @FindBy(xpath="//*[contains(@class, 'mat-tab-body')]/div/locations-info/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[8]/kendo-dropdownlist") WebElement location_state;
    @FindBy(xpath="//*[contains(text(), 'Oklahoma')]") WebElement location_state_name;
    @FindBy(xpath = "//*[contains(@class, 'mat-tab-body')]/div/locations-info/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[3]/kendo-dropdownlist") WebElement default_location;
    @FindBy(xpath="//*[contains(text(), 'true')]") WebElement true_location;
    @FindBy(xpath="//*[contains(@class, 'k-button-icon')][3]") WebElement save_location;
    @FindBy(xpath="//*[contains(@class, 'k-button-icon')][4]") WebElement cancel_location;

    //Provider Information Tab
    @FindBy(xpath = "//div[@class='mat-tab-labels']/div[2]") WebElement provider_tab;
    @FindBy(xpath = "(//input[@type='number'])[4]") WebElement npi;
    @FindBy(xpath = "(//*[@class='mat-form-field-infix'])/textarea") WebElement specialists;

    //TPA Information Tab
    @FindBy(xpath = "//div[@class='mat-tab-labels']/div[5]") WebElement tpa_tab;
    @FindBy(xpath = "(//input[@type='text'])[4]") WebElement ventanex_id;
    @FindBy(xpath = "(//input[@type='text'])[5]") WebElement ventanex_api_key;




    public void mainForm(
            String entityType,
            String name,
            String default_email,
            String billing_email,
            String  default_TaxID,
            String default_phone
    ) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(Entities));
        click(Entities);

        Thread.sleep(5000);
        //wait.until(ExpectedConditions.elementToBeClickable(add_new_entity));
        click(add_new_entity);

        wait.until(ExpectedConditions.visibilityOfAllElements(Name, Email));

        //Selecting Entity Type = TPA, Provider, and/or aggregator

        for(WebElement ty : entity_types)
        {
            Thread.sleep(2000);
            type_name = ty.getText();

            if(type_name.equalsIgnoreCase(entityType))
            {
                //Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(ty));
                click(ty);


            }


        }


        //Filling Personal-Info
        text(Name, name);
        text(Email, default_email);
        text(Billing_Email, billing_email);
        click(default_TAXID);
        // wait.until(ExpectedConditions.elementToBeSelected(default_TAXID));
        text(default_TAXID, default_TaxID);
        click(Default_Phone);
        text(Default_Phone, default_phone);
        wait.until(ExpectedConditions.elementToBeClickable(Active_Entity));
        //jse.executeScript("arguments[0].click();", Active_Entity);
        click(Active_Entity);

       /* Thread.sleep(2000);
        if(type_name.equalsIgnoreCase("provider"))
        {

            click(provider_tab);
            jse.executeScript("arguments[0].scrollIntoView(true);", specialists);
            wait.until(ExpectedConditions.visibilityOfAllElements(npi,specialists));

        }
        else if(type_name.equalsIgnoreCase("tpa"))
        {
            click(tpa_tab);
            jse.executeScript("arguments[0].scrollIntoView(true);", ventanex_id);
            wait.until(ExpectedConditions.visibilityOfAllElements(ventanex_id,ventanex_api_key));
        }
        else if(type_name.equalsIgnoreCase("aggregator"))
        {

        }*/

    }

    public void provider(String npi_value,
                         String specialists_value) throws InterruptedException
    {
        Thread.sleep(2000);
        if(type_name.equalsIgnoreCase("provider"))
        {

            click(provider_tab);
            jse.executeScript("arguments[0].scrollIntoView(true);", specialists);
            wait.until(ExpectedConditions.visibilityOfAllElements(npi,specialists));
            text(npi, npi_value);
            text(specialists, specialists_value);
        }

    }

    public void tpa(String ventanex_value, String ventanex_api) throws InterruptedException
    {

        Thread.sleep(2000);
        if(type_name.equalsIgnoreCase("tpa"))
        {
            click(tpa_tab);
            jse.executeScript("arguments[0].scrollIntoView(true);", ventanex_id);
            wait.until(ExpectedConditions.visibilityOfAllElements(ventanex_id,ventanex_api_key));
            text(ventanex_id, ventanex_value);
            text(specialists, ventanex_api);
        }

    }

   /*public void aggregator()
    {
        text(npi, npi_value);
        text(specialists, specialists_value);
    }*/

    public void location(String add1,
                         String description,
                         String location_taxID,
                         String street,
                         String city,
                         String zipCode,
                         String phone1

    ) throws InterruptedException {

                            //Fill Location section
                            //jse.executeScript("window.scrollBy(0,600)");
                            click(location_tab);
                            Thread.sleep(1000);
                            //wait.until(ExpectedConditions.visibilityOf(add_location));
                            click(add_location);
                            click(cancel_location);
                            click(add_location);
                            text(location_name, add1);
                            text(location_description, description);
                            click(default_location);

                            wait.until(ExpectedConditions.visibilityOfAllElements(true_location));

                                    click(true_location);
                                    boolean loc_taxid = location_TAXID.isEnabled();

                                         if(loc_taxid==true)
                                            {

                                                text(location_TAXID, location_taxID);

                                             }


                            wait.until(ExpectedConditions.visibilityOfAllElements(location_street));
                                text(location_street, street);
                                text(location_city, city);
                                click(location_state);
                                jse.executeScript("arguments[0].scrollIntoView(true);", location_state_name);

                            wait.until(ExpectedConditions.visibilityOf(location_state_name));
                                click(location_state_name);
                                text(location_zipcode, zipCode);
                                //  text(location_fax, fax);
                                 jse.executeScript("arguments[0].scrollIntoView(true)", location_phone1);

                            wait.until(ExpectedConditions.visibilityOfAllElements(location_phone1));
                                click(location_phone1);
                                text(location_phone1, phone1);
                                // text(location_phone2, phone2);

                            wait.until(ExpectedConditions.elementToBeClickable(save_location));
                            Assert.assertTrue(save_location.isEnabled());
                                  click(save_location);

    }



       /* public void entity_tabs(
                String npi_value,
                String specialists_value
        )
        {
            //Provider TAB
            if(Provider.isSelected())
            {
                click(provider_tab);
                text(npi, npi_value);
                text(specialists, specialists_value);

            }
            else if (TPA.isSelected())
            {

            }
        }*/

}
