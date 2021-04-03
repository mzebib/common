package com.github.mzebib.common.util;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author mzebib
 */
public class DateTimeUtilTest {

    @Test
    public void testIsLeapYear() {
        assertTrue(DateTimeUtil.isLeapYear(2016));
        assertTrue(DateTimeUtil.isLeapYear(2012));
        assertTrue(DateTimeUtil.isLeapYear(2008));
        assertTrue(DateTimeUtil.isLeapYear(2004));
        assertTrue(DateTimeUtil.isLeapYear(2000));

        assertFalse(DateTimeUtil.isLeapYear(2018));
        assertFalse(DateTimeUtil.isLeapYear(2014));
        assertFalse(DateTimeUtil.isLeapYear(2010));
        assertFalse(DateTimeUtil.isLeapYear(2006));
        assertFalse(DateTimeUtil.isLeapYear(2002));
        assertFalse(DateTimeUtil.isLeapYear(1));
    }

    @Test
    public void testGetDaysGivenYear() {
        assertEquals(31, DateTimeUtil.Month.JANUARY.getDays(2018));
        assertEquals(28, DateTimeUtil.Month.FEBRUARY.getDays(2018));
        assertEquals(31, DateTimeUtil.Month.MARCH.getDays(2018));
        assertEquals(30, DateTimeUtil.Month.APRIL.getDays(2018));
        assertEquals(31, DateTimeUtil.Month.MAY.getDays(2018));
        assertEquals(30, DateTimeUtil.Month.JUNE.getDays(2018));
        assertEquals(31, DateTimeUtil.Month.JULY.getDays(2018));
        assertEquals(31, DateTimeUtil.Month.AUGUST.getDays(2018));
        assertEquals(30, DateTimeUtil.Month.SEPTEMBER.getDays(2018));
        assertEquals(31, DateTimeUtil.Month.OCTOBER.getDays(2018));
        assertEquals(30, DateTimeUtil.Month.NOVEMBER.getDays(2018));
        assertEquals(31, DateTimeUtil.Month.DECEMBER.getDays(2018));
        assertEquals(29, DateTimeUtil.Month.FEBRUARY.getDays(2012));
    }

