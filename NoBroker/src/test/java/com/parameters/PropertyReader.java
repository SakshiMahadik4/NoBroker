package com.parameters;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// This class reads properties from a configuration file.
public class PropertyReader {
    public static Properties propertyReaderMethod() {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            // Adjust path as needed. This assumes the file is in the project root.
            inputStream = new FileInputStream("src\\test\\java\\com\\parameters\\config.properties"); 
            properties.load(inputStream);

            if (properties.isEmpty()) {
                System.out.println("No properties loaded from file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return properties;
    }
}
