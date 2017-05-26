package com.sluka.taras.util;

import lombok.Data;

import java.util.Date;

@Data
public class StaticDateUtil {
    public static String date_2017_05_20 = "2017-05-20";
    public static String date_2017_05_21 = "2017-05-21";
    public static String date_2017_05_22 = "2017-05-22";
    public static String date_2017_05_23 = "2017-05-23";

    public static String date_false_1 = "2017-12-32";
    public static String date_false_2 = "2017-13-25";
    public static String date_false_3 = "2008-02-31";
    public static String date_false_4 = "20012-00-31";

    public static Date getDate_2017_05_20() {
        return new Date(1495227600000L);
    }

    public static Date getDate_2017_05_21() {
        return new Date(1495314000000L);
    }

    public static Date getDate_2017_05_22() {
        return new Date(1495400400000L);
    }

    public static Date getDate_2017_05_23() {
        return new Date(1495486800000L);
    }

}
