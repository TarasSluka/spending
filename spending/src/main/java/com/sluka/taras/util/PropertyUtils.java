package com.sluka.taras.util;

import com.sluka.taras.data.jaxb.impl.StorageServiceImpl;
import lombok.Getter;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyUtils {
    private static final Logger LOGGER = Logger.getLogger(StorageServiceImpl.class);
    private static final String FILENAME = "config.properties";
    @Getter
    private static final String reqExReuseProperties = "\\$\\{(.*?)\\}";
    private static Properties properties = new Properties();

    static {
        readPropertyFile();
    }

    private static boolean checkSubProperties(String property) {
        return getMatcher(property).find();
    }

    public static String getProperty(String propertyName) {
        String property = properties.getProperty(propertyName);
        if (checkSubProperties(property)) {
            property = getFullProperty(property);
        }
        return property;
    }

    private static String getFullProperty(String property) {
        Matcher matcher = getMatcher(property);
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        int indexStart;
        int indexEnd;
        while (matcher.find()) {
            indexStart = matcher.start();
            indexEnd = matcher.end();
            stringBuilder.append(property.substring(index, indexStart));
            stringBuilder.append(getProperty(property.substring(indexStart + 2, indexEnd - 1)));
            index = indexEnd;
        }
        stringBuilder.append(property.substring(index, property.length()));
        return stringBuilder.toString();
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

    private static Matcher getMatcher(String str) {
        Pattern pattern = Pattern.compile(reqExReuseProperties);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }
}


