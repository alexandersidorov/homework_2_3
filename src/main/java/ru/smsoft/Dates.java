package ru.smsoft;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public enum Dates {
    XML_GREGORIAN_CALENDAR{
        @Override
        public Object getObjectDate(String date) throws DatatypeConfigurationException {
            final String format = "yyyy.MM.dd";
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
            return DatatypeFactory
                    .newInstance()
                    .newXMLGregorianCalendar(localDate.toString());
        }
    },
    LOCAL_DATE{
        @Override
        public Object getObjectDate(String date) {
            final String format = "yyyy.MM.dd";
            return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
        }
    },
    LOCAL_DATE_TIME{
        @Override
        public Object getObjectDate(String date) {
            final String format = "yyyy.MM.dd";
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
            return LocalDateTime.of(localDate, LocalTime.of(0,0));
        }
    },
    OFFSET_DATE_TIME{
        @Override
        public Object getObjectDate(String date) {
            final String format = "yyyy.MM.dd";
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
            return OffsetDateTime.of(localDate,LocalTime.of(0,0), ZoneOffset.UTC);
        }
    },
    ZONED_DATE_TIME {
        @Override
        public Object getObjectDate(String date) {
            final String format = "yyyy.MM.dd";
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
            return ZonedDateTime.of(localDate,LocalTime.of(0,0),ZoneOffset.UTC);
        }
    },
    INSTANT {
        @Override
        public Object getObjectDate(String date) {
            final String format = "yyyy.MM.dd";
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
            return OffsetDateTime.of(localDate,LocalTime.of(0,0),ZoneOffset.UTC)
                    .toInstant();
        }
    },
    CALENDAR {
        @Override
        public Object getObjectDate(String date) {
            final String format = "yyyy.MM.dd";
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
            LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.of(0,0));
            return new GregorianCalendar(
                    localDateTime.getYear(),
                    localDateTime.getMonthValue(),
                    localDateTime.getDayOfMonth(),
                    localDateTime.getHour(),
                    localDateTime.getMinute(),
                    localDateTime.getSecond()
            );
        }
    },
    UTIL_DATE {
        @Override
        public Object getObjectDate(String date) {
            final String format = "yyyy.MM.dd";
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
            return new Date(OffsetDateTime.of(localDate,LocalTime.of(0,0),ZoneOffset.UTC)
                    .toEpochSecond());
        }
    },
    SQL_DATE {
        @Override
        public Object getObjectDate(String date) {
            final String format = "yyyy.MM.dd";
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
            return new java.sql.Date(OffsetDateTime.of(localDate,LocalTime.of(0,0),ZoneOffset.UTC)
                    .toEpochSecond());
        }
    },
    GREGORIAN_CALENDAR {
        @Override
        public Object getObjectDate(String date) {
            final String format = "yyyy.MM.dd";
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
            LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.of(0,0));
            return new GregorianCalendar(
                    localDateTime.getYear(),
                    localDateTime.getMonthValue(),
                    localDateTime.getDayOfMonth(),
                    localDateTime.getHour(),
                    localDateTime.getMinute(),
                    localDateTime.getSecond()
            );
        }
    };

    public abstract Object getObjectDate(String date) throws DatatypeConfigurationException;
}
