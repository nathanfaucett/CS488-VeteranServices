package edu.jsu.veteran_services;


import java.sql.*;


public class StudentRecord {
    public String studentid;
    public byte[] certificateofeligibility;
    public byte[] statementofunderstanding;
    public byte[] classregistration;
    public byte[] transcript;
    public byte[] specialforms;
    public byte[] appeals;
    public byte[] studentinteractions;


    public StudentRecord(ResultSet set) {
        try {
            studentid = set.getString("studentid");
            Blob ce = set.getBlob("certificateofeligibility");
            Blob su = set.getBlob("statementofunderstanding");
            Blob cr = set.getBlob("classregistration");
            Blob t = set.getBlob("transcript");
            Blob sf = set.getBlob("specialforms");
            Blob a = set.getBlob("appeals");
            Blob si = set.getBlob("studentinteractions");

            certificateofeligibility = ce.getBytes(1, (int) ce.length());
            statementofunderstanding = su.getBytes(1, (int) su.length());
            classregistration = cr.getBytes(1, (int) cr.length());
            transcript = t.getBytes(1, (int) t.length());
            specialforms = sf.getBytes(1, (int) sf.length());
            appeals = a.getBytes(1, (int) a.length());
            studentinteractions = si.getBytes(1, (int) si.length());
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