    @Test
    public void testLookupMonth() {
        assertEquals(DateTimeUtil.Month.JANUARY, DateTimeUtil.Month.lookup("1"));
        assertEquals(DateTimeUtil.Month.JANUARY, DateTimeUtil.Month.lookup("01"));
        assertEquals(DateTimeUtil.Month.JANUARY, DateTimeUtil.Month.lookup("January"));
        assertEquals(DateTimeUtil.Month.JANUARY, DateTimeUtil.Month.lookup("Jan"));

        assertEquals(DateTimeUtil.Month.FEBRUARY, DateTimeUtil.Month.lookup("2"));
        assertEquals(DateTimeUtil.Month.FEBRUARY, DateTimeUtil.Month.lookup("02"));
        assertEquals(DateTimeUtil.Month.FEBRUARY, DateTimeUtil.Month.lookup("February"));
        assertEquals(DateTimeUtil.Month.FEBRUARY, DateTimeUtil.Month.lookup("Feb"));

        assertEquals(DateTimeUtil.Month.MARCH, DateTimeUtil.Month.lookup("3"));
        assertEquals(DateTimeUtil.Month.MARCH, DateTimeUtil.Month.lookup("03"));
        assertEquals(DateTimeUtil.Month.MARCH, DateTimeUtil.Month.lookup("March"));
        assertEquals(DateTimeUtil.Month.MARCH, DateTimeUtil.Month.lookup("Mar"));

        assertEquals(DateTimeUtil.Month.APRIL, DateTimeUtil.Month.lookup("4"));
        assertEquals(DateTimeUtil.Month.APRIL, DateTimeUtil.Month.lookup("04"));
        assertEquals(DateTimeUtil.Month.APRIL, DateTimeUtil.Month.lookup("April"));
        assertEquals(DateTimeUtil.Month.APRIL, DateTimeUtil.Month.lookup("Apr"));

        assertEquals(DateTimeUtil.Month.MAY, DateTimeUtil.Month.lookup("5"));
        assertEquals(DateTimeUtil.Month.MAY, DateTimeUtil.Month.lookup("05"));
        assertEquals(DateTimeUtil.Month.MAY, DateTimeUtil.Month.lookup("May"));

        assertEquals(DateTimeUtil.Month.JUNE, DateTimeUtil.Month.lookup("6"));
        assertEquals(DateTimeUtil.Month.JUNE, DateTimeUtil.Month.lookup("06"));
        assertEquals(DateTimeUtil.Month.JUNE, DateTimeUtil.Month.lookup("June"));
        assertEquals(DateTimeUtil.Month.JUNE, DateTimeUtil.Month.lookup("Jun"));

        assertEquals(DateTimeUtil.Month.JULY, DateTimeUtil.Month.lookup("7"));
        assertEquals(DateTimeUtil.Month.JULY, DateTimeUtil.Month.lookup("07"));
        assertEquals(DateTimeUtil.Month.JULY, DateTimeUtil.Month.lookup("July"));
        assertEquals(DateTimeUtil.Month.JULY, DateTimeUtil.Month.lookup("Jul"));

        assertEquals(DateTimeUtil.Month.AUGUST, DateTimeUtil.Month.lookup("8"));
        assertEquals(DateTimeUtil.Month.AUGUST, DateTimeUtil.Month.lookup("08"));
        assertEquals(DateTimeUtil.Month.AUGUST, DateTimeUtil.Month.lookup("August"));
        assertEquals(DateTimeUtil.Month.AUGUST, DateTimeUtil.Month.lookup("Aug"));

        assertEquals(DateTimeUtil.Month.SEPTEMBER, DateTimeUtil.Month.lookup("9"));
        assertEquals(DateTimeUtil.Month.SEPTEMBER, DateTimeUtil.Month.lookup("09"));
        assertEquals(DateTimeUtil.Month.SEPTEMBER, DateTimeUtil.Month.lookup("September"));
        assertEquals(DateTimeUtil.Month.SEPTEMBER, DateTimeUtil.Month.lookup("Sept"));
        assertEquals(DateTimeUtil.Month.SEPTEMBER, DateTimeUtil.Month.lookup("Sep"));

        assertEquals(DateTimeUtil.Month.OCTOBER, DateTimeUtil.Month.lookup("10"));
        assertEquals(DateTimeUtil.Month.OCTOBER, DateTimeUtil.Month.lookup("October"));
        assertEquals(DateTimeUtil.Month.OCTOBER, DateTimeUtil.Month.lookup("Oct"));

        assertEquals(DateTimeUtil.Month.NOVEMBER, DateTimeUtil.Month.lookup("11"));
        assertEquals(DateTimeUtil.Month.NOVEMBER, DateTimeUtil.Month.lookup("November"));
        assertEquals(DateTimeUtil.Month.NOVEMBER, DateTimeUtil.Month.lookup("Nov"));

        assertEquals(DateTimeUtil.Month.DECEMBER, DateTimeUtil.Month.lookup("12"));
        assertEquals(DateTimeUtil.Month.DECEMBER, DateTimeUtil.Month.lookup("December"));
        assertEquals(DateTimeUtil.Month.DECEMBER, DateTimeUtil.Month.lookup("Dec"));
    }

    @Test
    public void testToDate() {
        assertNotNull(DateTimeUtil.toDate("2017-11-30", "yyyy-MM-dd"));

        assertNull(DateTimeUtil.toDate("", "yyyy-MM-dd"));
    }

