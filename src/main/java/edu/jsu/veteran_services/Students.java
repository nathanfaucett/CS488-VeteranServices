package edu.jsu.veteran_services;


import java.sql.*;
import java.util.*;


public class Students {
    private Sql sql;


    public Students(Sql sql) {
        this.sql = sql;
    }

    public List<Student> all() {
        List<Student> students = new ArrayList<>();

        try {
            Sql.Result result = sql.query("SELECT * FROM students");

            while (result.set.next()) {
                students.add(new Student(result.set));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return students;
    }

    public Student show(int id) {
        try {
            Sql.Result result = sql.query("SELECT * FROM students WHERE id = " + id);

            while (result.set.next()) {
                return new Student(result.set);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
