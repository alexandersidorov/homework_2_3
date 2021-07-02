package ru.smsoft;

import lombok.extern.slf4j.Slf4j;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Slf4j
public class LessonTwo {
    public static String beautyDate(Object date,String format){
        String retDateStr=null;
        if(date instanceof XMLGregorianCalendar knowDate){

            LocalDateTime localDateTime = LocalDateTime.of(
                    ChronoField.YEAR.range().isValidValue(knowDate.getYear())?knowDate.getYear():0,
                    ChronoField.MONTH_OF_YEAR.range().isValidValue(knowDate.getMonth())?knowDate.getMonth():0,
                    ChronoField.DAY_OF_MONTH.range().isValidValue(knowDate.getDay())?knowDate.getDay():0,
                    ChronoField.HOUR_OF_DAY.range().isValidValue(knowDate.getHour())?knowDate.getHour():0,
                    ChronoField.MINUTE_OF_DAY.range().isValidValue(knowDate.getMinute())?knowDate.getMinute():0,
                    ChronoField.SECOND_OF_DAY.range().isValidValue(knowDate.getSecond())?knowDate.getSecond():0,
                    ChronoField.NANO_OF_SECOND.range().isValidValue(knowDate.getMillisecond())?knowDate.getMillisecond():0
            );
            retDateStr = localDateTime.format(DateTimeFormatter.ofPattern(format));

        }else if(date instanceof LocalDate knowDate){

            retDateStr = knowDate.format(DateTimeFormatter.ofPattern(format));

        }else if(date instanceof LocalDateTime knownDate){

            retDateStr = knownDate.format(DateTimeFormatter.ofPattern(format));

        }else if(date instanceof OffsetDateTime knownDate){

            retDateStr = knownDate.format(DateTimeFormatter.ofPattern(format));

        }else if (date instanceof ZonedDateTime knownDate){

            retDateStr = knownDate.format(DateTimeFormatter.ofPattern(format));

        }else if(date instanceof Instant knownDate){

            LocalDateTime localDateTime = LocalDateTime.ofInstant(knownDate,ZoneOffset.UTC);
            retDateStr = localDateTime.format(DateTimeFormatter.ofPattern(format));

        }else if(!date.getClass().equals(GregorianCalendar.class) && date instanceof Calendar knownDate){

            LocalDateTime localDateTime = LocalDateTime.ofInstant(knownDate.toInstant(),ZoneOffset.UTC);
            retDateStr = localDateTime.format(DateTimeFormatter.ofPattern(format));

        }else if(date instanceof GregorianCalendar knownDate){

            LocalDateTime localDateTime = LocalDateTime.ofInstant(knownDate.toInstant(),ZoneOffset.UTC);
            retDateStr = localDateTime.format(DateTimeFormatter.ofPattern(format));

        }else if(!date.getClass().equals(java.sql.Date.class) && date instanceof java.util.Date knownDate){

            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(knownDate.getTime()),ZoneOffset.UTC);
            retDateStr = localDateTime.format(DateTimeFormatter.ofPattern(format));

        }else if(date instanceof java.sql.Date knownDate){

            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(knownDate.getTime()),ZoneOffset.UTC);
            retDateStr = localDateTime.format(DateTimeFormatter.ofPattern(format));

        }else{
            log.info("Is not date !");
        }

        return retDateStr;
    }
}
