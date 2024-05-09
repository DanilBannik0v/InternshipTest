package ru.webbee.test.service;

import ru.webbee.test.model.ProductionCalendar;

import java.time.*;

public class ProductionCalendarServiceImpl implements ProductionCalendarService{
    private static final ZoneId MOSCOW_ZONE_ID = ZoneId.of("Europe/Moscow");
    private static final LocalTime workDayBeginning = LocalTime.of(9, 0);
    private static final LocalTime workDayEnding = LocalTime.of(18, 0);

    @Override
    public boolean checkDate(LocalDate localDate, ProductionCalendar productionCalendar) {
        return productionCalendar.getWeekendList().contains(localDate);
    }

    @Override
    public boolean checkDateWithTime(ZonedDateTime zonedDateTime, ProductionCalendar productionCalendar) {
        ZonedDateTime moscowTimeZonedDateTime = zonedDateTime.withZoneSameInstant(MOSCOW_ZONE_ID);
        LocalDate localDate = moscowTimeZonedDateTime.toLocalDate();
        LocalTime localTime = moscowTimeZonedDateTime.toLocalTime();

        return !(!productionCalendar.getWeekendList().contains(localDate) & (localTime.isAfter(workDayBeginning) & localTime.isBefore(workDayEnding)));
    }
}
