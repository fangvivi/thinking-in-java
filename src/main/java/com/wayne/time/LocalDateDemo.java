package com.wayne.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * @author wayne
 */
public class LocalDateDemo {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthday = LocalDate.parse("1956-02-29", formatter);
        LocalDate applyDate = LocalDate.parse("2022-03-01", formatter);
        Period between = Period.between(birthday, applyDate);
        System.out.println(between.getYears());
    }

}
