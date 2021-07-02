package ru.smsoft;

import org.junit.jupiter.api.Test;

import javax.xml.datatype.XMLGregorianCalendar;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class LessonThreeTest {

    private final String stringDate = "2021.06.30";

    //Test with switch------------

    @Test
    void withSwitchXmlGregorian() {
        Object object=null;
        try{
            object = LessonThree.withSwitch(stringDate,Dates.XML_GREGORIAN_CALENDAR);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof XMLGregorianCalendar);
    }

    @Test
    void withSwitchLocalDate() {
        Object object=null;
        try{
            object = LessonThree.withSwitch(stringDate,Dates.LOCAL_DATE);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof LocalDate);
    }

    @Test
    void withSwitchLocalDateTime() {
        Object object=null;
        try{
            object = LessonThree.withSwitch(stringDate,Dates.LOCAL_DATE_TIME);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof LocalDateTime);
    }

    @Test
    void withSwitchOffsetDateTime() {
        Object object=null;
        try{
            object = LessonThree.withSwitch(stringDate,Dates.OFFSET_DATE_TIME);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof OffsetDateTime);
    }

    @Test
    void withSwitchZonedDateTime() {
        Object object=null;
        try{
            object = LessonThree.withSwitch(stringDate,Dates.ZONED_DATE_TIME);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof ZonedDateTime);
    }

    @Test
    void withSwitchInstant() {
        Object object=null;
        try{
            object = LessonThree.withSwitch(stringDate,Dates.INSTANT);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof Instant);
    }

    @Test
    void withSwitchCalendar() {
        Object object=null;
        try{
            object = LessonThree.withSwitch(stringDate,Dates.CALENDAR);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof Calendar);
    }

    @Test
    void withSwitchGregorianCalendar() {
        Object object=null;
        try{
            object = LessonThree.withSwitch(stringDate,Dates.GREGORIAN_CALENDAR);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof GregorianCalendar);
    }

    @Test
    void withSwitchUtilDate() {
        Object object=null;
        try{
            object = LessonThree.withSwitch(stringDate,Dates.UTIL_DATE);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof Date);
    }

    @Test
    void withSwitchSqlDate() {
        Object object=null;
        try{
            object = LessonThree.withSwitch(stringDate,Dates.SQL_DATE);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof java.sql.Date);
    }

    //Test abstract enum method------------

    @Test
    void withAbsEnumXmlGregorian() {
        Object object=null;
        try{
            object = LessonThree.abstractEnum(stringDate,Dates.XML_GREGORIAN_CALENDAR);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof XMLGregorianCalendar);
    }

    @Test
    void withAbsEnumLocalDate() {
        Object object=null;
        try{
            object = LessonThree.abstractEnum(stringDate,Dates.LOCAL_DATE);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof LocalDate);
    }

    @Test
    void withAbsEnumLocalDateTime() {
        Object object=null;
        try{
            object = LessonThree.abstractEnum(stringDate,Dates.LOCAL_DATE_TIME);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof LocalDateTime);
    }

    @Test
    void withAbsEnumOffsetDateTime() {
        Object object=null;
        try{
            object = LessonThree.abstractEnum(stringDate,Dates.OFFSET_DATE_TIME);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof OffsetDateTime);
    }

    @Test
    void withAbsEnumZonedDateTime() {
        Object object=null;
        try{
            object = LessonThree.abstractEnum(stringDate,Dates.ZONED_DATE_TIME);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof ZonedDateTime);
    }

    @Test
    void withAbsEnumInstant() {
        Object object=null;
        try{
            object = LessonThree.abstractEnum(stringDate,Dates.INSTANT);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof Instant);
    }

    @Test
    void withAbsEnumCalendar() {
        Object object=null;
        try{
            object = LessonThree.abstractEnum(stringDate,Dates.CALENDAR);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof Calendar);
    }

    @Test
    void withAbsEnumGregorianCalendar() {
        Object object=null;
        try{
            object = LessonThree.abstractEnum(stringDate,Dates.GREGORIAN_CALENDAR);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof GregorianCalendar);
    }

    @Test
    void withAbsEnumUtilDate() {
        Object object=null;
        try{
            object = LessonThree.abstractEnum(stringDate,Dates.UTIL_DATE);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof Date);
    }

    @Test
    void withAbsEnumSqlDate() {
        Object object=null;
        try{
            object = LessonThree.abstractEnum(stringDate,Dates.SQL_DATE);
        }catch (Exception e){
            fail();
        }
        assertTrue(object instanceof java.sql.Date);
    }
}