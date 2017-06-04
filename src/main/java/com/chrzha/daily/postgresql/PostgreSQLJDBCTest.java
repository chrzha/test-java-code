package com.chrzha.daily.postgresql;

import java.sql.*;

/**
 * Created by Chris Zhang on 2017/6/4.
 */
public class PostgreSQLJDBCTest {

    public static void main(String[] args) {
        System.out.println();
        Connection con = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/test",
                            "postgres", "admin");
            statement = con.createStatement();
            String sql = "select * from journalarticle " +
                    "where articleid is NULL or articleid - FLOOR(articleid) < 0.1";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getLong(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    statement.close();
                    con.close();
                } catch (SQLException se) {
                    System.out.println(se);
                }
            }
        }
    }

}