    @Test
    public void testIsValidDateFormat() {
        assertTrue(DateTimeUtil.isValidDate("2017-11-30", "yyyy-MM-dd"));
        assertTrue(DateTimeUtil.isValidDate("2017/11/30", "yyyy/MM/dd"));
        assertTrue(DateTimeUtil.isValidDate("2017.11.30", "yyyy.MM.dd"));
        assertTrue(DateTimeUtil.isValidDate("2017-3-1", "yyyy-M-d"));
        assertTrue(DateTimeUtil.isValidDate("2017/3/1", "yyyy/M/d"));
        assertTrue(DateTimeUtil.isValidDate("2017.3.1", "yyyy.M.d"));

        assertTrue(DateTimeUtil.isValidDate("11-30-2017", "MM-dd-yyyy"));
        assertTrue(DateTimeUtil.isValidDate("11/30/2017", "MM/dd/yyyy"));
        assertTrue(DateTimeUtil.isValidDate("11.30.2017", "MM.dd.yyyy"));
        assertTrue(DateTimeUtil.isValidDate("3-1-2017", "M-dd-yyyy"));
        assertTrue(DateTimeUtil.isValidDate("3/1/2017", "M/d/yyyy"));
        assertTrue(DateTimeUtil.isValidDate("3.1.2017", "M.d.yyyy"));

        assertTrue(DateTimeUtil.isValidDate("30-11-2017", "dd-MM-yyyy"));
        assertTrue(DateTimeUtil.isValidDate("30/11/2017", "dd/MM/yyyy"));
        assertTrue(DateTimeUtil.isValidDate("30.11.2017", "dd.MM.yyyy"));
        assertTrue(DateTimeUtil.isValidDate("1-3-2017", "dd-MM-yyyy"));
        assertTrue(DateTimeUtil.isValidDate("1/3/2017", "dd/MM/yyyy"));
        assertTrue(DateTimeUtil.isValidDate("1.3.2017", "dd.MM.yyyy"));

        assertFalse(DateTimeUtil.isValidDate("20171130", "yyyy-MM-dd"));
        assertFalse(DateTimeUtil.isValidDate("2017//11//30", "yyyy/MM/dd"));
        assertFalse(DateTimeUtil.isValidDate("2017..11..30", "yyyy.MM.dd"));
        assertFalse(DateTimeUtil.isValidDate(null, "yyyy.MM.dd"));
        assertFalse(DateTimeUtil.isValidDate("", "yyyy.MM.dd"));
    }

    @Test
    public void testIsValidYear() {
        assertTrue(DateTimeUtil.isValidYear("2018"));
        assertTrue(DateTimeUtil.isValidYear("2016"));
        assertTrue(DateTimeUtil.isValidYear("2012"));
        assertTrue(DateTimeUtil.isValidYear("2008"));
        assertTrue(DateTimeUtil.isValidYear("2004"));
        assertTrue(DateTimeUtil.isValidYear("2000"));
        assertTrue(DateTimeUtil.isValidYear("1996"));
        assertTrue(DateTimeUtil.isValidYear("1992"));

        assertFalse(DateTimeUtil.isValidYear(null));
        assertFalse(DateTimeUtil.isValidYear(""));
        assertFalse(DateTimeUtil.isValidYear("hello"));
        assertFalse(DateTimeUtil.isValidYear("A200"));
        assertFalse(DateTimeUtil.isValidYear("2018A"));
    }

