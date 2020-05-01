package Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceReader {
    private static String DBProps = "DBProperties";

    public static String getDBLoginName(){return getDBProperty("db.user");}
    public static String getDBLoginPass(){return getDBProperty("db.password");}
    public static String getDBConnectionString(){return getDBProperty("db.url");}
    public static String getDBDriver(){return getDBProperty("db.driver");}

    public static String getDBProperty(String key){return property(DBProps,key);}

    public static String getProperty(String file, String key){return property(file, key);}

    private static String property(String file, String key){
        String fileName = file+".properties";
        try(InputStream stream = ResourceReader.class.getClassLoader().getResourceAsStream(fileName);){
            Properties properties = new Properties();

            if (stream != null){
                properties.load(stream);
            } else{
                throw new FileNotFoundException("Properties file is not found or accessable");
            }

            String value = properties.getProperty(key);
            return value;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
