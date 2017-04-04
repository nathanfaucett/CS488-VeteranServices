package edu.jsu.veteran_services;


import java.sql.*;


public class Student {
    public String studentid;
    public String firstname;
    public String lastname;
    public String ssn;
    public String email;
    public String street;
    public String city;
    public String state;
    public int zipcode;
    public float gpa;
    public int hoursenrolled;
    public int repeating;
    public String major;
    public float tuitionandfees;
    public int veteranbenefits;
    public int dependentbenefits;
    public int disabilitybenefirts;


    public Student(ResultSet set) {
        try {
            studentid = set.getString("studentid");
            firstname = set.getString("firstname");
            lastname = set.getString("lastname");
            ssn = set.getString("ssn");
            email = set.getString("email");
            street = set.getString("street");
            city = set.getString("city");
            state = set.getString("state");
            zipcode = set.getInt("zipcode");
            gpa = set.getFloat("gpa");
            hoursenrolled = set.getInt("hoursenrolled");
            repeating = set.getInt("repeating");
            major = set.getString("major");
            tuitionandfees = set.getFloat("tuitionandfees");
            veteranbenefits = set.getInt("veteranbenefits");
            dependentbenefits = set.getInt("dependentbenefits");
            disabilitybenefirts = set.getInt("disabilitybenefirts");
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
