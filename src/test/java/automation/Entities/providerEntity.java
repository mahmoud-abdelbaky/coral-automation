package automation.Entities;

import Data.dataSet;
import automation.Utilities;
import automation.testBase;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.io.IOException;

public class providerEntity extends testBase {

    addProviderEntity add_provider_entity;


    @Test (dataProvider = "excelFile", dataProviderClass = dataSet.class)
    public void provider(String entity_type,
                         String name,
                         String default_email,
                         String billing_email,
                         String  default_TaxID,
                         String default_phone,
                         String npi,
                         String specialists,
                         String add1,
                         String description,
                         String location_taxID,
                         String street,
                         String city,
                         String zipCode,
                         String phone1) throws InterruptedException
    {
        add_provider_entity = new addProviderEntity(driver);
        add_provider_entity.mainFormProvider(entity_type, name, default_email, billing_email, default_TaxID, default_phone);
        add_provider_entity.provider(npi, specialists);
        add_provider_entity.location(add1,description,location_taxID,street,city,zipCode,phone1);
    }
}
