package com.sluka.taras.util;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by taras on 28.05.2017.
 */
class PropertyUtilsTest {
    @Test
    void getProperty() {
        assertEquals("val1", PropertyUtils.getProperty("val1"));
        assertEquals("val2 val1", PropertyUtils.getProperty("val2"));
        assertEquals("val3 val1 val2 val1", PropertyUtils.getProperty("val3"));
        assertEquals("val3 val1 val2 val1", PropertyUtils.getProperty("val3"));
        assertEquals("add {yyyy-MM-dd} {price} {currency} {name}", PropertyUtils.getProperty(PropertyName.ADD_COMMAND_SIGNATURE));
        assertEquals("add item, width next format: add {yyyy-MM-dd} {price} {currency} {name}", PropertyUtils.getProperty(PropertyName.EXCEPTION_MESSAGE_BY_COMMAND_ADD));

        assertThrows(PropertyException.class, () -> PropertyUtils.getProperty("asdads"));
    }


    @Test
    void testReqEx() {
        String s = "khlk lhl ${{sad}';${asdads}} ";
        String reqEx = PropertyUtils.getReqExReuseProperties();
        Pattern pattern = Pattern.compile(reqEx);
        Matcher matcher = pattern.matcher(s);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        assertEquals(2, count);
    }


}