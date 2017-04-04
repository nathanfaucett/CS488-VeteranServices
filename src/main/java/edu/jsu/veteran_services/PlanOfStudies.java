package edu.jsu.veteran_services;


import java.sql.*;
import java.util.*;


public class PlanOfStudies {
    private Sql sql;


    public PlanOfStudies(Sql sql) {
        this.sql = sql;
    }

    public List<PlanOfStudy> all() {
        List<PlanOfStudy> studentrecords = new ArrayList<>();

        try {
            Sql.Result result = sql.query("SELECT * FROM planofstudy");

            while (result.set.next()) {
                studentrecords.add(new PlanOfStudy(result.set));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return studentrecords;
    }

    public PlanOfStudy show(String studentid) {
        try {
            Sql.Result result = sql.query("SELECT * FROM planofstudy WHERE studentid = " + studentid);

            while (result.set.next()) {
                return new PlanOfStudy(result.set);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public PlanOfStudy create(
        String studentid,
        String coursenumber,
        String coursename,
        int passed
    ) {
        try {
            PreparedStatement ps = sql.prepare(
                "INSERT INTO planofstudy ("+
                    "studentid,"+
                    "coursenumber,"+
                    "coursename,"+
                    "passed"+
                ") VALUES (?, ?, ?, ?)"
            );

            ps.setString(1, studentid);
            ps.setString(2, coursenumber);
            ps.setString(3, coursename);
            ps.setInt(4, passed);
            ps.executeUpdate();

            ps.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return show(studentid);
    }
}
