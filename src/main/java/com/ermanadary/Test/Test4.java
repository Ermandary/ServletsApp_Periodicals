package com.ermanadary.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test4 {
    public static void main(String[] args) {
        Date date = new Date();
//        System.out.println(date);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        System.out.println(calendar.getTime());

//        Date date2 = new SimpleDateFormat().format(date);
        Timestamp e = new Timestamp(date.getTime());
        System.out.println(e);

        String q = new SimpleDateFormat("yyyy-MM-dd").format(e);
        System.out.println(q);


        //"YYYY-'W'ww-u"};


//        Calendar start = Calendar.getInstance();
//        start.setTimeInMillis( timeStampValue.getTime() );

//        calendar.add(Calendar.MONTH, 3);
//        System.out.println(calendar.getTime());
//
//
//        Timestamp timestamp = new Timestamp(date.getTime());
//        System.out.println(timestamp);
//
//        Timestamp timestamp1 = new Timestamp(calendar.getTime().getTime());
//        System.out.println(timestamp1);
//
////        Timestamp qw =
//
//
//        BigDecimal w = new BigDecimal(12);

//        BigDecimal resultBalance = user.getBalance().divide(totalPrice);
//        BigDecimal q1 = new BigDecimal(10);
//        BigDecimal q2 = new BigDecimal(8);
//        BigDecimal result = q1.divide(q2);
//        System.out.println(result);


//        BigDecimal q = w.m;


    }
}
