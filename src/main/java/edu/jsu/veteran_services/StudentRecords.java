package edu.jsu.veteran_services;


import java.sql.*;
import java.util.*;


public class StudentRecords {
    private Sql sql;


    public StudentRecords(Sql sql) {
        this.sql = sql;
    }

    public List<StudentRecord> all() {
        List<StudentRecord> studentrecords = new ArrayList<>();

        try {
            Sql.Result result = sql.query("SELECT * FROM studentrecords");

            while (result.set.next()) {
                studentrecords.add(new StudentRecord(result.set));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return studentrecords;
    }

    public StudentRecord show(String studentid) {
        try {
            Sql.Result result = sql.query("SELECT * FROM studentrecords WHERE studentid = " + studentid);

            while (result.set.next()) {
                return new StudentRecord(result.set);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public StudentRecord create(
        String studentid,
        Blob certificateofeligibility,
        Blob statementofunderstanding,
        Blob classregistration,
        Blob transcript,
        Blob specialforms,
        Blob appeals,
        Blob studentinteractions
    ) {
        try {
            PreparedStatement ps = sql.prepare(
                "INSERT INTO studentrecords ("+
                    "studentid,"+
                    "certificateofeligibility,"+
                    "statementofunderstanding,"+
                    "classregistration,"+
                    "transcript,"+
                    "specialforms,"+
                    "appeals,"+
                    "studentinteractions"+
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, studentid);
            ps.setBlob(2, certificateofeligibility);
            ps.setBlob(3, statementofunderstanding);
            ps.setBlob(4, classregistration);
            ps.setBlob(5, transcript);
            ps.setBlob(6, specialforms);
            ps.setBlob(7, appeals);
            ps.setBlob(8, studentinteractions);
            ps.executeUpdate();

            ps.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return show(studentid);
    }
}
