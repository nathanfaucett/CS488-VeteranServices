package edu.jsu.veteran_services;


import java.sql.*;


public class PlanOfStudy {
    public String studentid;
    public String coursenumber;
    public String coursename;
    public int passed;


    public PlanOfStudy(ResultSet set) {
        try {
            studentid = set.getString("studentid");
            coursenumber = set.getString("coursenumber");
            coursename = set.getString("coursename");
            passed = set.getInt("passed");
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
