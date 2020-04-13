package automation.Entities;

import Data.dataSet;
import automation.Utilities;
import automation.testBase;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.io.IOException;

public class TPAEntity extends testBase {
    addTPAEntity add_TPA_entity;




    @Test (dataProvider = "excelFile", dataProviderClass = dataSet.class)
    public void tpa(String entity_type,
                    String name,
                    String default_email,
                    String billing_email,
                    String  default_TaxID,
                    String default_phone,
                    String ventanex_value,
                    String ventanex_api,
                    String add1,
                    String description,
                    String location_taxID,
                    String street,
                    String city,
                    String zipCode,
                    String phone1) throws InterruptedException
    {
        add_TPA_entity = new addTPAEntity(driver);
        add_TPA_entity.mainFormTPA(entity_type, name, default_email, billing_email, default_TaxID, default_phone);
        add_TPA_entity.tpa(ventanex_value, ventanex_api);
        add_TPA_entity.location(add1,description,location_taxID,street,city,zipCode,phone1);
    }

}
