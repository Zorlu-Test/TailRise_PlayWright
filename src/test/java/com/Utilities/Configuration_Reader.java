package com.Utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration_Reader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");

            properties.load(fileInputStream);

            fileInputStream.close();

        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }
    }


    public static String getProperties(String myKey) {
        return properties.getProperty(myKey);
    }


}
