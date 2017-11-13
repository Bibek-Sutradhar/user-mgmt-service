package com.cts.user_mgmt_service.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestClass {

    public static void main(String[] args) {

        /*Date date = new Date("12/12/1986");
        SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
        Date formattedDate = null;*/
        String dayAndMonth = null;
        String dayValue = null;
        String monthValue = null;
        String startDate1 = "09/06/2017";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate date = LocalDate.parse(startDate1, formatter);
        System.out.println("Date object is ::" + date);

        monthValue = String.valueOf(date.getMonthValue());
        dayValue = String.valueOf(date.getDayOfMonth());
        System.out.println("Day value is ::" + dayValue) ;
        System.out.println("Month value is ::" + monthValue) ;



       /* if(date != null){
            try {
                formattedDate = sdf.parse(sdf.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.print("Formatted Date"+ formattedDate);
        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = formattedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (localDate != null){
            monthValue = String.valueOf(localDate.getMonthValue());
            dayValue = String.valueOf(localDate.getDayOfMonth());
        }

        System.out.print("Month value is:: " + monthValue + "/n");
        System.out.print("Day value is :: " + dayValue + "/n");

        if(dayValue != null && dayValue.length() == 1){
            dayValue = "0"+dayValue;
        }

        if (monthValue != null && monthValue.length() == 1){
            monthValue = "0" + monthValue;
        }

        System.out.println( dayAndMonth = dayValue + monthValue);*/
    }
}
