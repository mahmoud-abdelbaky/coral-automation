package automation.Entities;

import Data.dataSet;
import automation.testBase;
import org.testng.annotations.*;

public class addEntities extends testBase {









    /*@DataProvider(name = "excelFilee")
    public static Object[][] dataTest() throws IOException {
        FileInputStream excelFile = new FileInputStream(System.getProperty("user.dir") + "/resources/Book2.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet entity_sheet = workbook.getSheet("entity");
        int number_of_data = entity_sheet.getPhysicalNumberOfRows();
        Object[][] test_data = new Object[number_of_data][11];
        for (int i = 0; i < number_of_data; i++)
        {
            XSSFRow row = entity_sheet.getRow(i);

            XSSFCell name = row.getCell(0);
            XSSFCell default_email = row.getCell(1);
            XSSFCell default_TaxID = row.getCell(2);
            XSSFCell default_phone = row.getCell(3);
            XSSFCell add1 = row.getCell(4);
            XSSFCell description = row.getCell(5);
            XSSFCell location_taxID = row.getCell(6);
            XSSFCell street = row.getCell(7);
            XSSFCell city = row.getCell(8);
            XSSFCell zipCode = row.getCell(9);
           // XSSFCell fax = row.getCell(10);
            XSSFCell phone1 = row.getCell(10);
           // XSSFCell phone2 = row.getCell(12);


            test_data [i][0]= name.getStringCellValue();
            test_data [i][1]= default_email.getStringCellValue();
            test_data [i][2]= default_TaxID.getStringCellValue();
            test_data [i][3]= default_phone.getStringCellValue();
            test_data [i][4]= add1.getStringCellValue();
            test_data [i][5]= description.getStringCellValue();
            test_data [i][6]= location_taxID.getStringCellValue();
            test_data [i][7]= street.getStringCellValue();
            test_data [i][8]= city.getStringCellValue();
            test_data [i][9]= zipCode.getStringCellValue();
            //test_data [i][10]= fax.getStringCellValue();
            test_data [i][10]= phone1.getStringCellValue();
           // test_data [i][12]= phone2.getStringCellValue();

        }

        return test_data;
    }
*/
}
