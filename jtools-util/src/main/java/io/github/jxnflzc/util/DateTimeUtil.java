package io.github.jxnflzc.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author jxnflzc
 * @version 1.0
 */
public class DateTimeUtil {
    public static LocalDate after(LocalDate localDate, int days) {
        if(null == localDate) {
            return null;
        }
        return localDate.plusDays(days);
    }

    public static LocalDate before(LocalDate localDate, int days) {
        if(null == localDate) {
            return null;
        }
        return localDate.minusDays(days);
    }

    public static LocalDate dateToLocalDate(Date date) {
        if(null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        if(null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static Date localDateToDate(LocalDate localDate) {
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public static Date localDateTimeToDate(LocalDateTime localDate) {
        ZonedDateTime zonedDateTime = localDate.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }
}
