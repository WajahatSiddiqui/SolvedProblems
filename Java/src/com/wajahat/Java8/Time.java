package com.wajahat.Java8;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Time {

    @Test
    public void test() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.minusMinutes(1));

        LocalDateTime time = LocalDateTime.of(LocalDate.of(2019, 3, 12), LocalTime.of (0, 0, 0));
        System.out.println(time);

        LocalDate date = LocalDate.now();
        System.out.println(date.isLeapYear());
    }

    public Timestamp convertToSQLTime(LocalDateTime time) {
        return Timestamp.valueOf(time);
    }

    public LocalDateTime convertToLocal(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }
}
