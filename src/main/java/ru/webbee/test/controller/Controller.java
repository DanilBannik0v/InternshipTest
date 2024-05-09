package ru.webbee.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.webbee.test.model.ProductionCalendar;
import ru.webbee.test.service.ProductionCalendarService;
import ru.webbee.test.service.ProductionCalendarServiceImpl;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/web-bee")
public class Controller {
    private final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    private final DateTimeFormatter ZONED_DATE_FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy'T'HH:mm:ss z");
    private final ProductionCalendarService productionCalendarServiceImpl = new ProductionCalendarServiceImpl();

    @GetMapping(value = "/")
    public String getPage(){
        return "welcome";
    }

    @GetMapping(value = "/checkDate")
    public String checkDate(@RequestBody String date){
        return String.valueOf(productionCalendarServiceImpl.checkDate(LocalDate.parse(date, LOCAL_DATE_FORMATTER), new ProductionCalendar()));
    }

    @GetMapping(value = "/checkDateWithTime")
    public String checkDateWithTime(@RequestBody String date){
        return String.valueOf(productionCalendarServiceImpl.checkDateWithTime(ZonedDateTime.parse(date, ZONED_DATE_FORMATTER), new ProductionCalendar()));
    }
}
