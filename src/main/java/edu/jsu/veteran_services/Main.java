package edu.jsu.veteran_services;


import java.sql.*;


public class Main {

    public static void main(String[] args) {
        Sql.init("veteransservices", "root", "root");
        View view = new View();
    }
}
