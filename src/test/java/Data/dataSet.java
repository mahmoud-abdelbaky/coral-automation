package Data;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.sun.tools.doclint.Entity.or;

public class dataSet {

    @DataProvider(name = "excelFile")
    public static Object[][] dataTest(Method met) throws IOException {

        if (met.getName().equalsIgnoreCase("add_Entity_mainForm"))
        {
            FileInputStream excelFile = new FileInputStream(System.getProperty("user.dir") + "/resources/Book2.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet entity_sheet = workbook.getSheet("entity");

            int number_of_data = entity_sheet.getPhysicalNumberOfRows();

            Object[][] test_data = new Object[number_of_data][6];

            for (int i = 0; i < number_of_data; i++) {
                XSSFRow row = entity_sheet.getRow(i);

                XSSFCell entity_type = row.getCell(0);
                XSSFCell name = row.getCell(1);
                XSSFCell default_email = row.getCell(2);
                XSSFCell billing_Email = row.getCell(3);
                XSSFCell default_TaxID = row.getCell(4);
                XSSFCell default_phone = row.getCell(5);


                test_data[i][0] = entity_type.getStringCellValue();
                test_data[i][1] = name.getStringCellValue();
                test_data[i][2] = default_email.getStringCellValue();
                test_data[i][3] = billing_Email.getStringCellValue();
                test_data[i][4] = default_TaxID.getStringCellValue();
                test_data[i][5] = default_phone.getStringCellValue();

            }

            return test_data;

        } else if (met.getName().equalsIgnoreCase("provider"))
        {
            FileInputStream excelFile = new FileInputStream(System.getProperty("user.dir") + "/resources/Book2.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet entity_sheet = workbook.getSheet("provider");
            int number_of_data = entity_sheet.getPhysicalNumberOfRows();
            Object[][] test_data = new Object[number_of_data][15];
            for (int i = 0; i < number_of_data; i++) {
                XSSFRow row = entity_sheet.getRow(i);

                XSSFCell entity_type = row.getCell(0);
                XSSFCell name = row.getCell(1);
                XSSFCell default_email = row.getCell(2);
                XSSFCell billing_Email = row.getCell(3);
                XSSFCell default_TaxID = row.getCell(4);
                XSSFCell default_phone = row.getCell(5);
                XSSFCell npi = row.getCell(6);
                XSSFCell specialists = row.getCell(7);
                XSSFCell add1 = row.getCell(8);
                XSSFCell description = row.getCell(9);
                XSSFCell location_taxID = row.getCell(10);
                XSSFCell street = row.getCell(11);
                XSSFCell city = row.getCell(12);
                XSSFCell zipCode = row.getCell(13);
                // XSSFCell fax = row.getCell(10);
                XSSFCell phone1 = row.getCell(14);



                test_data[i][0] = entity_type.getStringCellValue();
                test_data[i][1] = name.getStringCellValue();
                test_data[i][2] = default_email.getStringCellValue();
                test_data[i][3] = billing_Email.getStringCellValue();
                test_data[i][4] = default_TaxID.getStringCellValue();
                test_data[i][5] = default_phone.getStringCellValue();


                test_data[i][6] = npi.getStringCellValue();
                test_data[i][7] = specialists.getStringCellValue();


                test_data[i][8] = add1.getStringCellValue();
                test_data[i][9] = description.getStringCellValue();
                test_data[i][10] = location_taxID.getStringCellValue();
                test_data[i][11] = street.getStringCellValue();
                test_data[i][12] = city.getStringCellValue();
                test_data[i][13] = zipCode.getStringCellValue();
                test_data[i][14] = phone1.getStringCellValue();

            }

            return test_data;

        } else if (met.getName().equalsIgnoreCase("tpa"))
        {
            FileInputStream excelFile = new FileInputStream(System.getProperty("user.dir") + "/resources/Book2.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet entity_sheet = workbook.getSheet("tpa");
            int number_of_data = entity_sheet.getPhysicalNumberOfRows();
            Object[][] test_data = new Object[number_of_data][15];
            for (int i = 0; i < number_of_data; i++) {
                XSSFRow row = entity_sheet.getRow(i);

                XSSFCell entity_type = row.getCell(0);
                XSSFCell name = row.getCell(1);
                XSSFCell default_email = row.getCell(2);
                XSSFCell billing_Email = row.getCell(3);
                XSSFCell default_TaxID = row.getCell(4);
                XSSFCell default_phone = row.getCell(5);
                XSSFCell ventanex_value = row.getCell(6);
                XSSFCell ventanex_api = row.getCell(7);
                XSSFCell add1 = row.getCell(8);
                XSSFCell description = row.getCell(9);
                XSSFCell location_taxID = row.getCell(10);
                XSSFCell street = row.getCell(11);
                XSSFCell city = row.getCell(12);
                XSSFCell zipCode = row.getCell(13);
                // XSSFCell fax = row.getCell(10);
                XSSFCell phone1 = row.getCell(14);

                test_data[i][0] = entity_type.getStringCellValue();
                test_data[i][1] = name.getStringCellValue();
                test_data[i][2] = default_email.getStringCellValue();
                test_data[i][3] = billing_Email.getStringCellValue();
                test_data[i][4] = default_TaxID.getStringCellValue();
                test_data[i][5] = default_phone.getStringCellValue();

                test_data[i][6] = ventanex_value.getStringCellValue();
                test_data[i][7] = ventanex_api.getStringCellValue();

                test_data[i][8] = add1.getStringCellValue();
                test_data[i][9] = description.getStringCellValue();
                test_data[i][10] = location_taxID.getStringCellValue();
                test_data[i][11] = street.getStringCellValue();
                test_data[i][12] = city.getStringCellValue();
                test_data[i][13] = zipCode.getStringCellValue();
                test_data[i][14] = phone1.getStringCellValue();
            }

            return test_data;
        } /*else if (met.getName().equalsIgnoreCase("aggregator")) {
            FileInputStream excelFile = new FileInputStream(System.getProperty("user.dir") + "/resources/Book2.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet entity_sheet = workbook.getSheet("tpa");
            int number_of_data = entity_sheet.getPhysicalNumberOfRows();
            Object[][] test_data = new Object[number_of_data][2];
            for (int i = 0; i < number_of_data; i++) {
                XSSFRow row = entity_sheet.getRow(i);

                XSSFCell ventanex_value = row.getCell(0);
                XSSFCell ventanex_api = row.getCell(1);


                test_data[i][0] = ventanex_value.getStringCellValue();
                test_data[i][1] = ventanex_api.getStringCellValue();

            }

            return test_data;
        }*/

        else if (met.getName().equalsIgnoreCase("location"))
        {
            FileInputStream excelFile = new FileInputStream(System.getProperty("user.dir") + "/resources/Book2.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet entity_sheet = workbook.getSheet("location");
            int number_of_data = entity_sheet.getPhysicalNumberOfRows();
            Object[][] test_data = new Object[number_of_data][7];
            for (int i = 0; i < number_of_data; i++) {
                XSSFRow row = entity_sheet.getRow(i);


                XSSFCell add1 = row.getCell(0);
                XSSFCell description = row.getCell(1);
                XSSFCell location_taxID = row.getCell(2);
                XSSFCell street = row.getCell(3);
                XSSFCell city = row.getCell(4);
                XSSFCell zipCode = row.getCell(5);
                // XSSFCell fax = row.getCell(10);
                XSSFCell phone1 = row.getCell(6);


                test_data[i][0] = add1.getStringCellValue();
                test_data[i][1] = description.getStringCellValue();
                test_data[i][2] = location_taxID.getStringCellValue();
                test_data[i][3] = street.getStringCellValue();
                test_data[i][4] = city.getStringCellValue();
                test_data[i][5] = zipCode.getStringCellValue();
                test_data[i][6] = phone1.getStringCellValue();

            }

            return test_data;
        }
        else
        {
            Object [][] test_data = new Object[2][3];
            return  test_data;
        }


    }
}