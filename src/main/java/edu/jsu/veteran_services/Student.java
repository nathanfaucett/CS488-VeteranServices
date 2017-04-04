package edu.jsu.veteran_services;


import java.sql.*;


public class Student {
    private int id;


    public Student(int id) {
        this.id = id;
    }

    public Student(ResultSet set) {
        try {
            this.id = set.getInt("id");
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
