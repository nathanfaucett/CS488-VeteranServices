package edu.jsu.veteran_services;


import java.sql.*;


public class Main {

    public static void main(String[] args) {
        Sql sql = new Sql("test_db", "root", "root");
        View view = new View();
        view.add(new StudentView(sql));
    }
}
