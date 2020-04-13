package automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utilities {


    public static String credentials (String key)throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/Data/prop.properties");
        Properties property = new Properties();
        property.load(fis);
        return property.get(key).toString();
    }


}

