package automation.Entities;

import Data.dataSet;
import automation.testBase;
import org.testng.annotations.*;

public class locationsTab extends testBase {
    addTPAEntity add_entity;
    @Test(dataProvider = "excelFile", dataProviderClass = dataSet.class)
    public void location(String add1,
                         String description,
                         String location_taxID,
                         String street,
                         String city,
                         String zipCode,
                         String phone1) throws InterruptedException
    {
        add_entity = new addTPAEntity(driver);
        add_entity.location(add1, description, location_taxID, street, city, zipCode, phone1);
    }
}
