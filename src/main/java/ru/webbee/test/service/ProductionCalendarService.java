package ru.webbee.test.service;

import ru.webbee.test.model.ProductionCalendar;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public interface ProductionCalendarService {
    boolean checkDate(LocalDate localDate, ProductionCalendar productionCalendar);
    boolean checkDateWithTime(ZonedDateTime zonedDateTime, ProductionCalendar productionCalendar);
}
