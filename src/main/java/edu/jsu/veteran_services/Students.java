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
            Sql.Result result = sql.query("SELECT * FROM student");

            while (result.set.next()) {
                students.add(new Student(result.set));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return students;
    }

    public Student show(String studentid) {
        try {
            Sql.Result result = sql.query("SELECT * FROM student WHERE studentid = " + studentid);

            while (result.set.next()) {
                return new Student(result.set);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public Student showEmail(String email) {
        try {
            Sql.Result result = sql.query("SELECT * FROM student WHERE email = " + email);

            while (result.set.next()) {
                return new Student(result.set);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public List<Student> findRepeating(boolean repeating) {
        List<Student> students = new ArrayList<>();
        
        try {
            Sql.Result result = sql.query("SELECT * FROM student WHERE repeating = " + (repeating ? "true" : "false"));

            while (result.set.next()) {
                students.add(new Student(result.set));
            }

            return students;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return students;
    }

    public PreparedStatement create() {
        return sql.prepare(
            "INSERT INTO student ("+
                "studentid,"+
                "firstname,"+
                "lastname,"+
                "ssn,"+
                "email,"+
                "street,"+
                "city,"+
                "state,"+
                "major,"+
                "zipcode,"+
                "hoursenrolled,"+
                "gpa,"+
                "tuitionandfees,"+
                "repeating,"+
                "veteranbenefits,"+
                "dependentbenefits,"+
                "disabilitybenefirts"+
            ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );
    }

    public Student create(
        String studentid,
        String firstname,
        String lastname,
        String ssn,
        String email,
        String street,
        String city,
        String state,
        String major,
        int zipcode,
        int hoursenrolled,
        float gpa,
        float tuitionandfees,
        int repeating,
        int veteranbenefits,
        int dependentbenefits,
        int disabilitybenefirts
    ) {
        try {
            PreparedStatement ps = sql.prepare(
                "INSERT INTO student ("+
                    "studentid,"+
                    "firstname,"+
                    "lastname,"+
                    "ssn,"+
                    "email,"+
                    "street,"+
                    "city,"+
                    "state,"+
                    "major,"+
                    "zipcode,"+
                    "hoursenrolled,"+
                    "gpa,"+
                    "tuitionandfees,"+
                    "repeating,"+
                    "veteranbenefits,"+
                    "dependentbenefits,"+
                    "disabilitybenefirts"+
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, studentid);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, ssn);
            ps.setString(5, email);
            ps.setString(6, street);
            ps.setString(7, city);
            ps.setString(8, state);
            ps.setString(9, major);
            ps.setInt(10, zipcode);
            ps.setInt(11, hoursenrolled);
            ps.setFloat(12, gpa);
            ps.setFloat(13, tuitionandfees);
            ps.setInt(14, repeating);
            ps.setInt(15, veteranbenefits);
            ps.setInt(16, dependentbenefits);
            ps.setInt(17, disabilitybenefirts);

            ps.executeUpdate();
            ps.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return show(studentid);
    }
}
