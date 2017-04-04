package edu.jsu.veteran_services;


import java.sql.*;

import edu.jsu.veteran_services.Sql;

import static org.junit.Assert.*;
import org.junit.*;


public class SqlTest {
    @Test
    public void testConnectDisconnect() {
        Sql sql = new Sql("test_db", "root", "root");

        assertTrue(sql.isConnected());
        sql.disconnect();
        assertFalse(sql.isConnected());
    }

    @Test
    public void testQuery() {
        Sql sql = new Sql("test_db", "root", "root");

        try {
            Sql.Result result = sql.query("SELECT * FROM examples");
            while (result.set.next()) {
                System.out.println("id: " + result.set.getInt("id"));
            }
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        sql.disconnect();
    }
}
