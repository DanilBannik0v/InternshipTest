package ru.webbee.test.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class ProductionCalendar {
    private final ArrayList<Integer> mayWeekendDays = new ArrayList<>(Arrays.asList(1,4,5,9,10,11,12,18,19,25,26));
    private List<LocalDate> weekendList = new ArrayList<>();

    public ProductionCalendar() {
        mayWeekendDays.forEach(day -> this.weekendList.add(LocalDate.of(2024,5,day)));
    }
}
