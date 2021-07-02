package ru.smsoft;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class LessonThree {

    public static Object withSwitch(String date,Dates dateType) throws DatatypeConfigurationException {
        final String format = "yyyy.MM.dd";
        Object retObject;
        switch (dateType){
            case XML_GREGORIAN_CALENDAR->{
                LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
                retObject = DatatypeFactory
                        .newInstance()
                        .newXMLGregorianCalendar(localDate.toString());
            }
            case LOCAL_DATE->{
                retObject = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
            }
            case LOCAL_DATE_TIME->{
                LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
                retObject = LocalDateTime.of(localDate, LocalTime.of(0,0));
            }
            case OFFSET_DATE_TIME->{
                LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
                retObject = OffsetDateTime.of(localDate,LocalTime.of(0,0),ZoneOffset.UTC);
            }
            case ZONED_DATE_TIME->{
                LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
                retObject = ZonedDateTime.of(localDate,LocalTime.of(0,0),ZoneOffset.UTC);
            }
            case INSTANT->{
                LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
                retObject = OffsetDateTime.of(localDate,LocalTime.of(0,0),ZoneOffset.UTC)
                        .toInstant();
            }
            case CALENDAR, GREGORIAN_CALENDAR->{
                LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
                LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.of(0,0));
                retObject = new GregorianCalendar(
                        localDateTime.getYear(),
                        localDateTime.getMonthValue(),
                        localDateTime.getDayOfMonth(),
                        localDateTime.getHour(),
                        localDateTime.getMinute(),
                        localDateTime.getSecond()
                        );
            }
            case UTIL_DATE->{
                LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
                retObject = new Date(OffsetDateTime.of(localDate,LocalTime.of(0,0),ZoneOffset.UTC)
                        .toEpochSecond());
            }
            case SQL_DATE->{
                LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
                retObject = new java.sql.Date(OffsetDateTime.of(localDate,LocalTime.of(0,0),ZoneOffset.UTC)
                        .toEpochSecond());
            }
            default -> retObject = null;
        }

        return retObject;
    }

    public static Object abstractEnum(String date,Dates dateType) throws DatatypeConfigurationException {
        return dateType.getObjectDate(date);
    }
}
