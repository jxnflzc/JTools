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
    /**
     * Get date after the specified date
     * @param localDate Specified date
     * @param days After days
     * @return Date after the specified date
     */
    public static LocalDate after(LocalDate localDate, int days) {
        if(null == localDate) {
            return null;
        }
        return localDate.plusDays(days);
    }

    /**
     * Get date before the specified date
     * @param localDate Specified date
     * @param days Before days
     * @return Date before the specified date
     */
    public static LocalDate before(LocalDate localDate, int days) {
        if(null == localDate) {
            return null;
        }
        return localDate.minusDays(days);
    }

    /**
     * Convert date to local date
     * @param date Date to be converted
     * @return Converted local date
     */
    public static LocalDate dateToLocalDate(Date date) {
        if(null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Convert date to local date time
     * @param date Date to be converted
     * @return Converted local date time
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        if(null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Convert local date to date
     * @param localDate Local date to be converted
     * @return Converted date
     */
    public static Date localDateToDate(LocalDate localDate) {
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * Convert local date time to date
     * @param localDateTime Local date time to be converted
     * @return Converted date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }
}