    @Test
    public void testIsValidMonth() {
        assertTrue(DateTimeUtil.isValidMonth("1"));
        assertTrue(DateTimeUtil.isValidMonth("01"));
        assertTrue(DateTimeUtil.isValidMonth("2"));
        assertTrue(DateTimeUtil.isValidMonth("02"));
        assertTrue(DateTimeUtil.isValidMonth("3"));
        assertTrue(DateTimeUtil.isValidMonth("03"));
        assertTrue(DateTimeUtil.isValidMonth("4"));
        assertTrue(DateTimeUtil.isValidMonth("04"));
        assertTrue(DateTimeUtil.isValidMonth("5"));
        assertTrue(DateTimeUtil.isValidMonth("05"));
        assertTrue(DateTimeUtil.isValidMonth("6"));
        assertTrue(DateTimeUtil.isValidMonth("06"));
        assertTrue(DateTimeUtil.isValidMonth("7"));
        assertTrue(DateTimeUtil.isValidMonth("07"));
        assertTrue(DateTimeUtil.isValidMonth("8"));
        assertTrue(DateTimeUtil.isValidMonth("08"));
        assertTrue(DateTimeUtil.isValidMonth("9"));
        assertTrue(DateTimeUtil.isValidMonth("09"));
        assertTrue(DateTimeUtil.isValidMonth("10"));
        assertTrue(DateTimeUtil.isValidMonth("11"));
        assertTrue(DateTimeUtil.isValidMonth("12"));

        assertTrue(DateTimeUtil.isValidMonth("January"));
        assertTrue(DateTimeUtil.isValidMonth("Jan"));
        assertTrue(DateTimeUtil.isValidMonth("February"));
        assertTrue(DateTimeUtil.isValidMonth("Feb"));
        assertTrue(DateTimeUtil.isValidMonth("March"));
        assertTrue(DateTimeUtil.isValidMonth("Mar"));
        assertTrue(DateTimeUtil.isValidMonth("April"));
        assertTrue(DateTimeUtil.isValidMonth("Apr"));
        assertTrue(DateTimeUtil.isValidMonth("May"));
        assertTrue(DateTimeUtil.isValidMonth("June"));
        assertTrue(DateTimeUtil.isValidMonth("Jun"));
        assertTrue(DateTimeUtil.isValidMonth("July"));
        assertTrue(DateTimeUtil.isValidMonth("Jul"));
        assertTrue(DateTimeUtil.isValidMonth("August"));
        assertTrue(DateTimeUtil.isValidMonth("Aug"));
        assertTrue(DateTimeUtil.isValidMonth("September"));
        assertTrue(DateTimeUtil.isValidMonth("Sept"));
        assertTrue(DateTimeUtil.isValidMonth("Sep"));
        assertTrue(DateTimeUtil.isValidMonth("October"));
        assertTrue(DateTimeUtil.isValidMonth("Oct"));
        assertTrue(DateTimeUtil.isValidMonth("November"));
        assertTrue(DateTimeUtil.isValidMonth("Nov"));
        assertTrue(DateTimeUtil.isValidMonth("December"));
        assertTrue(DateTimeUtil.isValidMonth("Dec"));

        assertFalse(DateTimeUtil.isValidMonth(null));
        assertFalse(DateTimeUtil.isValidMonth(""));
        assertFalse(DateTimeUtil.isValidMonth("hello"));
        assertFalse(DateTimeUtil.isValidMonth("1000"));
    }

    @Test
    public void testIsValidDate() {
        assertTrue(DateTimeUtil.isValidDate("2017", "1", "1"));
        assertTrue(DateTimeUtil.isValidDate("2017", "Jan", "1"));
        assertTrue(DateTimeUtil.isValidDate("2017", "January", "1"));
        assertTrue(DateTimeUtil.isValidDate("2017", "8", "1"));
        assertTrue(DateTimeUtil.isValidDate("2017", "12", "31"));

        assertFalse(DateTimeUtil.isValidDate(null, "1", "1"));
        assertFalse(DateTimeUtil.isValidDate("2017", "Jan", null));
        assertFalse(DateTimeUtil.isValidDate("2017", "January", "40"));
    }

    @Test
    public void testTimeInMilliseconds() {
        assertEquals(1000, DateTimeUtil.TimeInMillis.SECOND.MILLIS);
        assertEquals(60000, DateTimeUtil.TimeInMillis.MINUTE.MILLIS);
        assertEquals(3600000, DateTimeUtil.TimeInMillis.HOUR.MILLIS);
        assertEquals(86400000, DateTimeUtil.TimeInMillis.DAY.MILLIS);
    }

}
