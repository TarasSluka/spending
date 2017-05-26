package com.sluka.taras.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date dateOfString(String dateStr) {
        assert dateStr != null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(PropertyUtils.getProperty(PropertyName.DATE_FORMAT));
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new DateException("date:" + dateStr + "is not valid, please, enter the date following format: " + PropertyUtils.getProperty(PropertyName.DATE_FORMAT));
        }
    }

    public static String dateBySimpleFormat(Date date) {
        assert date != null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(PropertyUtils.getProperty(PropertyName.DATE_FORMAT));
        return dateFormat.format(date);
    }

}
