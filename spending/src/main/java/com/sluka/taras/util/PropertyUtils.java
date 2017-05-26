package com.sluka.taras.util;

import com.sluka.taras.data.jaxb.impl.StorageServiceImpl;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class PropertyUtils {
    private static final Logger LOGGER = Logger.getLogger(StorageServiceImpl.class);
    private static final String FILENAME = "config.properties";

    private static java.util.Properties properties = new java.util.Properties();

    static {
        readPropertyFile();
    }

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    private static void readPropertyFile() {
        InputStream inputStream = null;
        try {
            inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream(FILENAME);
            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (IOException e) {
            throw new PropertyException("Configuration file not found");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


