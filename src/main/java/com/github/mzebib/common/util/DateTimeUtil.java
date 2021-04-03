package com.github.mzebib.common.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * @author mzebib
 */
public class DateTimeUtil {

    public enum DateFormat {
        YEAR("yyyy")
        ;

        private final String value;

        DateFormat(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Month {
        JANUARY(1, "January", "Jan"),
        FEBRUARY(2, "February", "Feb"),
        MARCH(3, "March", "Mar"),
        APRIL(4, "April", "Apr"),
        MAY(5, "May", "May"),
        JUNE(6, "June", "Jun"),
        JULY(7, "July", "Jul"),
        AUGUST(8, "August", "Aug"),
        SEPTEMBER(9, "September", "Sept", "Sep"),
        OCTOBER(10, "October", "Oct"),
        NOVEMBER(11, "November", "Nov"),
        DECEMBER(12, "December", "Dec")

        ;

        private final int number;
        private final String name;
        private final String[] shortNames;

        Month(int number, String name, String... shortNames) {
            this.number = number;
            this.name = name;
            this.shortNames = shortNames;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String[] getShortNames() {
            return shortNames;
        }

        public int getDays(int year) {
            switch(this) {
                case JANUARY:
                case MARCH:
                case MAY:
                case JULY:
                case AUGUST:
                case OCTOBER:
                case DECEMBER:
                    return 31;
                case FEBRUARY:
                    if (isLeapYear(year)) {
                        return 29;
                    } else {
                        return 28;
                    }
                case APRIL:
                case JUNE:
                case SEPTEMBER:
                case NOVEMBER:
                    return 30;
            }

            return 0;
        }

        public static Month lookup(String month) {
            if (month != null && !month.isEmpty()) {
                month = month.trim();
                for (Month m : Month.values()) {
                    if (m.getName().equalsIgnoreCase(month)) {
                        return m;
                    } else {
                        try {
                            int monthValue = Integer.parseInt(month);
                            if (m.getNumber() == monthValue) {
                                return m;
                            }
                        } catch (Exception e) {

                        }
                    }

                    for (String shortName : m.getShortNames()) {
                        if (shortName.equalsIgnoreCase(month)) {
                            return m;
                        }
                    }
                }
            }

            return null;
        }
    }

    public enum DayOfWeek {
        MONDAY(1, "Monday", "Mon"),
        TUESDAY(2, "Tuesday", "Tues", "Tue", "Tu"),
        WEDNESDAY(3, "Wednesday", "Wed", "W"),
        THURSDAY(4, "Thursday", "Thurs", "Thur", "Thu", "Th"),
        FRIDAY(5, "Friday", "Fri"),
        SATURDAY(6, "Saturday", "Sat"),
        SUNDAY(7, "Sunday", "Sun")
        ;

        private final int number;
        private final String name;
        private final String[] shortNames;

        DayOfWeek(int number, String name, String... shortNames) {
            this.number = number;
            this.name = name;
            this.shortNames = shortNames;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String[] getShortNames() {
            return shortNames;
        }
    }

    public enum TimePeriod {
        AM("AM"),
        PM("PM")
        ;

        private String name;

        TimePeriod(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum TimeInMillis {
        MILLISECOND(1, "milliseconds", "millisecond", "ms"),
        SECOND(MILLISECOND.MILLIS * 1000, "seconds", "second", "secs", "sec", "s"),
        MINUTE(SECOND.MILLIS * 60, "minutes", "minute", "mins", "min", "m"),
        HOUR(MINUTE.MILLIS * 60, "hours", "hour", "h"),
        DAY(HOUR.MILLIS * 24, "days", "day"),
        WEEK(DAY.MILLIS * 7, "weeks", "week")
        ;

        public final long MILLIS;
        private final String[] units;

        TimeInMillis(long duration, String... units) {
            this.MILLIS = duration;
            this.units = units;
        }

        public String[] getUnits() {
            return units;
        }
    }

    private DateTimeUtil() {
    }

    /**
     * Returns current timestamp in "yyyy-MM-dd'T'HH:mm:ss.SSSX" format.
     * @return
     */
    public static String generateCurrentTimestamp() {
        return Instant.now().toString();
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 100) != 0 && (year % 4 == 0));
    }

    public static Date toDate(String date, String format) {
        Date result = null;
        if (date != null && format != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setLenient(false);

            try {
                result = sdf.parse(date);
            } catch (Exception e) {

            }
        }

        return result;
    }


    public static boolean isValidDate(String date, String format) {
        return toDate(date, format) != null;
    }

    public static boolean isValidDate(String year, String month, String day) {
        if (year == null || month == null || day == null) {
            return false;
        }

        year = year.trim();
        month = month.trim();
        day = day.trim();

        if (isValidYear(year) && isValidMonth(month)) {
            Month m = Month.lookup(month);

            int dayValue;
            int yearValue;

            try {
                dayValue = Integer.parseInt(day);
                yearValue = Integer.valueOf(year);
            } catch (Exception e) {
                return false;
            }

            for (int i = 1; i <= m.getDays(yearValue); i++) {
                if (dayValue == i) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isValidYear(String year) {
        if (year == null) {
            return false;
        }

        year = year.trim();

        if (year.isEmpty()) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(DateFormat.YEAR.getValue());
        sdf.setLenient(false);

        try {
            Integer.parseInt(year);
            sdf.parse(year);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static boolean isValidMonth(String month) {
        return Month.lookup(month) != null;
    }

}
