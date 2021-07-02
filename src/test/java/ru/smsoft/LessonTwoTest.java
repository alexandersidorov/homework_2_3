package ru.smsoft;


import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.*;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class LessonTwoTest {

    private final String value = "28.06.2021";
    private final String value2 = "01.01.1970";
    private final String valueTime = "28/06/2021-00:00:00";
    private final String value2Time = "01/01/1970-00:00:00";
    private final String format = "dd.MM.yyyy";
    private final String formatTime = "dd/MM/yyyy-HH:mm:ss";

    @Test
    public void testLocalDate() {
        LocalDate date = LocalDate.of(2021,6,28);
        String result = LessonTwo.beautyDate(date,format);
        assertEquals(result, value);
    }

    @Test
    public void testLocalDateWithTime() {
        LocalDate date = LocalDate.of(2021,6,28);
        Throwable throwable = assertThrows(UnsupportedTemporalTypeException.class,()->{
            String result = LessonTwo.beautyDate(date,formatTime);
        });
        assertNotNull(throwable.getMessage());
    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime date = LocalDateTime.of(2021,6,28,0,0,0,0);
        String result = LessonTwo.beautyDate(date,format);
        assertEquals(result, value);
    }

    @Test
    public void testLocalDateTimeWithTime() {
        LocalDateTime date = LocalDateTime.of(2021,6,28,0,0,0,0);
        String result = LessonTwo.beautyDate(date,formatTime);
        assertEquals(result, valueTime);
    }

    @Test
    public void testOffsetDateTime() {
        OffsetDateTime date = OffsetDateTime.of(2021,6,28,
                0,0,0,0, ZoneOffset.UTC);
        String result = LessonTwo.beautyDate(date,format);
        assertEquals(result, value);
    }

    @Test
    public void testOffsetDateTimeWithTime() {
        OffsetDateTime date = OffsetDateTime.of(2021,6,28,
                0,0,0,0,ZoneOffset.UTC);
        String result = LessonTwo.beautyDate(date,formatTime);
        assertEquals(result, valueTime);
    }

    @Test
    public void testZonedDateTime() {
        ZonedDateTime date = ZonedDateTime.of(2021,6,28,
                0,0,0,0, ZoneOffset.UTC);
        String result = LessonTwo.beautyDate(date,format);
        assertEquals(result, value);
    }

    @Test
    public void testZonedDateTimeWithTime() {
        ZonedDateTime date = ZonedDateTime.of(2021,6,28,
                0,0,0,0, ZoneOffset.UTC);
        String result = LessonTwo.beautyDate(date,formatTime);
        assertEquals(result, valueTime);
    }

    @Test
    public void testXMLGregorianCalendar() throws DatatypeConfigurationException {
        String initStringDate = "2021-06-28";
        XMLGregorianCalendar date = DatatypeFactory
                .newInstance()
                .newXMLGregorianCalendar(initStringDate);
        String result = LessonTwo.beautyDate(date,format);
        assertEquals(result, value);
    }

    @Test
    public void testXMLGregorianCalendarWithTime() throws DatatypeConfigurationException {
        String initStringDate = "2021-06-28";
        XMLGregorianCalendar date = DatatypeFactory
                .newInstance()
                .newXMLGregorianCalendar(initStringDate);
        String result = LessonTwo.beautyDate(date,formatTime);
        assertEquals(result, valueTime);
    }

    @Test
    public void testInstant() {
        Instant date = Instant.ofEpochSecond(0);
        String result = LessonTwo.beautyDate(date,format);
        assertEquals(result, value2);
    }

    @Test
    public void testInstantWithTime() {
        Instant date = Instant.ofEpochSecond(0);
        String result = LessonTwo.beautyDate(date,formatTime);
        assertEquals(result, value2Time);
    }

    @Test
    public void testCalendar() {
        Calendar date = new MyCalendar();
        date.setTimeZone(TimeZone.getTimeZone(ZoneOffset.UTC));
        date.set(2021, Calendar.JUNE, 28, 0, 0, 0);
        String result = LessonTwo.beautyDate(date,format);
        assertEquals(result, value);
    }

    @Test
    public void testCalendarWithTime() {
        Calendar date = new MyCalendar();
        date.setTimeZone(TimeZone.getTimeZone(ZoneOffset.UTC));
        date.set(2021, Calendar.JUNE, 28, 0, 0, 0);
        String result = LessonTwo.beautyDate(date,formatTime);
        assertEquals(result, valueTime);
    }

    @Test
    public void testGregorianCalendar() {
        Calendar date = Calendar.getInstance();
        date.setTimeZone(TimeZone.getTimeZone(ZoneOffset.UTC));
        date.set(2021, Calendar.JUNE, 28, 0, 0, 0);
        String result = LessonTwo.beautyDate(date,format);
        assertEquals(result, value);
    }

    @Test
    public void testGregorianCalendarWithTime() {
        Calendar date = Calendar.getInstance();
        date.setTimeZone(TimeZone.getTimeZone(ZoneOffset.UTC));
        date.set(2021, Calendar.JUNE, 28, 0, 0, 0);
        String result = LessonTwo.beautyDate(date,formatTime);
        assertEquals(result, valueTime);
    }

    @Test
    public void testUtilDate() {
        Date date = new Date(0);
        String result = LessonTwo.beautyDate(date,format);
        assertEquals(result, value2);
    }

    @Test
    public void testUtilDateWithTime() {
        Date date = new Date(0);
        String result = LessonTwo.beautyDate(date,formatTime);
        assertEquals(result, value2Time);
    }

    @Test
    public void testSqlDate() {
        java.sql.Date date = new java.sql.Date(0);
        String result = LessonTwo.beautyDate(date,format);
        assertEquals(result, value2);
    }

    @Test
    public void testSqlDateWithTime() {
        java.sql.Date date = new java.sql.Date(0);
        String result = LessonTwo.beautyDate(date,formatTime);
        assertEquals(result, value2Time);
    }

    @Test
    public void testObject() {
        Object object = new Object();
        String result = LessonTwo.beautyDate(object,format);
        assertNull(result);
    }
}