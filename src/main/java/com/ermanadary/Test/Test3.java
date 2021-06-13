package com.ermanadary.Test;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;

public class Test3 {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/periodicals_db", "testuser", "testpass");
            PreparedStatement pstmt = conn.prepareStatement("UPDATE subscriptions SET start_date=? WHERE subscription_id=2");

            Date date = new Date();



            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 3);
            Timestamp timestamp1 = new Timestamp(calendar.getTime().getTime());








            pstmt.setTimestamp(1, timestamp1);

            pstmt.executeUpdate();

            conn.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}