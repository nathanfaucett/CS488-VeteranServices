package edu.jsu.veteran_services;


import java.sql.*;


public class Main {

    public static void main(String[] args) {
        Sql sql = new Sql("test_db", "root", "root");

        try {
            Sql.Result result = sql.query("SELECT * FROM examples");
            while (result.set.next()) {
                System.out.println("id: " + result.set.getInt("id"));
            }
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        sql.disconnect();
    }
}
