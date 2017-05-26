package com.sluka.taras.util;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by taras on 24.05.2017.
 */

class DateUtilTest {

    @Test
    void dateOfString() {
        assertThrows(DateException.class, () -> DateUtil.dateOfString(StaticDateUtil.date_false_1));
        assertThrows(DateException.class, () -> DateUtil.dateOfString(StaticDateUtil.date_false_2));
        assertThrows(DateException.class, () -> DateUtil.dateOfString(StaticDateUtil.date_false_3));
        assertThrows(DateException.class, () -> DateUtil.dateOfString(StaticDateUtil.date_false_4));

        Date date = DateUtil.dateOfString(StaticDateUtil.date_2017_05_20);
        assertTrue(date.compareTo(StaticDateUtil.getDate_2017_05_20()) == 0);

        date = DateUtil.dateOfString(StaticDateUtil.date_2017_05_21);
        assertTrue(date.compareTo(StaticDateUtil.getDate_2017_05_21()) == 0);
        date = DateUtil.dateOfString(StaticDateUtil.date_2017_05_22);
        assertTrue(date.compareTo(StaticDateUtil.getDate_2017_05_22()) == 0);

        date = DateUtil.dateOfString(StaticDateUtil.date_2017_05_21);
        assertFalse(date.compareTo(StaticDateUtil.getDate_2017_05_22()) == 0);

    }
}