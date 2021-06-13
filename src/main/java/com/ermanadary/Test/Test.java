package com.ermanadary.Test;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/periodicals_db", "testuser", "testpass");
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(2);
            Savepoint savepoint = conn.setSavepoint();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO test VALUES (DEFAULT, 'ax')", Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                System.out.println("есть ключ");
                System.out.println(rs.getInt(1));
            }
            conn.rollback();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

        public static void main2 (String[]args){
            String name = "default";
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/periodicals_db", "testuser", "testpass");
//            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE login=?");
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users VALUES(DEFAULT, ?, ?, ?, ?, ?, ?)");

                pstmt.setInt(1, 0);
                pstmt.setString(2, "log");
                pstmt.setString(3, "pass");
                pstmt.setString(4, "alex");
                pstmt.setString(5, "Voloshko");
                pstmt.setString(6, "male");
                pstmt.executeUpdate();
//            if (rs.next()) {
//                name = rs.getString("name");
//            }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

//        System.out.println(name);

        }
    }
