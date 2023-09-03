package com.diegodev.ditech.application.rest.converters;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter {

    private LocalDateTimeConverter() {
        // empty private constructor to avoid sonar code smell "Utility classes should not have public constructors"
    }

    public static LocalDateTime parseDateTime(String dateTime) {
        final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return StringUtils.isNotBlank(dateTime) ? dateTimeFormat.parse(dateTime, LocalDateTime::from) : null;
    }

}